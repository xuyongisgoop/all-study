package com.xuyong.study.controller;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xuyong.study.domain.Greeting;
import com.xuyong.study.mapper.test1.User1Mapper;
import com.xuyong.study.mapper.test2.User2Mapper;

@RestController
public class GreetingController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private User1Mapper user1Mapper;
    
    @Autowired
    private User2Mapper user2Mapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
    @RequestMapping("/helloworld")
    public String helloworld() {
    	logger.debug("helloworld!!");
    	List<Greeting> all1 = user1Mapper.getAll();
    	for (Greeting item : all1) {
    		logger.info("id: {}, content: {}", item.getId(), item.getContent());
    	}
    	logger.debug("user mapper !!");
    	List<Greeting> all2 = user2Mapper.getAll();
    	for (Greeting item : all2) {
    		logger.info("id: {}, content: {}", item.getId(), item.getContent());
    	}
    	return "Hello!World";
    }
    
    @RequestMapping("/redistest")
    public String redistest() {
    	logger.debug("redistest!!");
        stringRedisTemplate.opsForValue().set("aaa", "222");
        String result = stringRedisTemplate.opsForValue().get("aaa");
    	return result;
    }
    
    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}