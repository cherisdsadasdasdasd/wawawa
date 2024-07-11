package cn.it.service.impl;

import cn.it.domain.Busines;
import cn.it.domain.Goods;
import cn.it.mapper.BusiesMapper;
import cn.it.mapper.GoodsMapper;
import cn.it.service.IGoodsService;
import cn.it.util.MyException;
import cn.it.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    BusiesMapper busiesMapper;
    @Override
    public List<Goods> queryGoodsByType(Integer typeId) throws MyException {

        if(typeId == null){
            throw new MyException(("请传入正确的id"));
        }else{
            if(typeId == 0){
                return goodsMapper.queryGoodsAll();
            }else{
                return goodsMapper.queryGoodsByType(typeId);
            }

        }
    }

    @Override
    public Result queryGoodsById(Integer id) {

        if(id==null){
            return new Result(201,"商品id没填写",null);
        }else {
            //查询商品
            Goods goods=goodsMapper.queryGoodsById(id);
            if(goods == null){
                return new Result(201,"此商品不存在",null);
            }
            //查询店铺
            Integer businessId=goods.getBusinessId();
            Busines busines= busiesMapper.queryById(businessId);
            HashMap<String,Object> map=new HashMap<>();
            map.put("goods",goods);
            map.put("busines",busines);
            return  new Result(200,"查询成功",map);
        }


    }

}
