package cn.it.service.impl;

import cn.it.domain.Car;
import cn.it.mapper.CarMapper;
import cn.it.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceimpl implements ICarService {

    @Autowired
    CarMapper carMapper;

    @Override
    public Car selectOne(Integer id) {

        if (id == null) {
            System.out.println("请输入id");
            return null;
        } else {
            System.out.println("调用数据库");
            Car car= carMapper.selectOne(id);
            return car;
        }

    }

    @Override
    public List<Car> findAll() {
        List<Car> list=carMapper.findAll();
        return list;
    }
}
