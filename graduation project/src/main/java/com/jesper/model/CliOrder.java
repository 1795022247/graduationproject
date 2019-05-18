package com.jesper.model;

import java.io.Serializable;
import java.util.Date;

public class CliOrder implements Serializable {
    private Integer id;

    private Integer hotolId;

    private Integer roomId;

    private Integer clientId;

    private Date cateateDate;

    private Date endDate;

    private Integer count;

    private Integer deposi;

    private Integer totalprice;

    private Integer sign;

    private Integer status;

    private String content;

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

    public Integer getHotolId() {
        return hotolId;
    }

    public void setHotolId(Integer hotolId) {
        this.hotolId = hotolId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Date getCateateDate() {
        return cateateDate;
    }

    public void setCateateDate(Date cateateDate) {
        this.cateateDate = cateateDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getDeposi() {
        return deposi;
    }

    public void setDeposi(Integer deposi) {
        this.deposi = deposi;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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