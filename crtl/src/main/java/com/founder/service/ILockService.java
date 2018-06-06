package com.founder.service;

/**
 * @author zhuhw
 * @date 2018/6/5 11:41
 */
public interface ILockService {

    /**
     * 尝试获取分布式锁
     *
     * @param lockKey
     * @param requestId
     * @param expireTime
     * @return
     */
    public boolean lock (String lockKey,String requestId, int expireTime);


    /**
     * 释放分布式锁
     *
     * @param lockKey
     * @param requestId
     * @return
     */
    public boolean unlock (String lockKey, String requestId);
}
