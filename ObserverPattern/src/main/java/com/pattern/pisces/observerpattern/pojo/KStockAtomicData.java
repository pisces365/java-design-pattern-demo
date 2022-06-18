package com.pattern.pisces.observerpattern.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.max;
import static java.lang.Double.min;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/05/09/8:49
 * @Description:
 */
@Data
public class KStockAtomicData {
    /**
     * 开盘价
     */
    private double beginPrice;
    /**
     * 收盘价
     */
    private double endPrice;
    /**
     * 最高价
     */
    private double maxPrice;
    /**
     * 最底价格
     */
    private double minPrice;

    KStockAtomicData(Stock stock) {
        beginPrice = stock.getPrice();
        endPrice = stock.getPrice();
        maxPrice = stock.getPrice();
        minPrice = stock.getPrice();
    }


    /**
     * 更新Stock数据
     *
     * @param stock
     */
    public void updateStock(Stock stock) {
        endPrice = stock.getPrice();
        maxPrice = max(maxPrice, stock.getPrice());
        minPrice = min(minPrice, stock.getPrice());
    }

    /**
     * K线图集合获取
     *
     * @return
     */
    public List<Double> getAtomicData() {
        List<Double> result = new ArrayList<>();
        result.add(beginPrice);
        result.add(endPrice);
        result.add(maxPrice);
        result.add(minPrice);
        return result;
    }
}
