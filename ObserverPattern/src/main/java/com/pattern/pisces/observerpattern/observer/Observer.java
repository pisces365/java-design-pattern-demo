package com.pattern.pisces.observerpattern.observer;

import com.pattern.pisces.observerpattern.pojo.Stock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/05/09/8:34
 * @Description:
 */
public interface Observer {

    public void getChangeInfo(Stock stock);
}
