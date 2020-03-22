package com.ratel.microservice.search.service.impl;

import com.ratel.microservice.search.service.SearchService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ratel
 * @date 2020/3/22
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Override
    public Map<String, String> get(Long id) {
        Map<String,String> map = new HashMap<>();
        map.put("1","电脑");
        return map;
    }
}
