package cn.it.controller;

import cn.it.domain.Goods;
import cn.it.service.IGoodsService;
import cn.it.util.MyException;
import cn.it.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    IGoodsService iGoodsService;

    @ResponseBody
    @RequestMapping("/queryGoodsByType")
    public Object queryGoodsByType(Integer typeId) {
        /*@RequestBody Map<String,String> map*/
        System.out.println(typeId);
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Goods> list = null;
        try {
            System.out.println(typeId);
            list = iGoodsService.queryGoodsByType(typeId);
            map.put("code", 200);
            map.put("msg", "查询成功");
            map.put("data", list);
        } catch (MyException e) {
            map.put("code", 201);
            map.put("msg", "查询成功");
            map.put("data", null);
        }
        return map;
    }

    @RequestMapping("/queryGoodsById")
    @ResponseBody
    public Object queryGoodsById(Integer id) {
        /*@RequestBody Map<String,String> map*/
        System.out.println(id);
        Result result = iGoodsService.queryGoodsById(id);
        return result;
    }

}
