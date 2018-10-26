package com.blog.exception;

/**
 * Created by yaojie on 2018-10-25.
 */
public class ParamException extends RuntimeException {
    private static final long serialVersionUID = -8634700792767837033L;
    public String msg;

    public ParamException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
