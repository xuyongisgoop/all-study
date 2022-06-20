package com.xuyong.study.common;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/6/20
 **/
public interface MatchBean<E> {

    /**
     * @Description:  定义可筛选的接口
     * @Date: 2022/6/20
     * @Param factor: 传入因子
     **/
    boolean match(E factor);

}
