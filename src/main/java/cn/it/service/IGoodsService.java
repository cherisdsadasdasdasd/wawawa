package cn.it.service;

import cn.it.domain.Goods;
import cn.it.util.MyException;
import cn.it.util.Result;

import java.util.List;

public interface IGoodsService {

    List<Goods> queryGoodsByType(Integer typeId) throws MyException;
    Result queryGoodsById(Integer id);
}
