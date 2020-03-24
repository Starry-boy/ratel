package com.ratel.microservice.order.web.Controller;

import com.ratel.common.base.model.RatelResponse;
import com.ratel.microservice.order.service.OrderService;
import com.ratel.microservice.search.api.service.SearchFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return new RatelResponse<Map<String,String>>().ok(orderService.get(id));
    }

    @GetMapping("/search/get/{id}")
    public RatelResponse<Map<String,String>> searchGet(@PathVariable("id") Long id){
        return searchFeignApi.get(id);
    }
}
