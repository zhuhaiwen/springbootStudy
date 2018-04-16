package com.founder.utils.solr.solrutil;

import org.apache.solr.common.SolrInputDocument;

import java.util.Map;

/**
 * @author zhwen
 * @date 2017-12-28
 **/
public class SolrUtils {
    /**
     * JSONObject转化为solr文档
     *
     * @param document 待转换的doc对象
     * @return
     */
    private SolrInputDocument convertJsonToDocument(Map<String, Object> document) {
        SolrInputDocument solrInputDocument = new SolrInputDocument();

        for (Map.Entry<String, Object> entry : document.entrySet()) {
            solrInputDocument.addField(entry.getKey(), entry.getValue());
        }

        return solrInputDocument;
    }
}
