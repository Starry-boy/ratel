package ratel.sso.controller;

import com.alibaba.fastjson.JSON;
import com.netflix.client.http.HttpResponse;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import ratel.common.dto.RatelResponse;
import ratel.common.dto.UserLoginRequest;
import ratel.common.dto.ValidateTokeRequest;
import ratel.sso.domain.User;
import ratel.sso.service.UserService;
import ratel.sso.util.JwtTokenUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ratel
 * @date 2020/3/15
 */
@Slf4j
@Controller
@RequestMapping("sso")
@Api(tags = "用户登录相关接口")
public class SsoController {
    @Autowired
    private UserService userService;

    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "ratel", required = true),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "1234", required = true)
    }
    )
    @PostMapping("userLogin")
    public String userLogin(@Valid UserLoginRequest userLoginRequest, HttpServletResponse response){
        //查数据库
        User user = userService.getByUsername(userLoginRequest.getUsername());
        Assert.notNull(user,"用户名错误");
        Map<String,Object> payLoad = new HashMap<>();
        payLoad.put("uid",user.getId());
        payLoad.put("exp",null);
        payLoad.put("user", JSON.toJSONString(user));
        Cookie token = new Cookie("token", JwtTokenUtil.generatorToken(payLoad));
        token.setMaxAge((int)(System.currentTimeMillis()+ 6000 * 6000));
        response.addCookie(token);
        return String.format("redirect:%s",userLoginRequest.getRedirectUrl());
    }

    @ApiOperation("校验Token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", defaultValue = "token", required = true),
    }
    )
    @PostMapping("validateToken")
    public RatelResponse validateToken(@RequestBody @Valid ValidateTokeRequest validateTokeRequest){
        Claims claims = JwtTokenUtil.parseToken(validateTokeRequest.getToken());
        return new RatelResponse().success(claims.get("user"));
    }
}
