package cn.it.controller;

import cn.it.service.IUserService;
import cn.it.util.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;
    @RequestMapping("/login")
    @ResponseBody
    public Object login(String code,String avatarUrl,String nickName){
        Result result= iUserService.login(code, avatarUrl, nickName);
        System.out.println(result);
        return result;
    }
}
