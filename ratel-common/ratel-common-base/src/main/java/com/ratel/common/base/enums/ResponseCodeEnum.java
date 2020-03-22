package com.ratel.common.base.enums;

public enum ResponseCodeEnum {
    SUCCESS("200","response success"),
    FailED("500","response failed");

    private String code;
    private String msg;

    ResponseCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
