package com.founder.utils.solr;

import java.util.Date;
import java.util.List;

/**
 * ICondition
 *
 * @author Chensong
 * @date 2016/9/8
 */
public interface ICondition {

    void setQ(String q);

    void setQ1(String q1);

    void setA(String alpha);

    // 字段
    void setField(String field);

    void setT(Integer t);

}
