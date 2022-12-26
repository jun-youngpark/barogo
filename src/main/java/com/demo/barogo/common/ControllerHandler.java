package com.demo.barogo.common;

import com.demo.barogo.common.Const.ResponseStatus;
import com.demo.barogo.common.exception.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ControllerHandler {

    public static <T> ResponseEntity<ApiResponse> success(T response) {
        return ResponseEntity.status( HttpStatus.OK)
                             .body(ApiResponse.builder()
                                              .success(ResponseStatus.OK)
                                              .data(response)
                                              .message(null)
                                              .build());
    }

    public static ResponseEntity<ApiResponse> error(String message, HttpStatus status) {
        return ResponseEntity.status(status)
                             .body(ApiResponse.builder()
                                              .success(ResponseStatus.FAIL)
                                              .data(null)
                                              .message(message)
                                              .build());
    }
}
