package ratel.common.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author ratel
 * @date 2020/3/16
 */
@Data
public class UserLoginRequest {
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
    private String redirectUrl;
}
