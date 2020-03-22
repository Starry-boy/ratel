package com.ratel.microservice.search.web.Controller;

import com.ratel.common.base.model.RatelResponse;
import com.ratel.microservice.order.api.service.OrderFeignApi;
import com.ratel.microservice.search.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author ratel
 * @date 2020/3/22
 */
@Slf4j
@RestController
@RequestMapping("search")
public class SearchController {
    @Autowired
    private SearchService searchService;
    @Resource
    private OrderFeignApi orderFeignApi;

    @GetMapping("get/{id}")
    public RatelResponse<Map<String,String>> get(@PathVariable("id") Long id){
        return new RatelResponse<Map<String,String>>().ok(searchService.get(id));
    }

    @GetMapping("order/get/{id}")
    public RatelResponse<Map<String,String>> orderGet(@PathVariable("id") Long id){
        return orderFeignApi.get(id);
    }
}
