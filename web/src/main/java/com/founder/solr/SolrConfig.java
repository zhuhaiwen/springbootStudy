package com.founder.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author zhwen
 * @date 2017-12-27
 **/
@Configuration
public class SolrConfig {
    @Autowired
    private Environment environment;

    @Bean
    public SolrClient solrClient () {
        return new HttpSolrClient(environment.getRequiredProperty("spring.data.solr.host"));
    }
}
