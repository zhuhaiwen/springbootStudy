package com.founder.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author zhuhw
 * @date 2018/5/24 15:15
 */
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * 接收并解析用户登录信息 /login,
     * 如果验证成功则返回一个已填充的身份验证令牌,表示成功的身份验证
     * 返回null，表明身份验证过程仍在进行中。在返回之前，实现应该执行完成该过程所需的任何额外工作。
     * 如果身份验证过程失败，就抛出一个AuthenticationException
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try{
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            username = username == null? "" : username;
            password = password == null? "" : password;
            username = username.trim();

            return new UsernamePasswordAuthenticationToken(username,
                    password,
                    new ArrayList<>()); // 封装成UsernamePasswordAuthenticationToken,登录时传过来什么样,就是什么样
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 登录成功之后会返回token给客户端
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token = Jwts.builder()
                            .setSubject(authResult.getName())
                            .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 2 * 1000))
                            .signWith(SignatureAlgorithm.HS512,"zhuhaiwen")
                            .compact();
        response.addHeader("token", "Bearer " + token);
    }
}
