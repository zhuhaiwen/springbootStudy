package com.founder.utils.solr.simple;

import com.founder.utils.solr.ICondition;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * SimpleCondition
 *
 * @author Chensong
 * @date 2016/9/8
 */
public class SimpleCondition implements ICondition {

    @ApiParam(value = "检索词")
    private String q;

    @ApiParam(value = "结果中检索词 1")
    private String q1;

    @ApiParam(value = "首字母拼音")
    private String a;

    @ApiParam(value = "检索字段")
    private String field;

    @ApiParam(value = "资源类型")
    private Integer t;

    public String getQ() {
        return q;
    }

    @Override
    public void setQ(String q) {
        this.q = q;
    }

    public String getQ1() {
        return q1;
    }

    @Override
    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getA() {
        return a;
    }

    @Override
    public void setA(String a) {
        this.a = a;
    }

    public String getField() {
        return field;
    }

    @Override
    public void setField(String field) {
        this.field = field;
    }

    public Integer getT() {
        return t;
    }

    @Override
    public void setT(Integer t) {
        this.t = t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleCondition that = (SimpleCondition) o;

        if (q != null ? !q.equals(that.q) : that.q != null) return false;
        if (q1 != null ? !q1.equals(that.q1) : that.q1 != null) return false;
        if (field != null ? !field.equals(that.field) : that.field != null) return false;
        if (t != null ? !t.equals(that.t) : that.t != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = q != null ? q.hashCode() : 0;
        result = 31 * result + (q1 != null ? q1.hashCode() : 0);
        result = 31 * result + (field != null ? field.hashCode() : 0);
        result = 31 * result + (t != null ? t.hashCode() : 0);
        return result;
    }

    public <Q extends ICondition> Q parse(Class<Q> clazz) {
        Q t = org.springframework.beans.BeanUtils.instantiate(clazz);
        // 优先设置 字段
        t.setField(this.getField());
        BeanUtils.copyProperties(t, this);
        return t;
    }
}
