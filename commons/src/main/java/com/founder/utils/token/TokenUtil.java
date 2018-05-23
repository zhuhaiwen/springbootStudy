package com.founder.utils.token;

import com.google.common.cache.Cache;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhuhw
 * @date 2018/5/23 10:23
 */
public class TokenUtil {

    public static final String TOKEN_KEY = "token";

    // guava cache
    public static Cache<String, Object> loginUsers;

    /**
     * 获取当前请求的 token
     * @return
     */
    public static String getToken() {
        String token = null;
        ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();

        if (StringUtils.isBlank(token)) {
            token = request.getHeader(TOKEN_KEY); // 先从header里拿
        }
        if (StringUtils.isBlank(token)) {
            token = (String) request.getAttribute(TOKEN_KEY); // 再从attribute里拿
        }
        if (StringUtils.isBlank(token)) {
            Object obj = request.getSession().getAttribute(TOKEN_KEY); // 还从session里拿

            if (obj != null) {
                token = obj.toString();
            }
        }
        if (StringUtils.isBlank(token)) {
            token = "";
        }
        return token;
    }
}
