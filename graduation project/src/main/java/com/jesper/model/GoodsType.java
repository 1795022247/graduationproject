package com.jesper.model;

import java.io.Serializable;
import java.util.Date;

public class GoodsType implements Serializable {
    private Integer id;

    private String typeNmae;

    private Date createDate;

    private String flag1;

    private String flag2;

    private String flag3;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeNmae() {
        return typeNmae;
    }

    public void setTypeNmae(String typeNmae) {
        this.typeNmae = typeNmae;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
}