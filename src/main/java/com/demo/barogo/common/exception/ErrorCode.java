package com.demo.barogo.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    /** System **/
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E0001"),
    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "E0002"),

    /** Security **/
    ACCESSTOKEN_NOTEXIST_AUTHORITY_ERROR(HttpStatus.UNAUTHORIZED, "S0001", "권한 정보가 없는 토큰입니다.");

    private final HttpStatus status;
    private final String code;
    private String message;

    ErrorCode(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
