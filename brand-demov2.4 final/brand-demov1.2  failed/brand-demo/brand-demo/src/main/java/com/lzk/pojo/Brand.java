package com.lzk.pojo;

/**
 * 品牌实体类
 */

public class Brand {
    // id 主键
    private Integer id;
    // 品牌名称
    private String brandName;
    // 企业名称
    private String goodsName;
    // 排序字段
    private Integer price;
    // 描述信息
    private String adv;

    private Integer status;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    private Integer userid;
private Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAdv() {
        return adv;
    }

    public void setAdv(String adv) {
        this.adv = adv;
    }


    public Brand() {
    }

    public Brand(Integer id, String brandName, String goodsName, String adv) {
        this.id = id;
        this.brandName = brandName;
        this.goodsName = goodsName;
        this.adv = adv;
    }

    public Brand(Integer id, String brandName, String goodsName, Integer price, String adv, Integer status) {
        this.id = id;
        this.brandName = brandName;
        this.goodsName = goodsName;
        this.price = price;
        this.adv = adv;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }





    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status>0 ? status:0 ;
    }



    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", adv='" + adv + '\'' +
                ", status=" + status +
                '}';
    }
}
