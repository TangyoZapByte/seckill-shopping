package com.tyz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tyz.pojo.Order;
import com.tyz.pojo.SeckillOrder;
import com.tyz.pojo.User;
import com.tyz.service.GoodsService;
import com.tyz.service.OrderService;
import com.tyz.service.SeckillOrderService;
import com.tyz.vo.GoodsVo;
import com.tyz.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:秒杀
 * @author tangyizuo
 * @since 2024/5/21 17:15
 * @return:
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private SeckillOrderService seckillOrderService;

    @Autowired
    private OrderService orderService;

    /**
     * @description:秒杀
     * @author tangyizuo
     * @since 2024/5/21 17:17
     * @return: java.lang.String
     */
    @RequestMapping("/doSeckill")
    public String doSeckill(Model model, User user,Long goodsId){
        if(user == null){
            return "login";
        }
        model.addAttribute("user",user);
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        if(goods.getStockCount() < 1){
            model.addAttribute("errmsg", RespBeanEnum.EMPTY_ERROR);
            return "seckillFail";
        }

        SeckillOrder seckillorder = seckillOrderService.getOne(new QueryWrapper<SeckillOrder>().eq("user_id", user.getId()).eq("goods_id", goodsId));
        if(seckillorder != null){
            model.addAttribute("errmsg",RespBeanEnum.REPEATE_ERROR);
            return "seckillFail";
        }
        Order order = orderService.seckill(user,goods);
        model.addAttribute("order",order);
        model.addAttribute("goods",goods);
        return "orderDetail";
    }
}
