package cn.it.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Goods {
    private Integer id;
    private String name;
    private Integer realPrice;
    private Integer discountPrice;
    private String imageUrl;
    private String norms;
    private Integer stock;
    private String description;
    private Integer isShow;
    private Date createTime;
    private Date updateTime;
    private Integer typeId;
    private Integer businessId;
}
