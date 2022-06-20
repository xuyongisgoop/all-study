package com.xuyong.study.common;

import org.springframework.beans.propertyeditors.CustomCollectionEditor;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/6/20
 **/
public class MyStrategyEditor extends CustomCollectionEditor {
    public MyStrategyEditor() {
        super(MyStrategyArrayList.class);
    }
}
