package com.star.people.dto;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by zuhai.jiang on 2015/11/9.
 */
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 5507271255728134316L;
    private boolean success;
    private int resultCode;
    private String resultMessage;
    private T result;

    public Response() {
        success = true;
        resultCode = 0;
    }

    public Response(T result) {
        success = true;
        resultCode = 0;
        this.result = result;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return this.resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String toString() {
        return new Gson().toString();
    }
}
