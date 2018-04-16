package com.founder.entity.log;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TLoggerInfosEntity.class)
public abstract class TLoggerInfosEntity_ {

	public static volatile SingularAttribute<TLoggerInfosEntity, Integer> timeConsuming;
	public static volatile SingularAttribute<TLoggerInfosEntity, String> method;
	public static volatile SingularAttribute<TLoggerInfosEntity, String> returnData;
	public static volatile SingularAttribute<TLoggerInfosEntity, String> clientIp;
	public static volatile SingularAttribute<TLoggerInfosEntity, String> paramData;
	public static volatile SingularAttribute<TLoggerInfosEntity, Integer> id;
	public static volatile SingularAttribute<TLoggerInfosEntity, String> sessionId;
	public static volatile SingularAttribute<TLoggerInfosEntity, Timestamp> time;
	public static volatile SingularAttribute<TLoggerInfosEntity, String> type;
	public static volatile SingularAttribute<TLoggerInfosEntity, String> uri;
	public static volatile SingularAttribute<TLoggerInfosEntity, String> returnTime;
	public static volatile SingularAttribute<TLoggerInfosEntity, String> httpStatusCode;

}

