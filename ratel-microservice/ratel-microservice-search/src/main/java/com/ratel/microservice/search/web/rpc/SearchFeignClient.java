package com.ratel.microservice.search.web.rpc;

import com.alibaba.fastjson.JSON;
import com.ratel.common.base.model.RatelResponse;
import com.ratel.microservice.search.api.service.SearchFeignApi;
import com.ratel.microservice.search.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author ratel
 * @date 2020/3/22
 */
@Slf4j
@RestController
public class SearchFeignClient implements SearchFeignApi {
    @Autowired
    private SearchService searchService;

    @Override
    public RatelResponse<Map<String, String>> get(Long id) {
        Map<String, String> map = new HashMap<>();
        map.put(new Random().nextInt(10)+"","");
        log.info(JSON.toJSONString(map));
        return new RatelResponse<Map<String, String>>().ok(map);
    }

    @Override
    public String getStr(Long id) {
        log.info("单个getStr方法");
        return id+"";
    }

    @Override
    public List<String> batchGetStr(List<Long> ids) {
        log.info("批量getStr方法");
        return Arrays.asList("1","2");
    }
}
