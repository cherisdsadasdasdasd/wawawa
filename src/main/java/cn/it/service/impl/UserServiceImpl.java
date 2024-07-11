package cn.it.service.impl;

import cn.it.domain.User;
import cn.it.mapper.UserMapper;
import cn.it.service.IUserService;
import cn.it.util.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Result login(String code, String avatarUrl, String nickName) {
        String openid=null;
        System.out.println("code = " + code + ", avatarUrl = " + avatarUrl + ", nickName = " + nickName);

        //发送网络请求查询当前用户的openID
        String url="https://api.weixin.qq.com/sns/jscode2session?appid=wxcf8393d647f28191&secret=e8b9d13befd3299b001d3609a51a6c32" +
                "&js_code="+code+"&grant_type=authorization_code";

        //发送get请求
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> forEntity= restTemplate.getForEntity(url,String.class);
        System.out.println(forEntity.getHeaders());
        System.out.println(forEntity.getBody());
        //拿到openid
        //字符串转化为json
        ObjectMapper jsonNode=new ObjectMapper();

        try {
             JsonNode jsonNode1= jsonNode.readTree(forEntity.getBody());

            openid=jsonNode1.get("openid").asText();
            System.out.println(openid);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        if(openid!=null && !"".equals(openid)){
            //去查询数据库

            User user= userMapper.queryByOpenId(openid);
            System.out.println(user);
            if(user!=null){

                return new Result(200,"登陆成功",user);
            }else{
                userMapper.insert(openid,avatarUrl,nickName);
                User user1=new User();
                user1.setOpenId(openid);
                user1.setImageUrl(avatarUrl);
                user1.setNickName(nickName);

                return new Result(200,"登陆成功",user1);
            }
        }else{
            return new Result(201,"登陆失败",null);
        }

    }
}
