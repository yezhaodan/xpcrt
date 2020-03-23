package com.yezd.xpcrt.util;

public enum ResponseCode {
    SUCCESS(0, "请求成功"),
    ERROR(1, "请求失败");
    //SYSTEM_ERROR("1000", "系统异常"),
    //BUSSINESS_ERROR("2001", "业务逻辑错误"),
    //VERIFY_CODE_ERROR("2002", "业务参数错误"),
    //PARAM_ERROR("2002", "业务参数错误");

    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
