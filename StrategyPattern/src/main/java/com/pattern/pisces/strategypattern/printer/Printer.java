package com.pattern.pisces.strategypattern.printer;

import com.pattern.pisces.strategypattern.strategy.IStrategy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/05/07/15:14
 * @Description: 依赖策略接口的打印机类
 */
public class Printer {
    /**
     * 记录当前策略
     */
    private IStrategy strategy;

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public IStrategy getStrategy() {
        return strategy;
    }

    /**
     * 调用计算价格函数
     * @param originPrice
     * @return 返回价格
     */
    public double totalPrice(double originPrice) {
        return strategy.priceCalculate(originPrice);
    }
}
