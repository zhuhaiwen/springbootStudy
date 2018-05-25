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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhwen
 * @version 1.0
 * @company 北大方正电子
 * @date 2017-10-28 16:31
 **/
@Controller
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(description = "用户登录操作")
public class UserCtrl {

    private final static Logger logger = LoggerFactory.getLogger(UserCtrl.class);

    @Autowired
    private IUserService userService;

    /*@ApiOperation(value = "用户登陆", notes = "用户登录系统")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String userLogin (TUserEntity userEntity, HttpServletRequest request) throws IOException {
        // 根据用户名查询用户是否存在
        Map<String ,Object> result = userService.login(userEntity);
        if (result.get("success").equals(1)) {
            request.getSession().setAttribute(TokenUtil.TOKEN_KEY, result.get(TokenUtil.TOKEN_KEY)); // 把token值放在session中,在校验的地方再拿出来,实际上还是用session放对象
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
    }*/

    @ApiOperation(value = "用户登陆", notes = "用户登录系统并生成token")
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public void login (@RequestBody TUserEntity userEntity, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/login?username=" + userEntity.getName() + "&password=" + userEntity.getPwd()).forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
