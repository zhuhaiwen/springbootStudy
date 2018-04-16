package com.founder.utils.solr.dao;

import com.founder.utils.solr.doc.QueryDoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.Collection;

/**
 * @author zhwen
 * @date 2017-12-28
 **/
public interface SolrDao extends SolrCrudRepository<QueryDoc, String> {

    // 根据名字进行分页查询
    Page<QueryDoc> findByName (String name, Pageable pageable);

    /*@Highlight
    HighlightPage<QueryDoc> findByNameIn(Collection<String> name, Page page);

    @Query(value = "name:?0")
    @Facet(fields = { "cat" }, limit=20)
    FacetPage<QueryDoc> findByNameAndFacetOnCategory(String name, Pageable page);*/
}
