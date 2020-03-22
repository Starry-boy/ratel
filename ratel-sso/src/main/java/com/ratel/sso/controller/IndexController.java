package com.ratel.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author com.ratel
 * @date 2020/3/17
 */
@Controller
@RequestMapping
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "redirect:index.html";
    }
}
