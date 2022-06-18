package com.pattern.pisces.observerpattern.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/05/09/8:36
 * @Description: 股票基本信息
 */
@Data
public class Stock {
    /**
     * 股票名称
     */
    private String name;
    /**
     * 股票价格
     */
    private double price;
    /**
     * 交易时间
     */
    private Date date;

    /**
     *
     * @param name
     * @param price
     * @param date
     */
    public Stock(String name, double price, Date date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }
}
