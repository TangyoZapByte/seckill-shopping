package com.tyz.controller;
import com.tyz.pojo.User;
import com.tyz.service.GoodsService;
import com.tyz.service.UserService;
import com.tyz.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;


import java.util.Date;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ThymeleafViewResolver thymeleafViewResolver;

    /**
     * @description:跳转商品列表
     * @author tangyizuo
     * @since 2024/5/20 16:15
     * @return: java.lang.String 
     */ 
    @RequestMapping("/toList")
    public String toLogin(Model model,User user){
        model.addAttribute("user",user);
        model.addAttribute("goodsList",goodsService.findGoodsVo());
        return "goodsList";
    }

    /**
     * @description:跳转商品页面
     * @author tangyizuo
     * @since 2024/5/21 16:42
     * @return: java.lang.String
     */
   @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable Long goodsId) {
         model.addAttribute("user", user);
         GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
         model.addAttribute("goods", goods);
         Date startDate = goods.getStartDate();
         Date endDate = goods.getEndDate();
         Date nowDate = new Date();
         //秒杀状态
         int secKillStatus = 0;
         //剩余开始时间
         int remainSeconds = 0;
         //秒杀还未开始
         if (nowDate.before(startDate)) {
            remainSeconds = (int) ((startDate.getTime()-nowDate.getTime())/1000);
         // 秒杀已结束
         } else if (nowDate.after(endDate)) {
            secKillStatus = 2;
            remainSeconds = -1;
         // 秒杀中
         } else {
            secKillStatus = 1;
            remainSeconds = 0;
         }
         model.addAttribute("secKillStatus",secKillStatus);
         model.addAttribute("remainSeconds",remainSeconds);
         return "goodsDetail";
}


}
