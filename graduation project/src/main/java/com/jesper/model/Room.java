package com.jesper.model;

import java.io.Serializable;

public class Room implements Serializable {
    private Integer id;

    private String roomNo;

    private String roomName;

    private String image;

    private Integer price;

    private String roomType;

    private Integer hotolId;

    private Integer sign;

    private String content;

    private String falg1;

    private String flag2;

    private String flag3;

    private String flag4;

    private String falg5;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getHotolId() {
        return hotolId;
    }

    public void setHotolId(Integer hotolId) {
        this.hotolId = hotolId;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFalg1() {
        return falg1;
    }

    public void setFalg1(String falg1) {
        this.falg1 = falg1;
    }

    public String getFlag2() {
        return flag2;
    }

    public void setFlag2(String flag2) {
        this.flag2 = flag2;
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

    public String getFalg5() {
        return falg5;
    }

    public void setFalg5(String falg5) {
        this.falg5 = falg5;
    }
}