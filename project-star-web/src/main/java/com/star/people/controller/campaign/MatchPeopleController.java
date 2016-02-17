package com.star.people.controller.campaign;

import com.google.common.base.Strings;
import com.star.people.controller.BaseController;
import com.star.people.controller.view.ErrorController;
import com.star.people.dto.Response;
import com.star.people.service.campaign.MatchPeopleServie;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

/**
 * Created by zuhai.jiang on 2016/2/16.
 */
@Controller
@RequestMapping("/campaign/matchpeople")
public class MatchPeopleController extends BaseController {
    @Autowired
    private MatchPeopleServie matchPeopleServie;

    @RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView matchpeople(@PathVariable("page") String page){
        logInfo("{}", page);
        ModelAndView view = new ModelAndView("campaign/matchpeople/"+page);
        return view;
    }

    @RequestMapping(value = "/resultPage/{num}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView matchpeople(@PathVariable("num") int num){
        logInfo("{}", num);
        ModelAndView view = new ModelAndView("campaign/matchpeople/result");

        try {
            String[] result = matchPeopleServie.getMatchResult(num);
            view.addObject("name", result[0]);
            view.addObject("description", result[1]);
            return view;
        } catch (Exception e) {
            logError("结果异常，msg:{}", e.getMessage());
            return ErrorController.MISS_PAGE;
        }
    }

    @RequestMapping(value = "/getResultNum", method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> result(String answers){
        if (Strings.isNullOrEmpty(answers)) {
            return err(String.format("答案为空%s", answers));
        }
        String decodedAnswers;
        try {
            decodedAnswers = new String(Base64.decode(answers), "utf8");
            logger.info("%s are decoded to %s", answers,decodedAnswers);
        } catch (Base64DecodingException e) {
            e.printStackTrace();
            return err("答案解析异常(%s)，msg:%s", answers, e.getMessage());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return err("不支持UTF8格式(%s)，msg:%s", answers, e.getMessage());
        }

        String[] arr = decodedAnswers.split(",");
        int[] intArr = new int[arr.length];
        for (int i =0 ;i<arr.length;i++) {
            try{
                intArr[i] = Integer.parseInt(arr[i]);
            } catch (Exception e) {
                return err("第%s个答案%s不合法",i,arr[i]);
            }
        }

        try {
            return suc(Integer.class, matchPeopleServie.getMatchResultNum(intArr));
        } catch (Exception e) {
            return err("获取答案异常,msg:%s", e.getMessage());
        }
    }
}
