package com.xuyong.study.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler1Task {
 
    private int count=0;
 
    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler1 task runing  "+(count++));
    }
}
