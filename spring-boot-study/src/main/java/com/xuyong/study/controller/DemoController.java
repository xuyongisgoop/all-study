package com.xuyong.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: TODO
 * @Author: xuyong
 * @Date: 2022/6/20
 **/
@Controller
public class DemoController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello!";
    }

}
