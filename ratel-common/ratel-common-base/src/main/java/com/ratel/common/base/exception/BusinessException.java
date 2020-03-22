package com.ratel.common.base.exception;

import com.ratel.common.base.enums.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ratel
 * @date 2020/3/22
 */
@Slf4j
public class BusinessException extends RuntimeException {
    /** 异常码 */
    protected String code;

    public String getCode() {
        return code;
    }

    public BusinessException() {
    }

    public BusinessException(ErrorCodeEnum codeEnum, Object... args) {
        super(String.format(codeEnum.getMsg(),args));
        this.code = codeEnum.getCode();
        log.info("<== BusinessException, code:{}, message:{}", this.code, super.getMessage());
    }
}
