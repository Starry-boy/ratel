package com.ratel.microservice.order.service;

import com.ratel.common.base.model.RatelResponse;

import java.util.Map;

public interface OrderService {
    Map<String, String> get(Long id);

    RatelResponse searchGet(Long id);
}
