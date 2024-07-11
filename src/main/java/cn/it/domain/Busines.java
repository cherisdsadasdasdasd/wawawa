package cn.it.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Busines {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String image_url;
    private String type;
    private String address;
    private Integer fans;
    private String description;
    private Integer status;
    private String create_time;
    private String update_time;
    private Integer role_id;
    private Integer type1;
    private Integer type2;
    private Integer type3;
    private Integer type4;
    private Integer type5;
    private Integer value1;
    private Integer value2;
}
