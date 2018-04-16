package com.founder.service.impl;

import com.founder.dao.user.IUserDao;
import com.founder.entity.user.TUserEntity;
import com.founder.entity.user.TUserEntity_;
import com.founder.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zhwen
 * @version 1.0
 * @company 北大方正电子
 * @date 2017-10-28 16:30
 **/
@Service
@CacheConfig(cacheNames = "USER", keyGenerator = "cacheKey")
public class UserServiceImpl implements IUserService {

    @Value("${spring.cache.type}")
    private String cacheType;

    @Autowired
    private IUserDao userDao;

    @Autowired(required = false)
    private RedisTemplate redisTemplate;

    @Override
    public TUserEntity saveUser(TUserEntity userEntity) {
        return userDao.save(userEntity);
    }

    @Override
    public List<TUserEntity> listAllUsers() {
        return userDao.findAll();
    }

    @Override
    public Map<String,Object> login(TUserEntity userEntity) {
        String result = "登陆成功";
        boolean flag = true;
        Map<String, Object> map = new HashMap<String, Object>();
        TUserEntity user = userDao.findOne(new Specification<TUserEntity>() {
            @Override
            public Predicate toPredicate(Root<TUserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get(TUserEntity_.name), userEntity.getName()));
                return null;
            }
        });
        // 用户不存在
        if (user == null) {
            result = "用户不存在, 登录失败";
            flag = false;
        }
        else if (!userEntity.getPwd().equals(user.getPwd())) {
            result = "用户密码错误, 登录失败";
            flag = false;
        }
        map.put("msg", result);
        if (flag) {
            map.put("user", user);
            map.put("success", 1);
            return map;
        }
        else {
            map.put("success", -1);
        }
        return map;
    }

//    @Cacheable
    @Override
    public List<TUserEntity> getUsersByAge(int age) {
        return userDao.getUsersByAge(age);
    }

    @Transactional
    @Override
    public void deleteUserByNameAndPwd(String name, String pwd) { // 增删改查,除了查,其他都需要事务控制
        userDao.deleteUserByNameAndPwd(name, pwd);
    }

    @Override
    public Page<TUserEntity> findByName(String name, Pageable pageable) {
        return userDao.findByName(name, pageable);
    }

    @Override
    public void clearCache(String param) {
        if (!"REDIS".equalsIgnoreCase(cacheType)) {
            redisTemplate = null;
        }
        if (redisTemplate != null) {
            Set userCache = redisTemplate.keys("USER*");
            redisTemplate.delete(userCache);
        }
    }
}
