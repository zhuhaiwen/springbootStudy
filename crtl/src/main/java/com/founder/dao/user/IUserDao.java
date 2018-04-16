package com.founder.dao.user;

import com.founder.entity.user.TUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhwen
 * @version 1.0
 * @company 北大方正电子
 * @date 2017-10-28 16:27
 **/
@Repository
public interface IUserDao extends JpaRepository<TUserEntity, Integer>,
        JpaSpecificationExecutor<TUserEntity>,
        PagingAndSortingRepository<TUserEntity, Integer>,Serializable {

        // 查询年龄大于某个年龄段的用户
        @Query(value = "select * from t_user where age > ?1", nativeQuery = true)
        List<TUserEntity> getUsersByAge (int age);

        // 自定义sql，根据用户名、密码删除一条数据
        @Modifying
        @Query(value = "delete from t_user where name = ?1 and pwd = ?2", nativeQuery = true)
        void deleteUserByNameAndPwd (String name, String pwd);

        Page<TUserEntity> findByName (String name, Pageable pageable);
}
