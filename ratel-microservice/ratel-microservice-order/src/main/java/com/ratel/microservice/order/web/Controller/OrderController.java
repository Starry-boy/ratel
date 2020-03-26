package com.ratel.microservice.order.web.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.ratel.common.base.enums.ResponseCodeEnum;
import com.ratel.common.base.model.RatelResponse;
import com.ratel.microservice.order.service.OrderService;
import com.ratel.microservice.search.api.service.SearchFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ratel
 * @date 2020/3/22
 */
@Slf4j
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private SearchFeignApi searchFeignApi;

    @GetMapping("get/{id}")
    public RatelResponse<Map<String,String>> get(@PathVariable("id") Long id){
        log.info(this.getClass().getName());
        return new RatelResponse<Map<String,String>>().ok(orderService.get(id));
    }

    @GetMapping("/search/get/{id}")
//    @HystrixCommand(fallbackMethod = "fallback",ignoreExceptions = NullPointerException.class)
    public RatelResponse searchGet( @PathVariable("id") Long id){
        List<RatelResponse> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String str = searchFeignApi.getStr(id);
            System.out.println(str);
        }
        return new RatelResponse().ok(list);
    }

    private RatelResponse fallback( Long id){
        return new RatelResponse().err(ResponseCodeEnum.FAILED,"rpc 调用失败，使用 hystrix fallback");
    }
}
