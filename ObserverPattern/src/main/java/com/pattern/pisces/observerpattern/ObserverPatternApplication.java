package com.pattern.pisces.observerpattern;

import com.pattern.pisces.observerpattern.observer.impl.KlineDiagramObserver;
import com.pattern.pisces.observerpattern.observer.impl.LineChartObserver;
import com.pattern.pisces.observerpattern.pojo.Stock;
import com.pattern.pisces.observerpattern.subject.impl.StockExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Calendar;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/05/09/9:24
 * @Description:
 */
@EnableAsync
@SpringBootApplication
public class ObserverPatternApplication {
    public ObserverPatternApplication() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Random random = new Random();
                double price = random.nextDouble() * 100 + 100;
                StockExchange stockExchangeCenter = new StockExchange();
                KlineDiagramObserver klineDiagramObserver = new KlineDiagramObserver(stockExchangeCenter);
                LineChartObserver lineChartObserver = new LineChartObserver(stockExchangeCenter);
                Calendar calendar = Calendar.getInstance();
                while (true) {
                    calendar.add(Calendar.SECOND, random.nextInt(60 * 24 * 60 / 10));
                    //股票新成交价在90%~110%波动
                    price = price * (random.nextInt(20) + 90) / 100;
                    Stock stock = new Stock("微软", price, calendar.getTime());
                    stockExchangeCenter.giveNewStock(stock);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        thread.start();
    }

    public static void main(String[] args) {
        System.out.println("servers:main启动");
        SpringApplication.run(ObserverPatternApplication.class, args);
    }
}
