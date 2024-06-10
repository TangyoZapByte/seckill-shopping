package com.tyz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyz.pojo.User;
import com.tyz.vo.LoginVo;
import com.tyz.vo.RespBean;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tyz
 * @since 2024-05-18
 */
@Service
public interface UserService extends IService<User> {
    /**
     * @description:登陆
     * @author tangyizuo
     * @since 2024/5/19 18:12
     * @return: com.tyz.vo.RespBean 
     */ 
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);


    void doRegister(User user);
    /**
     * @description:根据Cookie获取用户
     * @author tangyizuo
     * @since 2024/5/20 17:15
     * @return: com.tyz.pojo.User
     */
    User getUserByCookie(String userTicket,HttpServletRequest request,HttpServletResponse response);
}
