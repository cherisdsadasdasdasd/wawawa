package cn.it.mapper;

import cn.it.domain.Busines;
import org.apache.ibatis.annotations.Select;

public interface BusiesMapper {
    @Select("select * from tb_business where id=#{businessId}")
    Busines queryById(Integer businessId);
}
