package com.demo.barogo.config.auth;

public class TokenConstants {

    /** Spring Security Constants **/
    public static final String AUTHORIZATION_HEADER = "X-Auth-Token";
    public final static String AUTHORITIES_KEY = "auth";
    public final static String BEARER_PREFIX = "Bearer";
    public final static String BEARER_TYPE = "bearer";
    public final static long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 30;
    public final static long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 7;
}
