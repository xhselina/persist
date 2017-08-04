package com.mx.persist.repository;

import com.mx.persist.contants.ApplicationPorperties;
import com.mx.persist.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * Created by 季先生 on 2017/8/2 14:21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {
      private HelloController helloController = new HelloController();
      @Autowired
      private ApplicationPorperties applicationPorperties;
    @Test
    public void testHello(){
        String hello = helloController.hello();
        Assert.isTrue(hello.equals("hello1,world!"));
    }

    @Test
    public void testRandom(){
        System.out.println(applicationPorperties);
    }
}
