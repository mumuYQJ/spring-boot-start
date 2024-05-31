package com.csdj.springbootvue.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 消费表
 * @TableName consumption
 */
@Data
public class Consumption implements Serializable {
    /**
     * 消费编号
     */
    private Integer id;

    /**
     * 消费名称
     */
    private String name;

    /**
     * 消费价格
     */
    private Double price;

    private static final long serialVersionUID = 1L;
}