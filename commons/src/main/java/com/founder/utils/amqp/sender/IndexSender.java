package com.founder.utils.amqp.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhuhw
 * @date 2018/5/29 16:38
 */
@Component
public class IndexSender {

    public static final String MQ_INDEX = "death";

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMag (Object obj) {
        this.amqpTemplate.convertAndSend(MQ_INDEX, obj);
    }
}
