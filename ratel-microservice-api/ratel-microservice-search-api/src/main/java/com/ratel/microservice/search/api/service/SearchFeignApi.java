package com.ratel.microservice.search.api.service;

import com.ratel.common.base.model.RatelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient("ratel-microservice-search")
public interface SearchFeignApi {

    @PostMapping("feignApi/search/get/{id}")
    RatelResponse<Map<String,String>> get(@PathVariable("id") Long id);
}
