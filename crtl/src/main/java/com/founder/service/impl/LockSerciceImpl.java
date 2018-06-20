package com.founder.service.impl;

import com.founder.service.ILockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;

/**
 * @author zhuhw
 * @date 2018/6/5 11:56
 */
@Service
public class LockSerciceImpl implements ILockService {

    @Autowired
    private JedisPool jedisPool;

    @Override
    public boolean lock(String lockKey, String requestId, int expireTime) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            // 在加锁之前先查有没有锁，如果有锁，则不加
            String lockValue = jedis.get(lockKey);
            if (jedis.get(lockKey)!=null) { // 即锁并没有解除
                return false;
            }
            String result = jedis.set(lockKey, requestId, "NX", "PX", expireTime);
            if (result.equals("OK")) {
                return true;
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            jedis.close();
        }

        return false;
    }

    @Override
    public boolean unlock(String lockKey, String requestId) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
            if ("1".equals(result)) {
                return true;
            }
        }
        catch (Exception e) {

        }
        finally {
            jedis.close();
        }
        return false;
       }
}
