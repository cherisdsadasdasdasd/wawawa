package cn.it.service;

import cn.it.domain.Car;

import java.util.List;

public interface ICarService {
    public Car selectOne(Integer id);
    public List<Car> findAll();
}
