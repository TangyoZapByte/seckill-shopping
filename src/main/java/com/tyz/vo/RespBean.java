package com.tyz.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @description:公共返回对象
 * @author tangyizuo
 * @since 2024/5/19 17:52
 * @return:  
 */ 
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {

    private long code;
    private String message;
    private Object obj;
    
    /**
     * @description:成功返回结果
     * @author tangyizuo
     * @since 2024/5/19 17:54
     * @return: com.tyz.vo.RespBean 
     */ 
    public static RespBean success(){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(),RespBeanEnum.SUCCESS.getMessage(),null);
    }
    /**
     * @description:返回成功结果，带对象
     * @author tangyizuo
     * @since 2024/5/19 17:58
     * @return: com.tyz.vo.RespBean
     */
    public static RespBean success(Object obj){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(),RespBeanEnum.SUCCESS.getMessage(),obj);
    }
    /**
     * @description:失败返回结果
     * @author tangyizuo
     * @since 2024/5/19 17:58
     * @return: com.tyz.vo.RespBean 
     */ 
    public static RespBean error(RespBeanEnum respBeanEnum){
        return new RespBean(respBeanEnum.getCode(),respBeanEnum.getMessage(),null);
    }
    /**
     * @description:
     * @author tangyizuo
     * @since 2024/5/19 失败返回对象，带对象
     * @return: com.tyz.vo.RespBean 
     */ 
    public static RespBean error(RespBeanEnum respBeanEnum,Object obj){
        return new RespBean(respBeanEnum.getCode(),respBeanEnum.getMessage(),obj);
    }




}
