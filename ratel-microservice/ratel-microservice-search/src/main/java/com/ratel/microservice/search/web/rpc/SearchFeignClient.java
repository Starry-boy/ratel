package com.ratel.microservice.search.web.rpc;

import com.ratel.common.base.model.RatelResponse;
import com.ratel.microservice.search.api.service.SearchFeignApi;
import com.ratel.microservice.search.service.SearchService;
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
public class SearchFeignClient implements SearchFeignApi {
    @Autowired
    private SearchService searchService;

    @Override
    public RatelResponse<Map<String, String>> get(Long id) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, String> map = searchService.get(id);
        return new RatelResponse<Map<String, String>>().ok(map);
    }
}
