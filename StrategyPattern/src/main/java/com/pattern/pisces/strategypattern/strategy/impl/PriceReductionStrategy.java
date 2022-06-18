package com.pattern.pisces.strategypattern.strategy.impl;

import com.pattern.pisces.strategypattern.strategy.IStrategy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/05/07/15:12
 * @Description: 减价策略
 */
public class PriceReductionStrategy implements IStrategy {
    private String name = "立减金额";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double priceCalculate(double originPrice) {
        return originPrice - 5;
    }
}
