package com.founder.entity.commodity;

import javax.persistence.*;

/**
 * @author zhwen
 * @version 1.0
 * @company 北大方正电子
 * @date 2017-12-11 11:19
 **/
@Entity
@Table(name = "t_commodityclassifyinfo")
public class TCommodityclassifyinfoEntity {
    private int tId;
    private String tName;
    private String tIsShow;
    private Integer tOrder;

    @Id
    @Column(name = "t_id")
    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    @Basic
    @Column(name = "t_name")
    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Basic
    @Column(name = "t_is_show")
    public String gettIsShow() {
        return tIsShow;
    }

    public void settIsShow(String tIsShow) {
        this.tIsShow = tIsShow;
    }

    @Basic
    @Column(name = "t_order")
    public Integer gettOrder() {
        return tOrder;
    }

    public void settOrder(Integer tOrder) {
        this.tOrder = tOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TCommodityclassifyinfoEntity that = (TCommodityclassifyinfoEntity) o;

        if (tId != that.tId) return false;
        if (tName != null ? !tName.equals(that.tName) : that.tName != null) return false;
        if (tIsShow != null ? !tIsShow.equals(that.tIsShow) : that.tIsShow != null) return false;
        if (tOrder != null ? !tOrder.equals(that.tOrder) : that.tOrder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tId;
        result = 31 * result + (tName != null ? tName.hashCode() : 0);
        result = 31 * result + (tIsShow != null ? tIsShow.hashCode() : 0);
        result = 31 * result + (tOrder != null ? tOrder.hashCode() : 0);
        return result;
    }
}
