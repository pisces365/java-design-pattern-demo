package com.pattern.pisces.observerpattern.observer.impl;

import com.pattern.pisces.observerpattern.controller.WebSocketServer;
import com.pattern.pisces.observerpattern.observer.Observer;
import com.pattern.pisces.observerpattern.pojo.KStockAllData;
import com.pattern.pisces.observerpattern.pojo.Stock;
import com.pattern.pisces.observerpattern.subject.Subject;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/05/09/9:13
 * @Description:
 */
public class KlineDiagramObserver implements Observer {
    /**
     * 所有K折线所需数据
     */
    KStockAllData kStockAllData = new KStockAllData();
    /**
     * 观察者的被观察对象
     */
    Subject subject;

    /**
     * 获取或更新股票信息
     * @param stock
     */
    @Override
    public void getChangeInfo(Stock stock) {
        kStockAllData.addNewStock(stock);
        WebSocketServer.sendKlineInfo(kStockAllData);
    }

    /**
     * 初始化对象并添加观察者
     * @param subject
     */
    public KlineDiagramObserver(Subject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }
}
