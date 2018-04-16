package com.founder.utils.solr.controller;

import com.founder.utils.solr.doc.QueryDoc;
import com.founder.utils.solr.service.ISolrService;
import com.founder.utils.solr.solrutil.SolrHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhwen
 * @date 2018-01-22
 **/
@RestController
@RequestMapping(value = "${drap.api.base-path:/api}/solr", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(description = "索引接口")
public class SolrApi {

    private static Logger logger = LoggerFactory.getLogger(SolrApi.class);

    @Autowired
    private ISolrService solrService;

    @Autowired
    private SolrHelper solrHelper;

    @ApiOperation(value = "删除所有索引", notes = "删除所有索引")
    @RequestMapping(value = "/deleteAllIndexs", method = RequestMethod.GET)
    public void deleteAllIndexs () {
        try {
            solrService.deleteAllIndexs();
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /*@ApiOperation(value = "根据名字查询索引", notes = "根据名字查询索引")
    @RequestMapping(value = "/searchForPageByName", method = RequestMethod.GET)
    public Page<QueryDoc> searchForPageByName (String queryWord) {
        String[] words = queryWord.split(",");
        Criteria conditions = solrHelper.createSearchConditions(words);
        SimpleQuery simpleQuery = new SimpleQuery(conditions);
        simpleQuery.addSort(solrHelper.sortByIdDesc());
        return solrService.searchForPageByName(simpleQuery, QueryDoc.class);
    }*/

    @ApiOperation(value = "根据名字查询索引", notes = "根据名字查询索引")
    @RequestMapping(value = "/searchForPageByName", method = RequestMethod.GET)
    public Page<QueryDoc> findByName (@RequestParam("name") String name, Pageable pageable) {
       return solrService.findByName(name, pageable);
    }

}
