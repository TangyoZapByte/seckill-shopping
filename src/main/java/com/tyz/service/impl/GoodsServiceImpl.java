package com.tyz.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyz.mapper.GoodsMapper;
import com.tyz.pojo.Goods;
import com.tyz.service.GoodsService;
import com.tyz.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author tyz
 * @since 2024-05-21
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * @description:获取商品列表
     * @author tangyizuo
     * @since 2024/5/21 11:22
     * @return: java.util.List<com.tyz.pojo.Goods>
     */
    @Override
    public List<GoodsVo> findGoodsVo() {
        return goodsMapper.findGoodsVo();
    }
    /**
     * @description:获取商品详情
     * @author tangyizuo
     * @since 2024/5/21
     * @return: java.lang.String
     */
    @Override
    public GoodsVo findGoodsVoByGoodsId(Long goodsId) {
        return goodsMapper.findGoodsVoByGoodsId(goodsId);
    }


}
