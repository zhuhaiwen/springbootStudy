package com.founder.entity.commodity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TCommodityEntity.class)
public abstract class TCommodityEntity_ {

	public static volatile SingularAttribute<TCommodityEntity, String> tUnit;
	public static volatile SingularAttribute<TCommodityEntity, TCommodityclassifyinfoEntity> commodityclassifyinfoEntity;
	public static volatile SingularAttribute<TCommodityEntity, String> tTitle;
	public static volatile SingularAttribute<TCommodityEntity, String> tOrder;
	public static volatile SingularAttribute<TCommodityEntity, BigDecimal> tPrice;
	public static volatile SingularAttribute<TCommodityEntity, Integer> tId;

}

