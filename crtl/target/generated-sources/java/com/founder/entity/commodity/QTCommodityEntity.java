package com.founder.entity.commodity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTCommodityEntity is a Querydsl query type for TCommodityEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTCommodityEntity extends EntityPathBase<TCommodityEntity> {

    private static final long serialVersionUID = 1075823964L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTCommodityEntity tCommodityEntity = new QTCommodityEntity("tCommodityEntity");

    public final QTCommodityclassifyinfoEntity commodityclassifyinfoEntity;

    public final NumberPath<Integer> tId = createNumber("tId", Integer.class);

    public final StringPath tOrder = createString("tOrder");

    public final NumberPath<java.math.BigDecimal> tPrice = createNumber("tPrice", java.math.BigDecimal.class);

    public final StringPath tTitle = createString("tTitle");

    public final StringPath tUnit = createString("tUnit");

    public QTCommodityEntity(String variable) {
        this(TCommodityEntity.class, forVariable(variable), INITS);
    }

    public QTCommodityEntity(Path<? extends TCommodityEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTCommodityEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTCommodityEntity(PathMetadata metadata, PathInits inits) {
        this(TCommodityEntity.class, metadata, inits);
    }

    public QTCommodityEntity(Class<? extends TCommodityEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.commodityclassifyinfoEntity = inits.isInitialized("commodityclassifyinfoEntity") ? new QTCommodityclassifyinfoEntity(forProperty("commodityclassifyinfoEntity")) : null;
    }

}

