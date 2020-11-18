package com.bailiny;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Other {

    public static void main(String[] args) {
        List<BigDecimal> list = splitNumber(new BigDecimal("91"), new BigDecimal("1"), new BigDecimal("0"));
        System.out.println(list);
    }

    public static List<BigDecimal> splitNumber(BigDecimal target, BigDecimal min, BigDecimal max) {
        List<BigDecimal> res = new LinkedList();
        if (max.compareTo(BigDecimal.ZERO) == 0) {
            res.add(target);
            return res;
        }
        BigDecimal divide = target.divide(max, 2, BigDecimal.ROUND_DOWN);
        int divideInt = divide.intValue();
        // 是否整除
        boolean divideAll = new BigDecimal(divideInt).compareTo(divide) == 0;
        int minTimes = divideAll ? divideInt : divideInt + 1;
        if (divideAll) {
            for (int i = 0; i < minTimes; i++) {
                res.add(max);
            }
        } else {
            // 不能够整除
            int i = 1;
            BigDecimal avg = BigDecimal.ZERO;
            for (; i < minTimes; i++) {
                BigDecimal multiply = max.multiply(new BigDecimal(minTimes - i));
                 avg =target.subtract(multiply).divide(new BigDecimal(i), 2, BigDecimal.ROUND_DOWN);
                int compareTo =avg.compareTo(min);
                if (compareTo != -1) {
                    break;
                }
            }
            // 找到分段数据
            int maxCount = minTimes - i;
            int avgCount = i - 1;
            for (int j = 0; j < maxCount; j++) {
                res.add(max);
            }
            BigDecimal maxTotal = max.multiply(new BigDecimal(maxCount));
            for (int k = 0; k < avgCount; k++) {
                res.add(new BigDecimal(avg.intValue()));
            }
            // 最后一个 = target - maxTotal - avgTotal
            BigDecimal last = target.subtract(maxTotal).subtract(new BigDecimal(avg.intValue()).multiply(new BigDecimal(avgCount)));
            res.add(last);
        }
        return res;
    }
}
