package com.founder.utils.solr.solrutil;

import org.apache.commons.lang3.reflect.MethodUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

/**
 * @author zhwen
 * @date 2018-01-22
 **/
@Component
public class SolrHelper {

    public Criteria createSearchConditions(String[] words) {
        Criteria conditions = null;

        for (String word: words) {
            if (conditions == null) {
                conditions = new Criteria("NAME_s").contains(word)
                        .or(new Criteria("COMMENT_s").contains(word));
            }
            else {
                conditions = conditions.or(new Criteria("id").contains(word))
                        .or(new Criteria("COMMENT_s").contains(word));
            }
        }

        return conditions;
    }

    public Sort sortByIdDesc() {
        return new Sort(Sort.Direction.DESC,  "id");
    }

    /**
     * HighlightPage 转 Page
     *
     * @param highlightPage
     * @param pageable
     * @param <T>
     * @return
     */
    /*public static <T> Page<T> toPageBySetMethod(ScoredPage<T> highlightPage, Pageable pageable) {
        for (T t : highlightPage.getContent()) {
            for (HighlightEntry.Highlight highlight : highlightPage.getHighlights(t)) {
                String field = highlight.getField().getName();
                if (!"DOC_ALLTEXT".equals(field)) {
                    field = field.substring(0, field.lastIndexOf("_"));
                }
                String setMethodName = "set" + field;

                Object value = highlight.getSnipplets().get(0);
                try {
                    MethodUtils.invokeMethod(t, setMethodName, value);
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return new PageImpl(highlightPage.getContent(), pageable, highlightPage.getTotalElements());
    }*/

    /**
     * HighlightQuery 对象
     *
     * @param query
     * @return
     */
    public static HighlightQuery highlightQuery(Query query) {
        return SimpleQuery.fromQuery(query, new SimpleHighlightQuery());
    }
}
