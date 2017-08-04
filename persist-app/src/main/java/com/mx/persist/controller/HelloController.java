package com.mx.persist.controller;

import com.mx.persist.contants.ApplicationPorperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 季先生 on 2017/8/2 14:18.
 */
@RestController
public class HelloController {
    @Autowired
    private ApplicationPorperties applicationPorperties;

    @GetMapping("/hello")
    public String hello(){
        return "hello,world!" + applicationPorperties.getRandomInt1020() ;
    }
}
