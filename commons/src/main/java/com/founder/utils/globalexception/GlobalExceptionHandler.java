package com.founder.utils.globalexception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理类
 *
 * @author zhuhw
 * @date 2018/5/11 16:13
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> errorHandler (HttpServletRequest request, HttpServletResponse response, MyException e) throws Exception {
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setMessage(e.getMessage());
        // TODO: 2018/5/14 此处还可以根据status的值来自定义异常返回信息，比如在当前errorinfo的基础上再添加别的信息
        errorInfo.setCode(response.getStatus());
        errorInfo.setData("somedata");
        errorInfo.setUrl(request.getRequestURL().toString());
        return errorInfo;
    }
}
