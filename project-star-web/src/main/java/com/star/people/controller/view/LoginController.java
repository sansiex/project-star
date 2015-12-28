package com.star.people.controller.view;

import com.star.people.dto.Response;
import com.star.people.exception.ServiceException;
import com.star.people.model.ArticleInfoVO;
import com.star.people.model.UserVO;
import com.star.people.service.LoginService;
import com.star.people.util.EncodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by zuhai.jiang on 2015/12/27.
 */
@Controller
@RequestMapping("/priviledge")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    public static final String COOKIE_USER = "user";
    public static final String SESSION_USER = "user";

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView login() {
        logger.info("");
        ModelAndView view = new ModelAndView("admin/adminLogin");
        return view;
    }

    @RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
    @ResponseBody
    public Response<Boolean> loginAdmin(
            HttpServletRequest req
            ,HttpServletResponse response
            ,String username, String password) {
        logger.info("user:{}", username);
        Response<Boolean> resp = new Response<>();
        try {
            UserVO userVO = loginService.loginAdmin(username, password);

            if (userVO != null) {
                resp.setResultMessage("登录成功");
                resp.setResult(true);
                String userstr = EncodeUtil.encodeBase64(username+"|"+password);
                Cookie cookie = new Cookie(COOKIE_USER, userstr);
                cookie.setMaxAge(60 * 60 * 24 * 7);
                cookie.setPath("/");
                response.addCookie(cookie);
                HttpSession session = req.getSession();
                session.setAttribute("user", userVO);
            } else {
                logger.error("登录失败，username:{}", username);
            }

            return resp;
        } catch (ServiceException e) {
            logger.error("登录失败，username:{}, msg:{}", username, e.getMessage());
            resp.setResult(false);
            resp.setResultMessage(e.getMessage());
            return resp;
        }
    }
}
