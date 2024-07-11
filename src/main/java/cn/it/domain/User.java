package cn.it.domain;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String nickName;
    private String openId;
    private String imageUrl;
    private String sessionKey;
    private String token;
    private String address;
    private String phone;
    private String description;
    private Integer status;


}
