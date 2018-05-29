package com.founder.utils.amqp.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhuhw
 * @date 2018/5/29 16:33
 */
@Component
public class IndexReceiver {

    public static final String MQ_INDEX = "death";

    @RabbitListener(queues = MQ_INDEX)
    @RabbitHandler
    public void deathIndex (Object obj) {
        System.out.println(obj);
    }
}
