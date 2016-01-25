package com.star.people.controller.view;

import com.star.people.enums.ArticleStatus;
import com.star.people.model.ArticleInfoVO;
import com.star.people.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zuhai.jiang on 2016/1/25.
 */
@Controller
public class RootController {

    private Logger logger = LoggerFactory.getLogger(RootController.class);

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView recentAbstractView(){
        logger.info("");
        ModelAndView view = new ModelAndView("content/abstract");
        ArticleInfoVO info = articleService.getRecentArticleInfo();
        if (info!=null && info.getStatus() == ArticleStatus.AVAILABLE) {
            view.addObject("articleInfo", info);
            return view;
        }
        return ErrorController.MISS_PAGE;
    }
}
