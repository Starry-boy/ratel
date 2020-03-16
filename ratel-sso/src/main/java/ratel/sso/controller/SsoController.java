package ratel.sso.controller;

import com.sun.tools.javac.util.Assert;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ratel.common.dto.RatelResponse;
import ratel.common.dto.UserLoginRequest;
import ratel.common.dto.ValidateTokeRequest;
import ratel.sso.domain.User;
import ratel.sso.service.UserService;
import ratel.sso.util.JwtTokenUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ratel
 * @date 2020/3/15
 */
@Slf4j
@RestController
@RequestMapping("sso")
public class SsoController {
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private UserService userService;
    @GetMapping("get/{id}")
    public String get(@PathVariable Long id){
        return serverPort;
    }

    @PostMapping("userLogin")
    public RatelResponse userLogin(@RequestBody UserLoginRequest userLoginRequest){
        //查数据库
        User user = userService.getByUsername(userLoginRequest.getUsername());
        Assert.checkNonNull(user,"用户名错误");
        Map<String,Object> payLoad = new HashMap<>();
        payLoad.put("uid",user.getId());
        payLoad.put("exp",null);
        return new RatelResponse().success(new ResponseEntity<String>(JwtTokenUtil.generatorToken(null), HttpStatus.OK));
    }
    @PostMapping("validateToken")
    public RatelResponse validateToken(@RequestBody ValidateTokeRequest validateTokeRequest){
        Claims claims = JwtTokenUtil.parseToken(validateTokeRequest.getToken());
        return new RatelResponse().success(claims.get("uid"));
    }
}
