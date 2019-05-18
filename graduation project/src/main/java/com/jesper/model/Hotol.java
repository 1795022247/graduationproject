package com.jesper.model;

import java.io.Serializable;

public class Hotol implements Serializable {
    private Integer id;

    private String hotolName;

    private String hotolType;

    private String image;

    private String content;

    private String address;

    private Integer sign;

    private String flag1;

    private String flag2;

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

    public String getHotolName() {
        return hotolName;
    }

    public void setHotolName(String hotolName) {
        this.hotolName = hotolName;
    }

    public String getHotolType() {
        return hotolType;
    }

    public void setHotolType(String hotolType) {
        this.hotolType = hotolType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public String getFlag1() {
        return flag1;
    }

    public void setFlag1(String flag1) {
        this.flag1 = flag1;
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

    public String getFlag5() {
        return flag5;
    }

    public void setFlag5(String flag5) {
        this.flag5 = flag5;
    }
}