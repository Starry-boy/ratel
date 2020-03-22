//package com.ratel.log.microservice.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.ratel.common.dto.RatelResponse;
//import com.ratel.search.api.dto.Goods;
//import com.ratel.search.api.interfaces.GoodsServiceApi;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * @author ratel
// * @date 2020/3/21
// */
//@RestController
//@RequestMapping("/log")
//public class LogController {
//
//    @Autowired
//    private GoodsServiceApi goodsServiceApi;
//
//    @GetMapping("goods")
//    public RatelResponse<Goods> goods(){
//        RatelResponse<List<Goods>> list = goodsServiceApi.list();
//        System.out.println(JSON.toJSONString(list));
//        return new RatelResponse<>().success("aa");
//    }
//}
