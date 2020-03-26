package com.ratel.microservice.order.service.impl;

import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.ratel.common.base.model.RatelResponse;
import com.ratel.microservice.order.service.OrderService;
import com.ratel.microservice.search.api.service.SearchFeignApi;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ratel
 * @date 2020/3/22
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private SearchFeignApi searchFeignApi;
    @Override
    public Map<String, String> get(Long id) {
        Map<String,String> map = new HashMap<>();
        map.put("1","双11订单");
        return map;
    }

    @Override
    @CacheResult
    public RatelResponse searchGet( Long id) {
        return searchFeignApi.get(id);
    }
}
