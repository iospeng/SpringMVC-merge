package com.it.scholar.domain;

/*
    响应数据类
    所有请求最终响应该类型数据
 */
public class ResponseData {
    private int code;
    private Object data;
    private String msg;

    public ResponseData(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ResponseData(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
