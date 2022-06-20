package com.xuyong.study.config;

import com.google.common.collect.Maps;
import com.xuyong.study.common.MyStrategyEditor;
import com.xuyong.study.common.MyStrategyList;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyEditor;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/6/20
 **/
@Configuration
public class CustomEditorConfiguration {

    @Bean
    public static CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
        Map<Class<?>, Class<? extends PropertyEditor>> customEditors = Maps.newHashMap();
        customEditors.put(MyStrategyList.class, MyStrategyEditor.class);
        customEditorConfigurer.setCustomEditors(customEditors);
        return customEditorConfigurer;
    }

}
