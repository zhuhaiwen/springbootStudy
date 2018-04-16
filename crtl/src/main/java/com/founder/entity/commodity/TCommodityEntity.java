package com.founder.entity.commodity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author zhwen
 * @version 1.0
 * @company 北大方正电子
 * @date 2017-12-11 11:18
 **/
@Entity
@Table(name = "t_commodity")
public class TCommodityEntity {
    private int tId;
    private String tTitle;
    private BigDecimal tPrice;
    private String tUnit;
    private String tOrder;
    private TCommodityclassifyinfoEntity commodityclassifyinfoEntity;

    @Id
    @Column(name = "t_id")
    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    @Basic
    @Column(name = "t_title")
    public String gettTitle() {
        return tTitle;
    }

    public void settTitle(String tTitle) {
        this.tTitle = tTitle;
    }

    @Basic
    @Column(name = "t_price")
    public BigDecimal gettPrice() {
        return tPrice;
    }

    public void settPrice(BigDecimal tPrice) {
        this.tPrice = tPrice;
    }

    @Basic
    @Column(name = "t_unit")
    public String gettUnit() {
        return tUnit;
    }

    public void settUnit(String tUnit) {
        this.tUnit = tUnit;
    }

    @Basic
    @Column(name = "t_order")
    public String gettOrder() {
        return tOrder;
    }

    public void settOrder(String tOrder) {
        this.tOrder = tOrder;
    }

    @OneToOne
    @JoinColumn(name = "t_type_id")
    public TCommodityclassifyinfoEntity getCommodityclassifyinfoEntity() {
        return commodityclassifyinfoEntity;
    }

    public void setCommodityclassifyinfoEntity(TCommodityclassifyinfoEntity commodityclassifyinfoEntity) {
        this.commodityclassifyinfoEntity = commodityclassifyinfoEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TCommodityEntity that = (TCommodityEntity) o;

        if (tId != that.tId) return false;
        if (tTitle != null ? !tTitle.equals(that.tTitle) : that.tTitle != null) return false;
        if (tPrice != null ? !tPrice.equals(that.tPrice) : that.tPrice != null) return false;
        if (tUnit != null ? !tUnit.equals(that.tUnit) : that.tUnit != null) return false;
        if (tOrder != null ? !tOrder.equals(that.tOrder) : that.tOrder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tId;
        result = 31 * result + (tTitle != null ? tTitle.hashCode() : 0);
        result = 31 * result + (tPrice != null ? tPrice.hashCode() : 0);
        result = 31 * result + (tUnit != null ? tUnit.hashCode() : 0);
        result = 31 * result + (tOrder != null ? tOrder.hashCode() : 0);
        return result;
    }
}
