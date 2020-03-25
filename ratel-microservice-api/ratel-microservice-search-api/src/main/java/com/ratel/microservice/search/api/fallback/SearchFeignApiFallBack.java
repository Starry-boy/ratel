package com.ratel.microservice.search.api.fallback;

import com.ratel.common.base.enums.ResponseCodeEnum;
import com.ratel.common.base.model.RatelResponse;
import com.ratel.microservice.search.api.service.SearchFeignApi;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author ratel
 * @date 2020/3/24
 */
//@Component
//@RequestMapping("/fallback/search")
public class SearchFeignApiFallBack implements SearchFeignApi {
    @Override
    public RatelResponse<Map<String, String>> get(Long id) {
        return new RatelResponse<>().err(ResponseCodeEnum.FAILED,"调用失败，快速响应");
    }

    public SearchFeignApiFallBack() {
        System.out.println("SearchFeignApiFallBack init");
    }
}