package com.ratel.common.base.enums;

public enum ErrorCodeEnum {
    /** system */
    SYC1000001("500","未知异常"),
    /** sso */
    SSC1000001("1000001",""),
    /** order */
    ORC1000001("1000001","");


    private String code;
    private String msg;

    ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ErrorCodeEnum getCode(String code){
        for (ErrorCodeEnum value : values()) {
            if (value.code.equals(code)){
                return value;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
