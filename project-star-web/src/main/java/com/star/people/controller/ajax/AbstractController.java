package com.star.people.controller.ajax;

import com.star.people.dto.Response;
import com.star.people.model.ArticleInfoVO;
import com.star.people.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zuhai.jiang on 2016/1/2.
 */
@Controller
@RequestMapping("/abstract")
public class AbstractController {

    private Logger logger = LoggerFactory.getLogger(AbstractController.class);

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public Response<ArticleInfoVO> getAbstract(int id){
        logger.info("id:{}", id);
        Response<ArticleInfoVO> resp = new Response<ArticleInfoVO>();
        ArticleInfoVO info = articleService.getArticleInfo(id, true);
        resp.setResult(info);
//        return new ModelAndView(ErrorController.URL_MISS_PAGE);
        return resp;
    }

    @RequestMapping(value = "/before", method = RequestMethod.POST)
    @ResponseBody
    public Response<List<ArticleInfoVO>> getBeforeAbstracts(String publishtime) {
        logger.info("publishtime:{}", publishtime);
        Response<List<ArticleInfoVO>> resp = new Response<>();
        List<ArticleInfoVO> list = articleService.getBeforeArticleInfoList(publishtime, 1);
        resp.setResult(list);
        return resp;
    }

    @RequestMapping(value = "/after", method = RequestMethod.POST)
    @ResponseBody
    public Response<List<ArticleInfoVO>> getAfterAbstracts(String publishtime) {
        logger.info("publishtime:{}", publishtime);
        Response<List<ArticleInfoVO>> resp = new Response<>();
        List<ArticleInfoVO> list = articleService.getAfterArticleInfoList(publishtime, 1);
        resp.setResult(list);
        return resp;
    }
}
