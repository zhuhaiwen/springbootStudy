package com.founder.entity.log;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTLoggerInfosEntity is a Querydsl query type for TLoggerInfosEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTLoggerInfosEntity extends EntityPathBase<TLoggerInfosEntity> {

    private static final long serialVersionUID = -598225715L;

    public static final QTLoggerInfosEntity tLoggerInfosEntity = new QTLoggerInfosEntity("tLoggerInfosEntity");

    public final StringPath clientIp = createString("clientIp");

    public final StringPath httpStatusCode = createString("httpStatusCode");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath method = createString("method");

    public final StringPath paramData = createString("paramData");

    public final StringPath returnData = createString("returnData");

    public final StringPath returnTime = createString("returnTime");

    public final StringPath sessionId = createString("sessionId");

    public final DateTimePath<java.sql.Timestamp> time = createDateTime("time", java.sql.Timestamp.class);

    public final NumberPath<Integer> timeConsuming = createNumber("timeConsuming", Integer.class);

    public final StringPath type = createString("type");

    public final StringPath uri = createString("uri");

    public QTLoggerInfosEntity(String variable) {
        super(TLoggerInfosEntity.class, forVariable(variable));
    }

    public QTLoggerInfosEntity(Path<? extends TLoggerInfosEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTLoggerInfosEntity(PathMetadata metadata) {
        super(TLoggerInfosEntity.class, metadata);
    }

}

