package com.pattern.pisces.observerpattern.subject;

import com.pattern.pisces.observerpattern.observer.Observer;
import com.pattern.pisces.observerpattern.pojo.Stock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/05/09/8:59
 * @Description: 被观察者接口
 */
public interface Subject {
    /**
     * 添加观察者集合
     * @param observer
     */
    void addObserver(Observer observer);

    /**
     * 将股票交易信息提交给观察者
     */
    void notifyObservers();

    /**
     * 提供新的股票交易信息
     * @param stock
     */
    void giveNewStock(Stock stock);
}
