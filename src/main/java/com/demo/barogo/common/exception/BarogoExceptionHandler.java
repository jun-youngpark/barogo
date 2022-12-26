package com.demo.barogo.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.demo.barogo.common.ControllerHandler.error;


@Slf4j
@ControllerAdvice
@ResponseBody
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BarogoExceptionHandler {

    @ExceptionHandler({
            IllegalArgumentException.class,
            IllegalStateException.class,
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<?> handleBadRequestException(Exception e) {
        log.error("Bad request exception occurred: {}", e.getMessage(), e);
        if (e instanceof MethodArgumentNotValidException) {
            return error(
                    ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().get(0).getDefaultMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
        return error(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({
            ApiException.class,
            NumberFormatException.class
    })
    public ResponseEntity<?> ApiException(ApiException e) {
        log.error(e.getMessage(), e);
        return error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler({
            BadCredentialsException.class,
            DisabledException.class,
            LockedException.class,
            AccountExpiredException.class,
            UsernameNotFoundException.class,
            AuthenticationException.class
    })
    public ResponseEntity<?> AuthenticationFailureHandler(Exception e) {
        String msg="";
        if(e instanceof BadCredentialsException) {
            msg = "아이디 또는 비밀번호가 일치하지 않습니다.";
        }else if(e instanceof DisabledException) {
            msg = "현재 사용할 수 없는 계정입니다.";
        }
        else if(e instanceof LockedException) {
            msg = "현재 잠긴 계정입니다.";
        }
        else if(e instanceof AccountExpiredException) {
            msg = "이미 만료된 계정입니다.";
        }else{
            msg =e.getMessage();
        }
        log.error(msg, e);
        return error(msg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
