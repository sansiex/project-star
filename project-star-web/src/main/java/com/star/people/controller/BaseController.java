package com.star.people.controller;

import com.google.common.base.Joiner;
import com.star.people.dto.Response;
import com.star.people.util.LogBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zuhai.jiang on 2016/2/15.
 */
public class BaseController extends LogBase {

    protected <T> Response<T> suc(Class<T> c, T value){
        Response<T> resp = new Response<>(value);
        return resp;
    }

    protected <T> Response<T> err(String msg){
        logger.error(msg);
        Response<T> resp = new Response<>();
        resp.setSuccess(false);
        resp.setResultMessage(msg);
        return resp;
    }

    protected <T> Response<T> err(String s, Object... args){
        String msg = String.format(s, args);
        logger.error(msg);
        Response<T> resp = new Response<>();
        resp.setSuccess(false);
        resp.setResultMessage(msg);
        return resp;
    }

    protected  Response err(String msg, int code){
        Response resp = new Response();
        resp.setSuccess(false);
        resp.setResultMessage(msg);
        resp.setResultCode(code);
        return resp;
    }
}
