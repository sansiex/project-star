package com.star.people.service;

import com.star.people.exception.ServiceException;
import com.star.people.mapper.AdminLoginInfoMapper;
import com.star.people.model.AdminLoginInfo;
import com.star.people.model.AdminLoginInfoExample;
import com.star.people.model.UserVO;
import com.star.people.util.EncodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

/**
 * Created by zuhai.jiang on 2015/12/27.
 */
@Service
public class LoginService {
    private Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    AdminLoginInfoMapper adminLoginInfoMapper;

    public UserVO loginAdmin(String username, String password) throws ServiceException {
        AdminLoginInfoExample exp = new AdminLoginInfoExample();
        exp.createCriteria().andNameEqualTo(username);
        List<AdminLoginInfo> loginInfoList = adminLoginInfoMapper.selectByExample(exp);
        if (loginInfoList == null || loginInfoList.size() < 1) {
            throw new ServiceException("用户名错误！");
        }
        AdminLoginInfo loginInfo = loginInfoList.get(0);
        String encoded = encodePassword(password, loginInfo.getSalt());
        if (Objects.equals(encoded, loginInfo.getPassword())) {
            return new UserVO().fromAdminLoginInfo(loginInfo);
        } else {
            throw new ServiceException("密码错误！");
        }
    }

    private String encodePassword(String password, String salt) {
        String msg = password + "--" + salt;
        return EncodeUtil.md5(msg);
    }

    public static void main(String[] args) {
        System.out.println(EncodeUtil.md5("123456--2111234"));
    }
}
