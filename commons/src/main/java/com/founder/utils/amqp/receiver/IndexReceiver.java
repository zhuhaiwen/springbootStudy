package com.founder.utils.amqp.receiver;

/**
 * @author zhuhw
 * @date 2018/5/29 16:33
 */
//@Component
public class IndexReceiver {

    public static final String MQ_INDEX = "death";

//    @RabbitListener(queues = MQ_INDEX)
//    @RabbitHandler
    public void deathIndex (Object obj) {
        System.out.println(obj);
    }
}
