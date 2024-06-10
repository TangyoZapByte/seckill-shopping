package com.tyz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyz.pojo.Goods;
import com.tyz.vo.GoodsVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author tyz
 * @since 2024-05-21
 */
@Service
public interface GoodsService extends IService<Goods> {
    /**
     * @description:查询商品
     * @author tangyizuo
     * @since 2024/5/21 11:21
     * @return: java.util.List<com.tyz.pojo.Goods>
     */
    List<GoodsVo> findGoodsVo();


    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
