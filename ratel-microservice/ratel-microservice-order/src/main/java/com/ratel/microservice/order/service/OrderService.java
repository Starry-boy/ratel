package com.ratel.microservice.order.service;

import java.util.Map;

public interface OrderService {
    Map<String, String> get(Long id);
}
