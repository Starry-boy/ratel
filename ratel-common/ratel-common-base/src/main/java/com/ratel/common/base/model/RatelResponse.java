package com.ratel.common.base.model;

import com.ratel.common.base.enums.ResponseCodeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author com.ratel
 * @date 2020/3/16
 */
@Data
@Accessors(chain = true)
public class RatelResponse<T> {
    private String code;
    private String msg;
    private T data;
    private boolean status;

    public RatelResponse ok(T t){
        return new RatelResponse<>().setData(t)
                                    .setCode(ResponseCodeEnum.SUCCESS.getCode())
                                    .setMsg(ResponseCodeEnum.SUCCESS.getMsg())
                                    .setStatus(true);
    }

    public RatelResponse err(ResponseCodeEnum codeEnum, String msg){
        return new RatelResponse<>().setCode(codeEnum.getCode()).setMsg(msg);
    }
    public RatelResponse err(){
        return new RatelResponse<>().setCode(ResponseCodeEnum.FAILED.getCode()).setMsg(ResponseCodeEnum.FAILED.getMsg());
    }

}
