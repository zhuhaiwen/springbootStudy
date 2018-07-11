package com.founder.utils.amqp;

import com.founder.utils.amqp.sender.IndexSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * @author zhuhw
 * @date 2018/5/29 17:47
 */
//@Configuration
public class SysQueueConfig {

    @Bean
    public Queue deathQueue () {
        return new Queue(IndexSender.MQ_INDEX);
    }
}
