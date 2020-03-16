package ratel.common.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import ratel.common.constant.ResponseCodeEnum;

/**
 * @author ratel
 * @date 2020/3/16
 */
@Data
@Accessors(chain = true)
public class RatelResponse<T> {
    private String code;
    private String msg;
    private T data;
    private boolean status;

    public RatelResponse success(T t){
        return new RatelResponse<>().setData(t).setCode(ResponseCodeEnum.SUCCESS.getCode()).setMsg(ResponseCodeEnum.SUCCESS.getMsg());
    }

    public RatelResponse failed(String code,String msg){
        return new RatelResponse<>().setCode(code).setMsg(msg);
    }
    public RatelResponse failed(){
        return new RatelResponse<>().setCode(ResponseCodeEnum.FailED.getCode()).setMsg(ResponseCodeEnum.FailED.getMsg());
    }

}
