package com.algo.c3g2.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class Swagger2Configuration {
    //版本
    public static final String VERSION = "1.0.0";

    /**
     * 门户api，接口前缀：portal
     *
     * @return
     */
    @Bean
    public Docket portalApi(Environment env) {
        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dev", "test");
        boolean b = env.acceptsProfiles(of);
        return new Docket(DocumentationType.SWAGGER_12).enable(b)
                .apiInfo(portalApiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage("net.sjw.blog.controller.portal"))
                .apis(RequestHandlerSelectors.basePackage("com.algo.c3g2.controller"))
                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build()
                .groupName("test测试group")
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo portalApiInfo() {
        return new ApiInfoBuilder()
                .title("test1portalApiInfo接口文档") //设置文档的标题
                .description("test接口文档") // 设置文档的描述
                .version(VERSION) // 设置文档的版本信息-> 1.0.0 Version information
                .build();
    }

    /**
     * 认证的安全上下文
     */
    private List<SecurityScheme> securitySchemes() {
        List<SecurityScheme> securitySchemes = new ArrayList<>();
        securitySchemes.add(new ApiKey("Authorization", "token", "header"));
        return securitySchemes;
    }

    /**
     * 授权信息全局应用
     */
    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any()).build());
        return securityContexts;
    }
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }

}