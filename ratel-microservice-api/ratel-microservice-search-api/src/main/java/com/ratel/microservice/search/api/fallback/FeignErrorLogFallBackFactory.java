package com.ratel.microservice.search.api.fallback;

import com.ratel.common.base.enums.ResponseCodeEnum;
import com.ratel.common.base.model.RatelResponse;
import com.ratel.microservice.search.api.service.SearchFeignApi;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author ratel
 * @date 2020/3/25
 */
@Slf4j
@Component
public class FeignErrorLogFallBackFactory implements FallbackFactory {
    @Override
    public SearchFeignApi create(Throwable throwable) {
        log.error("feign client invoke rpc exception! error message ====>>>>{}",throwable.getMessage());
        return new SearchFeignApi() {
                @Override
                public RatelResponse<Map<String, String>> get(Long id) {
                    return new RatelResponse<>().err(ResponseCodeEnum.FAILED,"调用失败，feignFallFactory 快速响应");
                }
        } ;
    }
}
