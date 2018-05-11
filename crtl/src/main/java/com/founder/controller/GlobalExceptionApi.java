package com.founder.controller;

import com.founder.utils.globalexception.MyException;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常类测试接口
 *
 * @author zhuhw
 * @date 2018/5/11 16:56
 */
@RestController
@RequestMapping(value = "${drap.api.base-path:/api}/exception", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(description = "异常接口")
public class GlobalExceptionApi {

    @RequestMapping(value = "/getDiyException", method = RequestMethod.GET)
    public String getDiyException() throws MyException {
        throw new MyException("发生异常");
    }
}
