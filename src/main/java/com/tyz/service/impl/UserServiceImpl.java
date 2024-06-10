package com.tyz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyz.exception.GlobalException;
import com.tyz.mapper.UserMapper;
import com.tyz.pojo.User;
import com.tyz.service.UserService;
import com.tyz.utils.CookieUtil;
import com.tyz.utils.MD5Util;
import com.tyz.utils.UUIDUtil;
import com.tyz.vo.LoginVo;
import com.tyz.vo.RespBean;
import com.tyz.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tyz
 * @since 2024-05-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @description:登陆
     * @author tangyizuo
     * @since 2024/5/19 18:13
     * @return: com.tyz.vo.RespBean
     */
    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
//        if(StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
//            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
//        }
//        if(!ValidatorUtil.isMobile(mobile)){
//            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
//        }
        User user = userMapper.selectById(mobile);
        if(user == null){
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        //密码确认
        if(!MD5Util.fromPassToDBPass(password,user.getSalt()).equals(user.getPassword())){
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        //生成Cookie
        String ticket = UUIDUtil.uuid();
        //将用户信息存入redis中
        redisTemplate.opsForValue().set("user" + ticket,user);

//        request.getSession().setAttribute(ticket,user);
        CookieUtil.setCookie(request,response,"userTicket",ticket);
        return RespBean.success();
    }

    @Override
    public void doRegister(User user) {
        //空用户输入
        if(user == null){
            throw new GlobalException(RespBeanEnum.ERROR);
        }

        User result = userMapper.selectById(user.getId());
        if(result != null){
            throw new GlobalException(RespBeanEnum.REGISTER_ERROR);
        }
        userMapper.doRegister(user);
    }
    /**
     * @description:根据Cookie返回用户对象
     * @author tangyizuo
     * @since 2024/5/20 17:16
     * @return: com.tyz.pojo.User
     */
    @Override
    public User getUserByCookie(String userTicket,HttpServletRequest request,HttpServletResponse response) {
        if(StringUtils.isEmpty(userTicket)){
            return null;
        }
        User user = (User) redisTemplate.opsForValue().get("user:"+userTicket);
        if(user != null){
            CookieUtil.setCookie(request,response,"userTicket",userTicket);
        }
        return user;
    }


}
