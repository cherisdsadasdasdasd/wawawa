package cn.it.service;

import cn.it.util.Result;

public interface IUserService {

     Result login(String code,String avatarUrl,String nickName);

}
