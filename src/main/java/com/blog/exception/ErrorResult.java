package com.blog.exception;

/**
 * Created by yaojie on 2018-10-25.
 */
public class ErrorResult {
    public int code;
    public String msg;

    public ErrorResult() {
    }

    public ErrorResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
