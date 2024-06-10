package com.tyz.vo;

import com.tyz.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;


/**
 * @description:登陆参数
 * @author tangyizuo
 * @since 2024/5/19 18:04
 * @return:  
 */
@Data
public class LoginVo {
    @NotNull
    @IsMobile
    private String mobile;

    @NotNull
    @Length(min = 32)
    private String password;
    
}
