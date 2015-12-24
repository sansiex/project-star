package com.star.people.exception;

/**
 * Created by zuhai.jiang on 2015/12/2.
 */
public class ServiceException extends Exception {

    public ServiceException() {
    }

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(Throwable th) {
        super(th);
    }

    public ServiceException(String msg, Throwable th) {
        super(msg, th);
    }

}
