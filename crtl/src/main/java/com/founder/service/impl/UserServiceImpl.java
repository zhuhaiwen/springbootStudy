package com.founder.service.impl;

import com.founder.dao.user.IUserDao;
import com.founder.entity.user.TUserEntity;
import com.founder.entity.user.TUserEntity_;
import com.founder.service.IUserService;
import com.founder.utils.amqp.sender.IndexSender;
import com.founder.utils.globalexception.MyException;
import com.founder.utils.token.TokenUtil;
import com.google.common.cache.CacheBuilder;
import com.mryx.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private IndexSender indexSender;

    @Autowired
    private InvoiceService invoiceService;

    @PostConstruct
    @Transactional
    public void init() {
        TokenUtil.loginUsers = CacheBuilder.newBuilder().maximumSize(100000).expireAfterAccess(604800, TimeUnit.SECONDS)
                .build();
    }

    @Transactional
    @Override
    public TUserEntity saveUser(TUserEntity userEntity) {
//        return userDao.save(userEntity);
        return realSave(userEntity);
    }

    public TUserEntity realSave(TUserEntity userEntity) {
        TUserEntity userEntity1 = userDao.save(userEntity);
        if (userEntity1!=null) {
            try {
                invoiceService.getInvoicesByUserId(Long.valueOf("574"), -1, -1);
            }
            finally {
                System.out.println("异常执行之前执行~~~~");
            }

        }
        return userEntity1;
    }

    @Override
    public List<TUserEntity> listAllUsers() {
        List<TUserEntity> allUsers = userDao.findAll();
        indexSender.sendMag(allUsers);
        return allUsers;
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
            String token = UUID.randomUUID().toString();
            TokenUtil.loginUsers.put(token, user);
            map.put("token", token);
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

    @Transactional
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

    @Override
    public TUserEntity getLoginUserFromToken(String token) throws MyException {
        TUserEntity userEntity = (TUserEntity) TokenUtil.loginUsers.getIfPresent(token);
        if (userEntity == null) {
            throw new MyException("用户未登录");
        }
        userEntity.setPwd("******");
        return userEntity;
    }
}
