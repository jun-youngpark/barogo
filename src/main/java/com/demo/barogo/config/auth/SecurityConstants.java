package com.demo.barogo.config.auth;

public class SecurityConstants {

    public static final String[] SECURITY_IGNORE_URL = {
            "/"
            , "/h2-console/**"
            , "/actuator/refresh"
            , "/v1/api/user/**"
            , "/auth/**"
            , "/resource/**"
            , "/v2/api-docs"
            , "/webjars/**"
            , "/swagger/**"
            , "/swagger-resources/**"
            , "/swagger-ui.html"
            , "/swagger-ui/**"
            , "/favicon.ico"};
}
