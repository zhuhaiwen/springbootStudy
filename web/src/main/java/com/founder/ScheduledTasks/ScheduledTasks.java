package com.founder.ScheduledTasks;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 *
 * @author zhuhw
 * @date 2018/5/11 19:31
 */
@Configuration
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime () {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
