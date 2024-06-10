package com.tyz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyz.pojo.Order;
import com.tyz.pojo.User;
import com.tyz.vo.GoodsVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author tyz
 * @since 2024-05-21
 */
@Service
public interface OrderService extends IService<Order> {

    Order seckill(User user, GoodsVo goods);
}
