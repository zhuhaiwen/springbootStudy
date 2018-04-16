package com.founder.redis;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

/**
 * CacheConfiguration
 *
 * @author zhuhw
 * @date 2017/12/12
 */
@EnableCaching
@Configuration
public class CacheConfiguration {

    @Value("${spring.application.name}")
    private String projectName;

    @Bean
    @ConditionalOnClass(RedisTemplate.class)
    public RedisTemplate<Object, Object> redisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }

    @Bean
    public KeyGenerator cacheKey() {
        return (target, method, params) -> projectName + ":" + method.getName() + ":" + StringUtils.join(params, ",");
    }

    @Bean
    public KeyGenerator firstDocIdCacheKey() {
        return (target, method, params) -> {
            String docId = (null == params || params.length == 0) ? "" : params[0].toString();
            return projectName + ":" + method.getName() + ":" + docId;
        };
    }

    @Bean
    public KeyGenerator doubleParamsCacheKey() {
        return (target, method, params) -> {
            String docId = (null == params || params.length <= 0) ? "" : params[0].toString();
            String field = (null == params || params.length <= 1) ? "" : params[1].toString();
            return projectName + ":" + method.getName() + ":" + docId + "," + field;
        };
    }
}
