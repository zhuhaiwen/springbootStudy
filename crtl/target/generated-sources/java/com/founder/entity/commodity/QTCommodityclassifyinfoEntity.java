package com.founder.entity.commodity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTCommodityclassifyinfoEntity is a Querydsl query type for TCommodityclassifyinfoEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTCommodityclassifyinfoEntity extends EntityPathBase<TCommodityclassifyinfoEntity> {

    private static final long serialVersionUID = 522303374L;

    public static final QTCommodityclassifyinfoEntity tCommodityclassifyinfoEntity = new QTCommodityclassifyinfoEntity("tCommodityclassifyinfoEntity");

    public final NumberPath<Integer> tId = createNumber("tId", Integer.class);

    public final StringPath tIsShow = createString("tIsShow");

    public final StringPath tName = createString("tName");

    public final NumberPath<Integer> tOrder = createNumber("tOrder", Integer.class);

    public QTCommodityclassifyinfoEntity(String variable) {
        super(TCommodityclassifyinfoEntity.class, forVariable(variable));
    }

    public QTCommodityclassifyinfoEntity(Path<? extends TCommodityclassifyinfoEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTCommodityclassifyinfoEntity(PathMetadata metadata) {
        super(TCommodityclassifyinfoEntity.class, metadata);
    }

}

