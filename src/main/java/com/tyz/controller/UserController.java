package com.tyz.controller;

import com.tyz.pojo.User;
import com.tyz.vo.RespBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tyz
 * @since 2024-05-18
 */
@RestController
@RequestMapping("/tUser")
public class UserController {
    
    /**
     * @description:用户信息测试
     * @author tangyizuo
     * @since 2024/5/26 22:29
     * @return: com.tyz.vo.RespBean 
     */ 
    @RequestMapping("/info")
    @ResponseBody
    public RespBean info(User user){
        return RespBean.success(user);
    }
}
