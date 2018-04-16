package com.founder.utils.solr.service;

import com.founder.utils.solr.doc.QueryDoc;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author zhwen
 * @date 2017-12-28
 **/
public interface ISolrService {

    /**
     * 插入索引
     *
     * @param document
     * @return
     * @throws IOException
     * @throws SolrServerException
     */
    public String addQueryDoc(Map<String, Object> document) throws IOException, SolrServerException;

    /**
     * 批量插入索引
     *
     * @param documents
     * @return
     * @throws IOException
     * @throws SolrServerException
     */
    public String batchInsertIndex (List<Map<String, Object>> documents) throws IOException, SolrServerException;

    /**
     * 根据id删除索引
     *
     * @param id
     * @return
     */
    public String deleteByID (String id) throws IOException, SolrServerException;


    /**
     * 通过id批量删除索引
     *
     * @param ids
     * @return
     * @throws IOException
     * @throws SolrServerException
     */
    public String deleteByIDs (List<String> ids) throws IOException, SolrServerException;

    /**
     * 通过其它字段删除索引(比如name)
     *
     * @param name
     * @return
     * @throws IOException
     * @throws SolrServerException
     */
    public String deleteByName (String name) throws IOException, SolrServerException;

    /**
     * 删除索引
     *
     * @return
     * @throws IOException
     * @throws SolrServerException
     */
    public String deleteAllIndexs () throws IOException, SolrServerException;

    /**
     * 根据名字查询索引
     *
     * @param name
     * @return
     */
    public List<QueryDoc> findByName (String name);

    /**
     * 以对象的形式保存索引对象
     *
     * @param queryDoc
     */
    public void saveQueryDocIndex(QueryDoc queryDoc);

    ScoredPage<QueryDoc> searchForPageByName (SimpleQuery simpleQuery, Class clazz);

    Page<QueryDoc> findByName (String name, Pageable pageable);
}
