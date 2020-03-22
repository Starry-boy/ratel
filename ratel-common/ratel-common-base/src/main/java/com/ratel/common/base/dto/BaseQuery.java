package com.ratel.common.base.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ratel
 * @date 2020/3/22
 */
@Data
public class BaseQuery implements Serializable {

    /**
     * 当前页
     */
    private Integer pageNum = 1;

    /**
     * 每页条数
     */
    private Integer pageSize = 10;

    /**
     * 排序
     */
    private String orderBy;
}
