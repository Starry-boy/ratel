package com.ratel.microservice.order.aop;

import com.ratel.common.base.enums.ResponseCodeEnum;
import com.ratel.common.base.model.RatelResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.jws.WebResult;

/**
 * @author ratel
 * @date 2020/3/25
 */
@Slf4j
//@Aspect
//@Component
public class FallBackErrorLogAop {
    @Pointcut("@annotation(org.springframework.cloud.openfeign.FeignClient)")
    public void exceptionPointCut() {
    }

    @Around("@annotation(org.springframework.cloud.openfeign.FeignClient)")
    public RatelResponse feignRpcMethod(ProceedingJoinPoint point){
        try {
            return (RatelResponse)point.proceed();
        } catch (Throwable throwable) {
            log.error("feign invoke rpc method fallback!! error message =>>>>>{}",throwable.getMessage());
            return new RatelResponse().err(ResponseCodeEnum.FAILED,throwable.getMessage());
        }
    }

    public FallBackErrorLogAop() {
        log.info(this.getClass().getName() + "  init !!!");
    }
}
