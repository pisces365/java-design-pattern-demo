package com.pattern.pisces.observerpattern.observer.impl;

import com.pattern.pisces.observerpattern.controller.WebSocketServer;
import com.pattern.pisces.observerpattern.observer.Observer;
import com.pattern.pisces.observerpattern.pojo.Stock;
import com.pattern.pisces.observerpattern.subject.Subject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/05/09/8:54
 * @Description:
 */
public class LineChartObserver implements Observer {
    /**
     * 获取股票时间
     */
    private List<String> time;
    /**
     * 获取股票价格
     */
    private List<Double> price;
    /**
     * 观察者的被观察对象（折线图、K线图）
     */
    private Subject subject;
    /**
     * 时间格式化变量
     */
    private static SimpleDateFormat lineDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void getChangeInfo(Stock stock) {
        time.add(lineDateFormat.format(stock.getDate()));
        price.add(stock.getPrice());
        WebSocketServer.sendLineChartInfo(time,price);
    }

    public LineChartObserver(Subject subject) {
        time=new ArrayList<>();
        price=new ArrayList<>();
        this.subject = subject;
        subject.addObserver(this);
    }
}
