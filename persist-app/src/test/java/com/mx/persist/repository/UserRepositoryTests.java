package com.mx.persist.repository;

import com.mx.persist.Client;
import com.mx.persist.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

/**
 * Created by 季先生 on 2017/8/2 11:38.
 */
// SpringJUnit支持，由此引入Spring-Test框架支持！
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    UserRepository userRepository;
    @Test
    @Transactional
    public void testGetUser(){
        User user = userRepository.getOne(1L);
        System.out.println(user);
        Assert.assertTrue(user.getUserName().equals("xhselina"));
    }
}
