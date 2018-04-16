package com.founder.dao.log;

import com.founder.entity.log.TLoggerInfosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhwen
 * @version 1.0
 * @company 北大方正电子
 * @date 2017-11-30 10:50
 **/
public interface TLogDao extends JpaRepository<TLoggerInfosEntity, Integer> {

}
