package com.ratel.microservice.order.web.rpc;

import com.ratel.common.base.model.RatelResponse;
import com.ratel.microservice.order.api.service.OrderFeignApi;
import com.ratel.microservice.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author ratel
 * @date 2020/3/22
 */
@Slf4j
@RestController
public class OrderFeignClient implements OrderFeignApi {
    @Autowired
    private OrderService orderService;

    @Override
    public RatelResponse<Map<String, String>> get(Long id) {
        Map<String, String> map = orderService.get(id);
        return new RatelResponse<Map<String, String>>().ok(map);
    }
}
