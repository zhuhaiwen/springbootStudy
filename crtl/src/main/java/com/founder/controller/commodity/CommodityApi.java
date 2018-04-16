package com.founder.controller.commodity;

import com.founder.dao.commodity.TCommdityDao;
import com.founder.entity.commodity.QTCommodityEntity;
import com.founder.entity.commodity.TCommodityEntity;
import com.querydsl.jpa.impl.JPAQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author zhwen
 * @version 1.0
 * @company 北大方正电子
 * @date 2017-12-11 11:26
 **/
@RestController
@RequestMapping(value = "${drap.api.base-path:/api}/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(description = "商品信息接口")
public class CommodityApi {

    @Autowired
    private TCommdityDao commdityDao;

    @PersistenceContext
    private EntityManager entityManager;

    @ApiOperation(value = "根据商品类型查询所有商品", notes = "根据商品类型查询所有商品")
    @RequestMapping(value = "/listAllCommodityByType", method = RequestMethod.GET)
    public List<TCommodityEntity> list() {
        // Querydsl 查询实体
        QTCommodityEntity qtCommodityEntity = QTCommodityEntity.tCommodityEntity;

        // 构建JPA查询对象
        JPAQuery<TCommodityEntity> jpaQuery = new JPAQuery<>(entityManager);
        // 返回查询接口
        return jpaQuery.select(qtCommodityEntity).from(qtCommodityEntity)
                .where(qtCommodityEntity.commodityclassifyinfoEntity.tId.eq(Integer.parseInt("1")))
                .fetch();
    }
}
