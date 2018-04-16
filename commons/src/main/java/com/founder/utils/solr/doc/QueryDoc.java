package com.founder.utils.solr.doc;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Dynamic;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhwen
 * @date 2017-12-28
 **/
@SolrDocument(solrCoreName = "my_core")
public class QueryDoc {
    @Id
    private String id;

    @Field("NAME_s")
    private String name;

    @Field("PIC_s")
    private String pic;

    @Field("PRICE_s")
    private String price;

    @Field("COMMENT_s")
    private String comment;

    @Field("CATS_*")
    @Dynamic
    private Map<String, String> CATS = new HashMap<String, String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Map<String, String> getCATS() {
        return CATS;
    }

    public void setCATS(Map<String, String> CATS) {
        this.CATS = CATS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QueryDoc queryDoc = (QueryDoc) o;

        if (id != null ? !id.equals(queryDoc.id) : queryDoc.id != null) return false;
        if (name != null ? !name.equals(queryDoc.name) : queryDoc.name != null) return false;
        if (pic != null ? !pic.equals(queryDoc.pic) : queryDoc.pic != null) return false;
        if (price != null ? !price.equals(queryDoc.price) : queryDoc.price != null) return false;
        return comment != null ? comment.equals(queryDoc.comment) : queryDoc.comment == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pic != null ? pic.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }


}
