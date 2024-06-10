package com.tyz.controller;

import com.tyz.pojo.User;
import com.tyz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:用户注册
 * @author tangyizuo
 * @since 2024/5/20 8:43
 * @return:
 */
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("/toRegister")
    public String toRegister(User user){

        userService.doRegister(user);
        return "redirect:toRegister";
    }

}
