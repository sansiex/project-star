package com.star.people.controller.view;

import com.star.people.dto.Response;
import com.star.people.enums.ArticleStatus;
import com.star.people.exception.ServiceException;
import com.star.people.model.ArticleInfoVO;
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
import java.io.File;
import java.io.IOException;

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

    @RequestMapping(value = "/saveAbstract", method = RequestMethod.POST)
    @ResponseBody
    public Response<Boolean> saveAbstract(HttpServletRequest req
            , Integer id, String title, String abstracttext, String imageurl) {
        logger.info("id:{}, title:{}", id, title);
        Response<Boolean> resp = new Response<>(true);
        ArticleInfoVO info = articleService.getArticleInfo(id);
        if (info == null) {
            info = new ArticleInfoVO();
            info.setId(id);
        }
        info.setType(1);
        info.setTitle(title);
        info.setAbstracttext(abstracttext);
        info.setImageurl(imageurl);
        String user=getUserName(req);
        try {
            articleService.saveArticleInfo(info, user);
            return resp;
        } catch (ServiceException e) {
            logger.error("保存摘要失败:{},{}", info.toString(), e.getMessage());
            resp.setResult(false);
            resp.setSuccess(false);
            resp.setResultMessage(e.getMessage());
            return resp;
        }
    }

    @RequestMapping(value = "/saveAbstractImg", method = RequestMethod.POST)
    @ResponseBody
    public Response<String> saveImg(HttpServletRequest req
            , MultipartFile image) {
        String filename = image.getOriginalFilename();
        logger.info("filename:{}",filename);
        Response<String> resp = new Response<>();

        String user = getUserName(req);
        String ext = imgService.getExt(filename);
        String name = articleService.getAbstractImgName(user, ext);
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
        return "zuhai.jiang";
    }
}
