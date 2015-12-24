package com.star.people.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by zuhai.jiang on 2015/12/9.
 */
@Controller
@RequestMapping("/content")
public class ViewController {

    private Logger logger = LoggerFactory.getLogger(ViewController.class);

    @RequestMapping(value = "/abstract/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView abstractView(@PathVariable("id") String id){
        logger.info("id:{}", id);
        ModelAndView view = new ModelAndView("content/abstract");
        view.addObject("articleId", id);
        return view;
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView article(@PathVariable("id") String id){
        logger.info("id:{}", id);
        ModelAndView view = new ModelAndView("content/article");
        view.addObject("articleId", id);
        return view;
    }


}
