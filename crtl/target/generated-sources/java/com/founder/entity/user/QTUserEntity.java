package com.founder.entity.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTUserEntity is a Querydsl query type for TUserEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTUserEntity extends EntityPathBase<TUserEntity> {

    private static final long serialVersionUID = -1204487586L;

    public static final QTUserEntity tUserEntity = new QTUserEntity("tUserEntity");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath pwd = createString("pwd");

    public QTUserEntity(String variable) {
        super(TUserEntity.class, forVariable(variable));
    }

    public QTUserEntity(Path<? extends TUserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTUserEntity(PathMetadata metadata) {
        super(TUserEntity.class, metadata);
    }

}

