package com.jesper.model;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {
    private Integer id;

    private String goodName;

    private Integer hotolId;

    private Integer typeId;

    private String price;

    private String count;

    private String image;

    private String remarks;

    private Date createDate;

    private String sign;

    private String roomId;

    private String flag1;

    private String falg2;

    private String flag3;

    private String flag4;

    private String flag5;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getHotolId() {
        return hotolId;
    }

    public void setHotolId(Integer hotolId) {
        this.hotolId = hotolId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getFlag1() {
        return flag1;
    }

    public void setFlag1(String flag1) {
        this.flag1 = flag1;
    }

    public String getFalg2() {
        return falg2;
    }

    public void setFalg2(String falg2) {
        this.falg2 = falg2;
    }

    public String getFlag3() {
        return flag3;
    }

    public void setFlag3(String flag3) {
        this.flag3 = flag3;
    }

    public String getFlag4() {
        return flag4;
    }

    public void setFlag4(String flag4) {
        this.flag4 = flag4;
    }

    public String getFlag5() {
        return flag5;
    }

    public void setFlag5(String flag5) {
        this.flag5 = flag5;
    }
}