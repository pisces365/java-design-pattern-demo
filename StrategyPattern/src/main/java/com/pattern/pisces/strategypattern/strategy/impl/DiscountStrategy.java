package com.pattern.pisces.strategypattern.strategy.impl;

import com.pattern.pisces.strategypattern.strategy.IStrategy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/05/07/15:12
 * @Description: 打折策略
 */
public class DiscountStrategy implements IStrategy {

    private String name = "打折";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double priceCalculate(double originPrice) {
        return originPrice * (1 - 0.05);
    }
}
