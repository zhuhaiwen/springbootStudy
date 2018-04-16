package com.founder.utils.solr.service.impl;

import com.founder.utils.solr.dao.SolrDao;
import com.founder.utils.solr.doc.QueryDoc;
import com.founder.utils.solr.service.ISolrService;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.mapping.SolrDocument;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.data.solr.repository.support.SimpleSolrRepository;
import org.springframework.data.solr.server.support.SolrClientUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhwen
 * @date 2017-12-28
 **/
@Service
public class SolrServiceImpl extends SimpleSolrRepository<QueryDoc, String> implements ISolrService {

    private Logger logger = LoggerFactory.getLogger(SolrServiceImpl.class);

    // 获取solr的core(即数据库)名
    private final String coreName = QueryDoc.class.getAnnotation(SolrDocument.class).solrCoreName();

    private HttpSolrClient solrClient;

    private SolrTemplate solrTemplate;

    @Autowired
    private void setSolrTemplate(SolrClient solrClient) { // 基于solrClient注入solrTemplate,同时更新solrClient
        this.solrTemplate = new SolrTemplate(SolrClientUtils.clone(solrClient), coreName);
        solrTemplate.afterPropertiesSet();
        this.solrClient = (HttpSolrClient) solrTemplate.getSolrClient();
    }

    @Autowired
    private SolrDao solrDao;

    @Transactional
    @Override
    public String addQueryDoc(Map<String, Object> document) throws IOException, SolrServerException {
        if (!document.keySet().contains("id") || document.get("id") == null) {
            return null;
        }
        System.out.println(solrClient.getBaseURL());
        String id = document.get("id").toString();
        if (StringUtils.isNotBlank(id)) {
            solrClient.deleteById(id); // 首先根据id删除之前旧的数据
            solrClient.commit(); // 提交事务
            SolrInputDocument indexDocument = convertJsonToDocument(document);
            SolrResponse response = solrClient.add(indexDocument); // 再插入新的数据
            solrClient.commit();
            return response.toString();
        }
        return null;
    }

    @Transactional
    @Override
    public String batchInsertIndex(List<Map<String, Object>> documents) throws IOException, SolrServerException {

        if (documents.isEmpty()) {
            return "";
        }
        List<String> ids = new ArrayList<String>();
        List<SolrInputDocument> solrInputDocuments = new ArrayList<>();
        for (Map<String, Object> doc : documents) {
            ids.add(MapUtils.getString(doc, "id"));
            solrInputDocuments.add(convertJsonToDocument(doc));
        }
        solrClient.deleteById(ids);
        solrClient.commit();
        SolrResponse response = solrClient.add(solrInputDocuments);
        solrClient.commit();
        return response.toString();
    }

    @Transactional
    @Override
    public String deleteByID(String id) throws IOException, SolrServerException {
        logger.info("删除开始...");
        SolrResponse response = solrClient.deleteById(id);
        solrClient.commit();
        logger.info("删除结束...");
        return response.toString();
    }

    @Transactional
    @Override
    public String deleteByIDs(List<String> ids) throws IOException, SolrServerException {

        SolrResponse response = solrClient.deleteById(ids);
        solrClient.commit();
        return response.toString();
    }

    @Transactional
    @Override
    public String deleteByName(String name) throws IOException, SolrServerException {
        SolrResponse response = solrClient.deleteByQuery("name:" + name); // 键值对
        solrClient.commit();
        return response.toString();
    }

    @Transactional
    @Override
    public String deleteAllIndexs() throws IOException, SolrServerException {
        SolrResponse response = solrClient.deleteByQuery("*:*");
        solrClient.commit();
        return response.toString();
    }


    @Override
    public List<QueryDoc> findByName(String name) {
//        solrTemplate.query(QU)
        return this.findByName(name);
    }

    private SolrInputDocument convertJsonToDocument(Map<String, Object> document) {
        SolrInputDocument solrInputDocument = new SolrInputDocument();

        for (Map.Entry<String, Object> entry : document.entrySet()) {
            solrInputDocument.addField(entry.getKey(), entry.getValue());
        }

        return solrInputDocument;
    }

    @Transactional
    @Override
    public void saveQueryDocIndex(QueryDoc queryDoc) {
        solrDao.save(queryDoc);
    }

    @Override
    public ScoredPage<QueryDoc> searchForPageByName(SimpleQuery simpleQuery, Class clazz) {
        return solrTemplate.queryForPage(simpleQuery, clazz);
    }

    @Override
    public Page<QueryDoc> findByName(String name, Pageable pageable) {
        return solrDao.findByName(name, pageable);
    }
}
