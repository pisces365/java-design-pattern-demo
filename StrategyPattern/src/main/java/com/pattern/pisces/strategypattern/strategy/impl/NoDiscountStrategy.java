package com.pattern.pisces.strategypattern.strategy.impl;

import com.pattern.pisces.strategypattern.strategy.IStrategy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/05/07/15:07
 * @Description: 无折扣的策略
 */
public class NoDiscountStrategy implements IStrategy {
    private String name = "无折扣";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double priceCalculate(double originPrice) {
        return originPrice;
    }
}
