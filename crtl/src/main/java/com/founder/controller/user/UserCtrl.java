package com.founder.controller.user;

import com.founder.entity.user.TUserEntity;
import com.founder.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author zhwen
 * @version 1.0
 * @company 北大方正电子
 * @date 2017-10-28 16:31
 **/
@Controller
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(description = "用户操作")
public class UserCtrl {

    private final static Logger logger = LoggerFactory.getLogger(UserCtrl.class);

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "查询所有用户", notes = "从数据库里查询所有用户")
    @RequestMapping(value = "/listAllUsers", method = RequestMethod.GET)
    public List<TUserEntity> listAllUsers () {
        return userService.listAllUsers();
    }

    @ApiOperation(value = "用户登陆", notes = "用户登录系统")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String userLogin (TUserEntity userEntity, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 根据用户名查询用户是否存在
        Map<String ,Object> result = userService.login(userEntity);
        if (result.get("success").equals(1)) {
            request.getSession().setAttribute("userInfo", result.get("user"));
            return "index";
        }
        return "login";
    }

    @ApiOperation(value = "用户登陆", notes = "用户登录系统")
    @RequestMapping(value = "/login_view", method = RequestMethod.GET)
    public String loginView () {
        logger.info("已经进入登陆方法");
        return "login";
    }

    @ApiOperation(value = "用户登陆", notes = "用户登录系统")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String loginSuccess (TUserEntity userEntity, HttpServletRequest request) {
        return "success";
    }
}
