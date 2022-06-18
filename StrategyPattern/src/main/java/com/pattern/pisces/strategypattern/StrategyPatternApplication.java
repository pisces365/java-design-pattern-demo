package com.pattern.pisces.strategypattern;

import com.pattern.pisces.strategypattern.controller.WebSocketServer;
import com.pattern.pisces.strategypattern.printer.Printer;
import com.pattern.pisces.strategypattern.strategy.IStrategy;
import com.pattern.pisces.strategypattern.strategy.impl.DiscountStrategy;
import com.pattern.pisces.strategypattern.strategy.impl.NoDiscountStrategy;
import com.pattern.pisces.strategypattern.strategy.impl.PriceReductionStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/05/07/15:17
 * @Description:
 */
@SpringBootApplication
public class StrategyPatternApplication {
    public StrategyPatternApplication() {
        Printer printer = new Printer();
        IStrategy noDiscountStrategy = new NoDiscountStrategy();
        IStrategy priceReductionStrategy = new PriceReductionStrategy();
        IStrategy discountStrategy = new DiscountStrategy();
        WebSocketServer.setPrinter(printer);
        WebSocketServer.addStrategy("noDiscountStrategy", noDiscountStrategy);
        WebSocketServer.addStrategy("priceReductionStrategy", priceReductionStrategy);
        WebSocketServer.addStrategy("discountStrategy", discountStrategy);

        printer.setStrategy(noDiscountStrategy);
        WebSocketServer.tryToSend(printer.totalPrice(2300));
    }

    public static void main(String[] args) {
        SpringApplication.run(StrategyPatternApplication.class, args);
    }
}
