package com.founder.swagger2;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author zhwen
 * @date 2017-12-22 15:59
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建Restful APIs")
                .description("1996年黄金一代No1--Kobe Bryant")
                .termsOfServiceUrl("http://blog.csdn.net/he90227")
                .contact(new Contact("参考来自","https://www.jianshu.com/p/8033ef83a8ed","459949286@qq.com"))
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createRestApi() {
        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean test(RequestHandler requestHandler) {
                Class<?> declaringClass = requestHandler.declaringClass();
                if (declaringClass == BasicErrorController.class)// 排除
                    return false;
                return true;
            }
        };
        // swagger配置token,访问才可以请求的通(每一个方法都需要添加token参数,现已改成全局token的方式)
        ParameterBuilder token = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<>();
        token.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        parameters.add(token.build());
        //
        return new Docket(DocumentationType.SWAGGER_2)
//                .globalOperationParameters(parameters)
                .groupName("first API")
                .securitySchemes(securitySchemes())
                .apiInfo(apiInfo())
                .select()
                // TODO 这里面如果有多个路径过滤这样写就会报错，页面上是不显示的，需要换一种写法(Docket不能自动注入)
//                .paths(PathSelectors.ant("/api/**"))
//                .paths(PathSelectors.ant("/user/**"))
                .build();
    }

    // TODO 所谓的分组就是生成多个Docket, 每一个docket的配置一个apiinfo，根据paths()来区分，后续有时间改成工具类的形式
//    @Bean
//    public Docket secondRestApi(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("second API")
//                .securitySchemes(securitySchemes())
//                .apiInfo(apiInfo())
//                .select()
//                .paths(PathSelectors.ant("/secondApi/**"))
//                .paths(PathSelectors.ant("/secondUser"))
//                .build();
//    }
    private List<ApiKey> securitySchemes(){
        List<ApiKey> securitySchemes = new ArrayList<>();
        ApiKey headKey = new ApiKey("token","token","header");
        securitySchemes.add(headKey);
        return securitySchemes;
    }
}
