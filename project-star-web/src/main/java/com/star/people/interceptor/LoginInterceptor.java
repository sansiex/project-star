package com.star.people.interceptor;

import com.star.people.controller.view.LoginController;
import com.star.people.exception.ServiceException;
import com.star.people.model.UserVO;
import com.star.people.service.LoginService;
import com.star.people.util.EncodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by zuhai.jiang on 2015/12/27.
 */

public class LoginInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    private static final String[] filterList = {"/admin/"};

    public static int ROLE_ADMIN = 0;

    @Autowired
    LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        boolean flag = true;
        String url = req.getRequestURI();
        for (String s : filterList) {
            if (url.contains(s)) {
                flag = filter(req);
                break;
            }
        }
        if (!flag) {
            logger.info("url:{}", url);
            req.getRequestDispatcher("/priviledge/index").forward(req, resp);
        }

        return flag;
    }

    private boolean filter(HttpServletRequest req){
        HttpSession session = req.getSession();

        Object obj =  session.getAttribute(LoginController.SESSION_USER);
        if (obj != null) {
            UserVO userVO = (UserVO) obj;
            if (userVO.getRole() == ROLE_ADMIN) {
                return true;
            } else {
                return false;
            }
        }

        Cookie[] cookies = req.getCookies();
        if (cookies==null || cookies.length<1) {
            return false;
        }
        for (Cookie cookie:cookies) {
            if (LoginController.COOKIE_USER.equals(cookie.getName())) {
                String userstr = cookie.getValue();
                String[] loginInfo = EncodeUtil.decodeBase64(userstr).split("|");
                if (loginInfo.length < 2) {
                    return false;
                }
                String username = loginInfo[0];
                String password = loginInfo[1];
                try {
                    UserVO userVO = loginService.loginAdmin(username, password);
                    if (userVO != null) {
                        session.setAttribute(LoginController.SESSION_USER, userVO);
                    }
                    return true;
                } catch (ServiceException e) {
                    logger.info("login failed-username:{}, msg:{}", username, e.getMessage());
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
