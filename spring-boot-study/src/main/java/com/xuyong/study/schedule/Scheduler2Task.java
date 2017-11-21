package com.xuyong.study.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler2Task {
 
    private int count=0;
 
    @Scheduled(cron="*/8 * * * * ?")
    private void process(){
        System.out.println("this is scheduler2 task runing  "+(count++));
    }
}
