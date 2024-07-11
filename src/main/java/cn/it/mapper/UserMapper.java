package cn.it.mapper;

import cn.it.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {


    @Select("select * from tb_user where open_id=#{openId}")
    User queryByOpenId(String openId);
    @Select("insert into tb_user(image_url,nick_name,open_id) values(#{avatarUrl},#{nickName},#{openid})")
    void  insert(@Param("openid") String openid,@Param("avatarUrl") String avatarUrl,@Param("nickName") String nickName);
}
