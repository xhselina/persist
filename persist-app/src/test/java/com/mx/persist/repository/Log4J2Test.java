package com.mx.persist.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 季先生 on 2017/8/4 15:06.
 */
//@SpringBootTest
//@RunWith(SpringRunner.class)
public class Log4J2Test {
    private Logger logger = LogManager.getLogger(getClass());

    @Test
    public void testInfo(){

        logger.info("info日志打印[{}{}]","aaaaaaa","sdfsdfsdf");
        logger.error("error日志打印");
    }
}
