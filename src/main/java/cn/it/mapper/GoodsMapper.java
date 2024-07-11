package cn.it.mapper;

import cn.it.domain.Goods;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapper {
    @Select("select * from tb_goods where business_id=#{typeId}")
    public List<Goods> queryGoodsByType(Integer typeId);

    @Select("select * from tb_goods")
    public List<Goods> queryGoodsAll();
    @Select("select * from tb_goods where id=#{Id}")
    public Goods queryGoodsById(Integer id);




}
