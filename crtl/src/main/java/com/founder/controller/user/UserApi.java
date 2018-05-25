package com.founder.controller.user;

import com.founder.aop.Action;
import com.founder.entity.user.TUserEntity;
import com.founder.service.IUserService;
import com.founder.utils.solr.doc.QueryDoc;
import com.founder.utils.solr.service.ISolrService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.solr.client.solrj.SolrServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

/**
 * @author zhwen
 * @version 1.0
 * @company 北大方正电子
 * @date 2017-12-08 16:27
 **/
@RestController
@RequestMapping(value = "${drap.api.base-path:/api}/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(description = "用户接口")
public class UserApi  {

    private static Logger logger = LoggerFactory.getLogger(UserApi.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private ISolrService solrService;

    @Action
    @ApiOperation(value = "查询大于一定年龄的用户", notes = "查询大于一定年龄的用户")
    @RequestMapping(value = "/getUsersByAge", method = RequestMethod.GET)
    public List<TUserEntity> getUsersByAge (@ApiParam(value = "用户年龄", required = true) @RequestParam("age") int age) {
        logger.info("已经进入查询方法");
        return userService.getUsersByAge(age);
    }

    @ApiOperation(value = "查询大于一定年龄的用户", notes = "查询大于一定年龄的用户")
    @RequestMapping(value = "/getUsersByPageable", method = RequestMethod.GET)
    public Page<TUserEntity> getUsersByPageable (@ApiParam(value = "用户姓名", required = true) @RequestParam("name") String name,
                                                 Pageable pageable) {
        logger.info("已经进入查询方法");
        return userService.findByName(name, pageable);
    }

    @ApiOperation(value = "新增用户", notes = "新增用户入库")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Map<String, Object> saveUser (TUserEntity user) throws IOException, SolrServerException {
        Map<String, Object> result = new HashMap<String, Object>();
        TUserEntity userEntity = userService.saveUser(user);
        if (userEntity != null) {
            /*Map<String, Object> solrUser = new HashMap<String, Object>(); // 以map的形式插入索引库
            solrUser.put("id", userEntity.getId());
            solrUser.put("name", userEntity.getName());
            solrUser.put("comment", userEntity.getAddress());
            String msg = solrService.addQueryDoc(solrUser);*/
            QueryDoc queryDoc = new QueryDoc();
            queryDoc.setId(String.valueOf(userEntity.getId()));
            queryDoc.setName(userEntity.getName());
            queryDoc.setComment("他是个好汉");
            Map<String, String> dynamicField = new HashMap<String, String>();
            dynamicField.put(String.valueOf(new Random().nextInt(50)), queryDoc.getName());
            queryDoc.setCATS(dynamicField);
            solrService.saveQueryDocIndex(queryDoc);
            result.put("success",1);
//            result.put("solrMsg", msg);
            return result;
        }
        return Collections.emptyMap();
    }

    @ApiOperation(value = "查询所有用户", notes = "从数据库里查询所有用户")
    @RequestMapping(value = "/listAllUsers", method = RequestMethod.GET)
    public List<TUserEntity> listAllUsers () {
        return userService.listAllUsers();
    }

    @ApiOperation(value = "用户登录", notes = "用户登录并且生成token返回(没有springsecurity)")
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String login(@RequestBody TUserEntity tUserEntity) {
        Map<String ,Object> result = userService.login(tUserEntity);
        if (result.get("success").equals(1)) {
            String jwtToken = Jwts.builder().setSubject(tUserEntity.getName()).claim("roles","member")
                    .signWith(SignatureAlgorithm.HS256,"secretKey").compact();
            return jwtToken;
        }
        return "";
    }

}
