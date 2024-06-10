package com.tyz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyz.pojo.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tyz
 * @since 2024-05-18
 */
public interface UserMapper extends BaseMapper<User> {


    int doRegister(User user);
}
