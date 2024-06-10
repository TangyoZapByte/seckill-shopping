package com.tyz.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @description: 公共返回对象枚举
 * @author tangyizuo
 * @since 2024/5/19 17:47
 * @return:
 */
@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {

    SUCCESS(200,"SUCCESS"),
    ERROR(500,"服务器异常"),
    LOGIN_ERROR(500210,"用户名或密码错误"),
    MOBILE_ERROR(500211,"手机号码格式不对"),
    REGISTER_ERROR(500300,"用户已存在"),
    EMPTY_ERROR(500500,"库存不足"),
    REPEATE_ERROR(500502,"该商品限购一件"),
    BIND_ERROR(500212,"参数校验异常");
    private final Integer code;
    private final String message;

}
