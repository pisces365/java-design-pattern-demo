package com.pattern.pisces.strategypattern.strategy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/05/07/15:05
 * @Description: 策略的顶层接口
 */
public interface IStrategy {
    /**
     * 获取打折优惠名称
     * @return
     */
    String getName();

    /**
     * 计算价格
     * @param originPrice
     * @return 价格
     */
    double priceCalculate(double originPrice);
}
