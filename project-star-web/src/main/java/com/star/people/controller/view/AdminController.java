package com.star.people.controller.view;

import com.star.people.dto.Response;
import com.star.people.enums.ArticleStatus;
import com.star.people.exception.ServiceException;
import com.star.people.model.Article;
import com.star.people.model.ArticleContentVO;
import com.star.people.model.ArticleInfoVO;
import com.star.people.model.UserVO;
import com.star.people.service.ArticleService;
import com.star.people.service.ImgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zuhai.jiang on 2015/12/26.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    ArticleService articleService;

    @Autowired
    ImgService imgService;

    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping(value = "/abstract", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAbstract() {
        logger.info("create abstract");
        ModelAndView view = new ModelAndView("admin/editAbstract");
        ArticleInfoVO vo = new ArticleInfoVO();
        vo.setId(-1);
        view.addObject("articleInfo", vo);
        return view;
    }

    @RequestMapping(value = "/abstract/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAbstract(@PathVariable("id") int id) {
        logger.info("id:{}", id);
        ModelAndView view = new ModelAndView("admin/editAbstract");
        ArticleInfoVO info = articleService.getArticleInfo(id);
        if (info == null) {
            info = new ArticleInfoVO();
            info.setId(id);
        }
        view.addObject("articleInfo", info);
        return view;
    }

    @RequestMapping(value = "/articleContent/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getArticleContent(@PathVariable("id") int id) {
        logger.info("id:{}", id);
        ModelAndView view = new ModelAndView("admin/editArticleContent");
        ArticleContentVO vo = articleService.getArticleContent(id);
        if (vo == null) {
            return ErrorController.MISS_PAGE;
        }
        view.addObject("articleContent", vo);
        return view;
    }

    @RequestMapping(value = "/saveAbstract", method = RequestMethod.POST)
    @ResponseBody
    public Response<ArticleInfoVO> saveAbstract(HttpServletRequest req
            , Integer id, String title, String abstracttext, String imageurl, String publishtime, Integer status) {
        logger.info("id:{}, title:{}", id, title);
        Response<ArticleInfoVO> resp = new Response<>(null);
        if (id == null || id<0) {
            try {
                Article article = articleService.createArticle(getUserName(req));
                id = article.getId();
            } catch (ServiceException e) {
                resp.setResultMessage("创建摘要失败！");
                return resp;
            }
        }
        ArticleInfoVO info = articleService.getArticleInfo(id);
        if (info == null) {
            info = new ArticleInfoVO();
            info.setId(id);
        }
        info.setType(1);
        info.setTitle(title);
        info.setAbstracttext(abstracttext);
        info.setImageurl(imageurl);

        Date pt = df.parse(publishtime,  new ParsePosition(0));
        info.setPublishtime(pt);
        info.setStatus(ArticleStatus.valueOf(status));
        String user=getUserName(req);
        try {
            articleService.saveArticleInfo(info, user);
            resp.setResult(info);
            return resp;
        } catch (ServiceException e) {
            logger.error("保存摘要失败:{},{}", info.toString(), e.getMessage());
            resp.setSuccess(false);
            resp.setResultMessage(e.getMessage());
            return resp;
        }
    }

    @RequestMapping(value = "/updateArticleStatus", method = RequestMethod.POST)
    @ResponseBody
    public Response<Boolean> updateArticleStatus(HttpServletRequest req
            ,Integer id, Integer status) {
        logger.info("id:{}, status:{}", id, status);
        Response<Boolean> resp = new Response<>(true);
        boolean ret = articleService.updateArticleStatus(id, ArticleStatus.valueOf(status));
        if (!ret) {
            resp.setResult(false);
            resp.setResultMessage("更新文章状态失败。");
        }
        return resp;
    }

    @RequestMapping(value = "/saveArticleContent", method = RequestMethod.POST)
    @ResponseBody
    public Response<Boolean> saveArticleContent(HttpServletRequest req
            , Integer id, String contentTitle, String author, String linkurl, String content) {
        logger.info("id:{}, contentTitle:{}", id, contentTitle);
        Response<Boolean> resp = new Response<>(true);
        ArticleContentVO vo = articleService.getArticleContent(id);
        if (vo == null) {
            resp.setResult(false);
            resp.setResultMessage("请先创建文章摘要！");
            return resp;
        } else {
            vo = new ArticleContentVO();
            vo.setId(id);
            vo.setContent(content);
            vo.setLinkurl(linkurl);
            vo.setAuthor(author);
            vo.setContentTitle(contentTitle);
            String user=getUserName(req);
            try {
                articleService.saveArticleContent(vo, user);
                return resp;
            } catch (ServiceException e) {
                logger.error("保存文章内容失败:{},{}", vo.toString(), e.getMessage());
                resp.setResult(false);
                resp.setSuccess(false);
                resp.setResultMessage(e.getMessage());
                return resp;
            }
        }

    }

    @RequestMapping(value = "/saveAbstractImg", method = RequestMethod.POST)
    @ResponseBody
    public Response<String> saveAbstractImg(HttpServletRequest req
            , MultipartFile image) {
        String filename = image.getOriginalFilename();
        logger.info("filename:{}", filename);
        Response<String> resp = new Response<>();

        String user = getUserName(req);
        String ext = imgService.getExt(filename);
        String name = imgService.getImgName(user, ext, ArticleService.THEME_ABSTRACT);
        try {
            String url = imgService.save(image, name);
            resp.setResult(url);
        } catch (IOException e) {
            logger.error(e.getMessage());
            resp.setResultMessage(e.getMessage());
            resp.setSuccess(false);
            return resp;
        }
        return resp;
    }

    @RequestMapping(value = "/saveArticleContentImg", method = RequestMethod.POST)
    @ResponseBody
    public Response<String> saveArticleContentImg(HttpServletRequest req
            , MultipartFile image) {
        String filename = image.getOriginalFilename();
        logger.info("filename:{}",filename);
        Response<String> resp = new Response<>();

        String user = getUserName(req);
        String ext = imgService.getExt(filename);
        String name = imgService.getImgName(user, ext, ArticleService.THEME_ARTICLE_CONTENT);
        try {
            String url = imgService.save(image, name);
            resp.setResult(url);
        } catch (IOException e) {
            logger.error(e.getMessage());
            resp.setResultMessage(e.getMessage());
            resp.setSuccess(false);
            return resp;
        }
        return resp;
    }

    private String getUserName(HttpServletRequest req) {
        HttpSession sess = req.getSession();
        UserVO vo = (UserVO) sess.getAttribute(LoginController.SESSION_USER);
        String name = vo.getName();
        return name;
    }
}
