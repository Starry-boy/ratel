package ratel.common.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author ratel
 * @date 2020/3/16
 */
@Data
public class ValidateTokeRequest {
    @NotEmpty(message = "token 不能为空")
    private String token;
}
