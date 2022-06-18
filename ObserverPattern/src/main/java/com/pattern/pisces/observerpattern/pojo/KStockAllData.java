package com.pattern.pisces.observerpattern.pojo;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/05/09/8:45
 * @Description: K线图所有数据的保存
 */
@Data
public class KStockAllData {
    /**
     * 时间格式化
     */
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * K线图原子数据
     */
    private Vector<KStockAtomicData> kStockAtomicDataVector;
    /**
     * 时间类存储
     */
    private Vector<Date> dateVector;

    /**
     * 增加新的股票原子数据
     *
     * @param stock
     */
    public void addNewStock(Stock stock) {
        if (!dateVector.isEmpty() && isTheSameDay(stock.getDate(), dateVector.get(dateVector.size() - 1))) {
            //在同一天内
            kStockAtomicDataVector.get(kStockAtomicDataVector.size() - 1).updateStock(stock);
        } else {
            //不在同一天
            kStockAtomicDataVector.add(new KStockAtomicData(stock));
            dateVector.add(stock.getDate());
        }
    }

    /**
     * 获取时间
     *
     * @return
     */
    public List<String> getTime() {
        List<String> result = new ArrayList<>();
        dateVector.forEach(item -> {
            result.add(simpleDateFormat.format(item));
        });
        return result;
    }

    public KStockAllData() {
        kStockAtomicDataVector = new Vector<>();
        dateVector = new Vector<>();
    }

    /**
     * 判断是否是同一天
     *
     * @param d1
     * @param d2
     * @return
     */
    private static boolean isTheSameDay(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        return (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR))
                && (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH))
                && (c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH));
    }
}
