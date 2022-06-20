package com.xuyong.study;

import com.xuyong.study.common.MyStrategyArrayList;
import com.xuyong.study.common.MyStrategyList;
import com.xuyong.study.service.BuyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/6/20
 **/
@SpringBootTest
public class BuyServiceTest {

    @Autowired
    private List<BuyService> buyServiceList;

    @Autowired
    private MyStrategyList<BuyService, String> myStrategyList;

    @Test
    void testBuyServiceByList() {
        buyServiceList.stream().forEach(buy -> {
            System.out.println(buy.getClass().getName());
        });
    }

    @Test
    void testBuyServiceByMyStrategyList() {
        System.out.println(myStrategyList instanceof Collection);
        System.out.println(myStrategyList instanceof List);
        System.out.println(myStrategyList instanceof MyStrategyList);
        System.out.println(myStrategyList instanceof MyStrategyArrayList);
        BuyService buyService = myStrategyList.getBean("jd");
        buyService.goShopping();
    }

}
