package com.founder.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.founder.dao.log.TLogDao;
import com.founder.entity.log.TLoggerInfosEntity;
import com.founder.utils.DaoHelper;
import com.founder.utils.IpHelper;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhwen
 * @version 1.0
 * @company 北大方正电子
 * @date 2017-11-18 17:43
 **/
@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter {

    // 请求开始时间标识
    private static final String LOGGER_SEND_TIME = "SEND_TIME";

    // 请求日志实体标识
    private static final String LOGGER_ENTITY = "LOGGER_ENTITY";

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加登陆拦截
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
                // 登录不做拦截
                if (httpServletRequest.getRequestURI().equals("/user/login_view") ||
                        httpServletRequest.getRequestURI().equals("/user/login")) {
                    return true;
                }
                // 验证session是否存在
                Object obj = httpServletRequest.getSession().getAttribute("userInfo");
                if (obj == null) {
                    httpServletResponse.sendRedirect("/user/login_view");
                    return false;
                }
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

            }

            @Override
            public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

            }
        }).addPathPatterns("/**");

        /**
         * 记录请求日志
         */
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
                // 生成日志实体
                TLoggerInfosEntity loggerInfosEntity = new TLoggerInfosEntity();
                // 获取请求sessionID
                String sessionID = httpServletRequest.getRequestedSessionId();
                // 请求路径
                String requestUrl = httpServletRequest.getRequestURI();
                // 请求参数信息
                String paramData = JSON.toJSONString(httpServletRequest.getParameterMap(),
                        SerializerFeature.DisableCircularReferenceDetect,
                        SerializerFeature.WriteMapNullValue);

                // 设置访问客户端IP
                loggerInfosEntity.setClientIp(IpHelper.getIp(httpServletRequest));

                // 设置方法
                loggerInfosEntity.setMethod(httpServletRequest.getMethod());

                // 设置请求类型
                loggerInfosEntity.setType(httpServletRequest.getMethod());

                // 设置请求参数json串
                loggerInfosEntity.setParamData(paramData);

                // 设置请求地址
                loggerInfosEntity.setUri(requestUrl);

                // 设置sessionID
                loggerInfosEntity.setSessionId(sessionID);

                // 设置请求开始时间
                httpServletRequest.setAttribute(LOGGER_SEND_TIME, System.currentTimeMillis());

                // 将请求实体放入request
                httpServletRequest.setAttribute(LOGGER_ENTITY, loggerInfosEntity);

                return true;
            }

            @Override
            public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

            }

            @Override
            public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
                // 获取请求响应码
                int responseStatus = httpServletResponse.getStatus();
                long currentTime = System.currentTimeMillis();
                long startTime = Long.valueOf(httpServletRequest.getAttribute(LOGGER_SEND_TIME).toString());
                long consumeTime = currentTime - startTime;
                TLoggerInfosEntity logger = (TLoggerInfosEntity)httpServletRequest.getAttribute(LOGGER_ENTITY);
                logger.setTimeConsuming(Integer.valueOf(Long.valueOf(consumeTime).toString()));
                logger.setReturnTime(currentTime + "");
                logger.setHttpStatusCode(responseStatus + "");
                TLogDao logDao = DaoHelper.getDao(TLogDao.class, httpServletRequest);
                logDao.save(logger);
            }
        }).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/moreModule/**").addResourceLocations("classpath:/static/");
    }
}
