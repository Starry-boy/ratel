package com.ratel.microservice.order.service.impl;

import com.ratel.microservice.order.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ratel
 * @date 2020/3/22
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Map<String, String> get(Long id) {
        Map<String,String> map = new HashMap<>();
        map.put("1","双11订单");
        return map;
    }
}
