package ratel.sso.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ratel
 * @date 2020/3/15
 */
@RequestMapping("jwt")
@RestController
public class JwtController {
    @Autowired
    private RestTemplate service;

    @GetMapping("get/{id}")
    public String get(@PathVariable Long id){
        return service.getForObject("http://SSO-SERVER-PROVIDER/ssoProvider/sso/get/"+ id,String.class);
    }
}
