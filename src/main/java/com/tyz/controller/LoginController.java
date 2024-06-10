package com.tyz.controller;

import com.tyz.service.UserService;
import com.tyz.vo.LoginVo;
import com.tyz.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
@Slf4j


public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * @description: 用户登陆
     * @author tangyizuo
     * @since 2024/5/18 19:37
     * @return: java.lang.String
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    /**
     * @description:登陆功能
     * @author tangyizuo
     * @since 2024/5/19 18:07
     * @return: com.tyz.vo.RespBean 
     */ 
    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(@Valid LoginVo loginVo, HttpServletRequest request, HttpServletResponse response){
        return userService.doLogin(loginVo,request,response);
    }

}
