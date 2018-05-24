package com.founder.service.impl;

import com.founder.dao.user.IUserDao;
import com.founder.entity.user.TUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author zhuhw
 * @date 2018/5/24 18:25
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TUserEntity userEntity = userDao.findByName(s);
        if (userEntity == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }

        return new User(userEntity.getName(), userEntity.getPwd(), Collections.emptyList());
    }
}

