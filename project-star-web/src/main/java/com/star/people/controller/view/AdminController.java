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

    @RequestMapping(value = "/abstract", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAbstract() {
        logger.info("create abstract");
        ModelAndView view = new ModelAndView("admin/editAbstract");
        ArticleInfoVO vo = new ArticleInfoVO();
        vo.setId(-1);
        vo.setPublishtime(new Date());
        view.addObject("articleInfo", vo);
        return view;
    }

    @RequestMapping(value = "/abstract/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAbstract(@PathVariable("id") int id) {
        logger.info("id:{}", id);
        ModelAndView view = new ModelAndView("admin/editAbstract");
        ArticleInfoVO info = articleService.getArticleInfo(id, false);
        if (info == null) {
            info = new ArticleInfoVO();
            info.setId(id);
        }
        view.addObject("articleInfo", info);
        return view;
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getArticleContent(@PathVariable("id") int id) {
        logger.info("id:{}", id);
        ModelAndView view = new ModelAndView("admin/editArticle");
        ArticleContentVO vo = articleService.getArticleContent(id, false);
        if (vo == null) {
            return ErrorController.MISS_PAGE;
        }
        view.addObject("id", id);
        return view;
    }
}
