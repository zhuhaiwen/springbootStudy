package com.founder.dao.commodity;

import com.founder.entity.commodity.TCommodityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * @author zhwen
 * @version 1.0
 * @company 北大方正电子
 * @date 2017-12-11 11:27
 **/
public interface TCommdityDao extends JpaRepository<TCommodityEntity, Integer>,
        QueryDslPredicateExecutor<TCommodityEntity>{

}
