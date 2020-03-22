package com.ratel.microservice.order.api.service;

import com.ratel.common.base.model.RatelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient(name = "ratel-microservice-order",path = "/order")
public interface OrderFeignApi {

    @PostMapping("feignApi/order/get/{id}")
    RatelResponse<Map<String,String>> get(@PathVariable("id") Long id);
}
