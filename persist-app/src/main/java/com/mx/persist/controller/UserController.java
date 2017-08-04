package com.mx.persist.controller;

import com.mx.persist.contants.ApplicationPorperties;
import com.mx.persist.model.User;
import com.mx.persist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by 季先生 on 2017/8/2 14:45.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicationPorperties applicationPorperties;

    public void loginIn(){
        
    }

//    @GetMapping("save.htm")
//    @ResponseBody
//    public String saveUser() {
//        User user = new User();
//        user.setUserName("xhselina" + applicationPorperties.getRandomInt1020());
//        user.setBirthday(new Date());
//        user.setEmail("jeffreyji@yeah.net");
//        user.setPhone("19875214587");
//        user.setAge(18);
//        user.setDescription("描述信息");
//        user.setPwd("a123456");
//        user = userRepository.save(user);
//        System.out.println(user);
//        return user.toString();
//    }
//
//    @GetMapping("update.htm")
//    public String updateUser() {
//        User user = userRepository.getOne(30L);
//        user.setPwd("111111111111111111111111111");
//        user.setUserName("3333333333333333333333");
//        user = userRepository.saveAndFlush(user);
//        return user.toString();
//    }

    @PostMapping("getUserByUserName.htm")
    public String getUserByUserName(String userName) {
        User user = userRepository.findUserByUserName(userName);
        return user.toString();
    }

    @GetMapping(value = "get{id}.htm")
    public String getUserById(@PathVariable Long id) {
        return userRepository.getOne(id).toString();
    }

    @GetMapping(value = "remove{id}.htm")
    public String removeUserById(@PathVariable Long id) {
        userRepository.delete(id);
        return "成功";
    }
}
