package com.mx.persist.controller;

import com.mx.persist.model.User;
import com.mx.persist.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by 季先生 on 2017/8/2 10:47.
 */
@RestController
@RequestMapping("/")
public class IndexController {
    /**
     * 添加log4j2日志
     */
    private static final Logger logger = LogManager.getLogger(IndexController.class);
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public ModelAndView index(ModelAndView modelAndView) {
        logger.info("欢迎光临");
        modelAndView.setViewName("login");
        logger.info("准备跳转到登录页面");
        return modelAndView;
    }

    /**
     * 登录
     * @param modelAndView
     * @return
     */
    @GetMapping("login")
    public ModelAndView loginGet(ModelAndView modelAndView,User user) {
        logger.info("您输入的用户信息user:{}" , user);
        if (StringUtils.isEmpty(user.getUserName())){
            logger.info("");
            modelAndView.setViewName("login");
        } else {
            user.setAge(20);
            user.setPhone("18989672345");
            user.setBirthday(new Date());
            user.setDescription("描述");
            User newUser = userRepository.save(user);
            modelAndView.setViewName("dashboard");
            logger.info("新注册的用户信息:{}",newUser);
        }
        return modelAndView;
    }

    /**
     * 登出
     * @param httpSession
     * @param modelAndView
     * @return
     */
    @GetMapping("logout")
    public ModelAndView logout(HttpSession httpSession, ModelAndView modelAndView) {
        User user = (User) httpSession.getAttribute("user");
        logger.info("用户{}执行了登出操作!",user.getUserName());
        httpSession.removeAttribute("user");
        logger.info("在HTTPSESSION中删除用户{}",user);
        modelAndView.setViewName("login");
        logger.info("跳转到登录页面!");
        return modelAndView;
    }

    /**
     * 注册
     * @param modelAndView
     * @return
     */
    @GetMapping("register")
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("login")
    public ModelAndView loginPost(User user, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        User targetUser = userRepository.findUserByUserName(user.getUserName());
        if (null != targetUser && user.getPwd().equals(targetUser.getPwd())) {
            httpSession.setAttribute("user", targetUser);
            modelAndView.setViewName("dashboard");
        } else {
            modelAndView.addObject("error", "用户名或密码错误，请重新登录！");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
