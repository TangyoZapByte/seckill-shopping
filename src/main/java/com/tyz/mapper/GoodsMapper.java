package com.tyz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyz.pojo.Goods;
import com.tyz.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author tyz
 * @since 2024-05-21
 */
public interface GoodsMapper extends BaseMapper<Goods> {


    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
