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
 * Created by zuhai.jiang on 2016/1/25.
 */
@Controller
@RequestMapping("/campaign")
public class CampaignController {

    private Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @RequestMapping(value = "/matchpeople/{page}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView matchpeople(@PathVariable("page") String page){
        logger.info("");
        ModelAndView view = new ModelAndView("campaign/matchpeople/"+page);
        return view;
    }
}
