package ratel.sso.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ratel
 * @date 2020/3/15
 */
@RestController
@RequestMapping("sso")
public class SsoController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("get/{id}")
    public String get(@PathVariable Long id){
        return serverPort;
    }
}
