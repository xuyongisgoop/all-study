package com.xuyong.study.common;

import java.util.List;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/6/20
 **/
public interface MyStrategyList<E extends MatchBean<F>, F> extends List<E> {

    E getBean(F factor);

}
