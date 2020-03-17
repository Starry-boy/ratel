package ratel.sso.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ratel
 * @date 2020/3/15
 */
@RestController
@RequestMapping("discovery")
@Api("服务发现")
public class DiscoveryController {
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * @Description 服务发现，对外暴露所有服务
     * @Author      ratel
     * @Date        2020/3/15
     * @return      org.springframework.cloud.client.discovery.DiscoveryClient
     **/
    @ApiOperation("获取Eurake上所有服务")
    @GetMapping
    public DiscoveryClient discovery(){
        return discoveryClient;
    }
}
