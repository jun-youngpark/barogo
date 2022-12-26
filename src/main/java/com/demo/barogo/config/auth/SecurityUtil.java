package com.demo.barogo.config.auth;

import com.demo.barogo.common.exception.ApiException;
import com.demo.barogo.common.exception.ErrorCode;
import com.demo.barogo.jpa.entity.Users;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SecurityUtil {

    public static boolean isAuthentication() {
        return SecurityUtil.getAuthentication() != null;
    }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static String getCurrentUserid() {
        Authentication authentication = getAuthentication();
        if (authentication == null || authentication.getName() == null) {
            throw new ApiException(ErrorCode.ACCESSTOKEN_NOTEXIST_AUTHORITY_ERROR);
        }
        return ((User) authentication.getPrincipal()).getUsername();
    }

}
