package com.ratel.microservice.search.api.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.ratel.common.base.model.RatelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;


@FeignClient(name = "ratel-microservice-search",path = "/search")
public interface SearchFeignApi {

    @PostMapping("feignApi/search/get/{id}")
    @HystrixProperty(name = "requestCache.enabled",value = "true")
    @CacheResult
    RatelResponse get(@CacheKey @PathVariable("id") Long id);

    @PostMapping("feignApi/search/getStr/{id}")
    String getStr(@PathVariable("id")Long id);

    @HystrixCommand
    @PostMapping("feignApi/search/batchGetStr")
    List<String> batchGetStr(@RequestBody List<Long> ids);
}
