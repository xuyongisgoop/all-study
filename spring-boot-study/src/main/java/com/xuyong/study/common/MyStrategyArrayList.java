package com.xuyong.study.common;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/6/20
 **/
public class MyStrategyArrayList<E extends MatchBean<F>, F> extends ArrayList<E> implements MyStrategyList<E, F> {

    @Override
    public E getBean(F factor) {
        Iterator<E> iterator = this.iterator();
        E result = null;
        while (iterator.hasNext()) {
            E next = iterator.next();
            if (next.match(factor)) {
                result = next;
            }
        }
        return result;
    }

}
