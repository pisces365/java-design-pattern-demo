package com.pattern.pisces.observerpattern.subject.impl;

import com.pattern.pisces.observerpattern.observer.Observer;
import com.pattern.pisces.observerpattern.pojo.Stock;
import com.pattern.pisces.observerpattern.subject.Subject;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/05/09/9:02
 * @Description:
 */
public class StockExchange implements Subject {

    /**
     * 判断更新信息是否与之前不同
     */
    boolean change;
    /**
     * 基本股票信息
     */
    Stock stock;
    /**
     * 存放观察者集合,非线程安全
     */
    ArrayList<Observer> arrayList;

    public StockExchange() {
        arrayList = new ArrayList<>();
        change = false;
        stock = null;
    }

    /**
     * 增加观察者
     * @param observer
     */
    @Override
    public void addObserver(Observer observer) {
        if (!arrayList.contains(observer)) {
            arrayList.add(observer);
        }
    }

    /**
     * 通知观察者
     */
    @Override
    public void notifyObservers() {
        if(change) {
            arrayList.forEach(item -> item.getChangeInfo(stock));
            change = false;
        }
    }

    /**
     * 判断是否增加股票信息和通知观察者
     * @param stock
     */
    @Override
    public void giveNewStock(Stock stock) {
        if (stock.equals(this.stock)) {
            change = false;
        } else {
            this.stock = stock;
            change = true;
        }
        this.notifyObservers();
    }
}
