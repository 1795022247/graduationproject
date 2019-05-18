package com.jesper.model;

import java.io.Serializable;

public class ClientUser implements Serializable {
    private Integer id;

    private String clientName;

    private String icCard;

    private String address;

    private String phone;

    private Integer sex;

    private String email;

    private String password;

    private Integer sign;

    private Integer typeid;

    private String flag1;

    private String falg2;

    private String falg3;

    private String flag5;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getIcCard() {
        return icCard;
    }

    public void setIcCard(String icCard) {
        this.icCard = icCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
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

    public String getFalg3() {
        return falg3;
    }

    public void setFalg3(String falg3) {
        this.falg3 = falg3;
    }

    public String getFlag5() {
        return flag5;
    }

    public void setFlag5(String flag5) {
        this.flag5 = flag5;
    }
}