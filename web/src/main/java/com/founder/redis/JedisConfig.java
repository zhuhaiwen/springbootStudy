package com.founder.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author zhuhw
 * @date 2018/6/5 15:14
 */
@Configuration
public class JedisConfig {

    private Logger logger = LoggerFactory.getLogger(JedisConfig.class);

    @Bean(name= "jedisPoolcConfig")
    public JedisPoolConfig jedisPoolConfig (@Value("${spring.redis.pool.max-idle}")int maxIdle,
                                            @Value("${spring.redis.pool.max-wait}")int maxWaitMillis) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(maxWaitMillis);
        return config;
    }

    @Bean(name= "jedisPool")
    public JedisPool jedisPool(@Qualifier("jedisPoolcConfig") JedisPoolConfig config,
                               @Value("${spring.redis.host}")String host,
                               @Value("${spring.redis.port}")int port) {
        logger.info("缓存服务器的地址："+host+":"+port);
        return new JedisPool(config, host, port);
    }
}
