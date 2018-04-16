package com.founder.service;

import com.founder.entity.user.TUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author zhwen
 * @version 1.0
 * @company 北大方正电子
 * @date 2017-10-28 16:26
 **/
public interface IUserService {

    /**
     * 保存用户
     * @param userEntity
     * @return
     */
    public TUserEntity saveUser (TUserEntity userEntity);

    public List<TUserEntity> listAllUsers ();

//    public TUserEntity findOne ();

    /**
     * 使用CriteriaQuery (JPA 2.0)
     * @return
     */
    /*public TUserEntity findOne();*/

    public Map<String, Object> login(TUserEntity userEntity);

    /**
     * 查询年龄大于某个年龄段的用户
     *
     * @param age
     * @return
     */
    public List<TUserEntity> getUsersByAge (int age);

    /**
     * 自定义sql，根据用户名、密码删除一条数据
     *
     * @param name
     * @param pwd
     */
    void deleteUserByNameAndPwd (String name, String pwd);

    Page<TUserEntity> findByName (String name, Pageable pageable);

    /**
     * 清空所有跟用户操作有关的缓存
     *
     * @param param
     */
    public void clearCache (String param);

}
