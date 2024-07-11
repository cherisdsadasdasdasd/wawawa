package cn.it.controller;


import cn.it.domain.Car;
import cn.it.service.ICarService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {


    @Autowired
    private ICarService iCarService;
    @RequestMapping("/findCarById")
    public Car findCarById(Integer id){
        Car car=iCarService.selectOne(id);
        System.out.println(id);
        System.out.println(car);
        return car;
    }

    @RequestMapping("/findAll")
    public List<Car> findAll(){

       PageHelper.startPage(2,5);/*mybatis提供了拦截器实现的*/

        List<Car> list= (Page)iCarService.findAll();
        System.out.println(list);

        Car car=new Car();
        car.setId(1111);
        System.out.println(car);
        
        for (Car c:list) {
            System.out.println(c);
        }
        return list;
    }
}
