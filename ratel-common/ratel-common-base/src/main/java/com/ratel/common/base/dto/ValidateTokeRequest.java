package com.ratel.common.base.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author com.ratel
 * @date 2020/3/16
 */
@Data
public class ValidateTokeRequest {
    @NotEmpty(message = "token 不能为空")
    private String token;
}
