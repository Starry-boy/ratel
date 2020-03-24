package com.ratel.microservice.search.api.service;

import com.ratel.common.base.model.RatelResponse;
import com.ratel.microservice.search.api.fallback.SearchFeignApiFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient(name = "ratel-microservice-search",path = "/search",fallback = SearchFeignApiFallBack.class)
public interface SearchFeignApi {

    @PostMapping("feignApi/search/get/{id}")
    RatelResponse<Map<String,String>> get(@PathVariable("id") Long id);
}
