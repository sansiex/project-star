package com.star.people.controller.view;

import com.star.people.enums.ArticleStatus;
import com.star.people.model.ArticleInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zuhai.jiang on 2015/12/24.
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    private Logger logger = LoggerFactory.getLogger(ErrorController.class);

    public static final ModelAndView MISS_PAGE = new ModelAndView("common/404");
//    public static final String URL_MISS_PAGE = "/error/misspage";

    @RequestMapping(value = "/misspage", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView missPage(){
        logger.info("");
        return MISS_PAGE;
    }
}
