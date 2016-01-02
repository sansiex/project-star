package com.star.people.controller.view;

import com.star.people.dto.Response;
import com.star.people.enums.ArticleStatus;
import com.star.people.model.ArticleContentVO;
import com.star.people.model.ArticleInfoVO;
import com.star.people.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Created by zuhai.jiang on 2015/12/9.
 */
@Controller
@RequestMapping("/content")
public class ArticleController {

    private Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/abstract", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView recentAbstractView(){
        logger.info("");
        ModelAndView view = new ModelAndView("content/abstract");
        ArticleInfoVO info = articleService.getRecentArticleInfo();
        if (info!=null && info.getStatus() == ArticleStatus.AVAILABLE) {
            view.addObject("articleInfo", info);
            return view;
        }
//        return new ModelAndView(ErrorController.URL_MISS_PAGE);
        return ErrorController.MISS_PAGE;
    }

    @RequestMapping(value = "/abstract/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView abstractView(@PathVariable("id") int id){
        logger.info("id:{}", id);
        ModelAndView view = new ModelAndView("content/abstract");
        ArticleInfoVO info = articleService.getArticleInfo(id);
        if (info!=null && info.getStatus() == ArticleStatus.AVAILABLE) {
            view.addObject("articleInfo", info);
            return view;
        }
//        return new ModelAndView(ErrorController.URL_MISS_PAGE);
        return ErrorController.MISS_PAGE;
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView article(@PathVariable("id") int id){
        logger.info("id:{}", id);
        ModelAndView view = new ModelAndView("content/article");
        ArticleContentVO content = articleService.getArticleContent(id);
        if (content!=null && content.getStatus() == ArticleStatus.AVAILABLE) {
            view.addObject("articleContent", content);
            return view;
        }
//        return new ModelAndView("redirect:"+ErrorController.URL_MISS_PAGE);
        return ErrorController.MISS_PAGE;
    }


}
