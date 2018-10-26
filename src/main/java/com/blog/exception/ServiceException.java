package com.blog.exception;

/**
 * Created by yaojie on 2018-10-25.
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -8634700792767837033L;
    public int code;
    public String msg;

    public ServiceException(ErrorCode errorCode) {
        super(errorCode.msg);
        this.code = errorCode.code;
        this.msg = errorCode.msg;
    }

    public ServiceException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
