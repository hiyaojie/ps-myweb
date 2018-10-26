package com.blog.exception;

/**
 * Created by yaojie on 2018-10-25.
 */
public enum ErrorCode {
    permissionsForbidden(99, "权限不足!"),
    invalidToken(100, "无效的接口凭证!"),
    httpMethodError(101, "http请求异常!"),
    paramError(102, "参数校验不通过!"),
    unknowError(103, "后端未处理的异常!"),
    dataError(104, "数据库查无数据!");

    public int code;
    public String msg;

    private ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
