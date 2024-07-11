package cn.it.mapper;

import cn.it.domain.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarMapper {


    public Car selectOne(Integer id);
/*    @Select("select * from tb_car") 可以直接在mapper对应的方法上面写*/
    public List<Car> findAll();
}
