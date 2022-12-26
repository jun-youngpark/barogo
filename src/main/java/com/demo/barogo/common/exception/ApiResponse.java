package com.demo.barogo.common.exception;

import com.demo.barogo.common.Const.ResponseStatus;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
public class ApiResponse<T> {
    private final ResponseStatus success;
    private final T data;
    private final String errorMsg;

    public ResponseStatus isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("success", success)
                .append("data", data)
                .append("message", errorMsg)
                .toString();
    }

    @Builder
    public ApiResponse(ResponseStatus success, T data, String message) {
        this.success = success;
        this.data = data;
        this.errorMsg = message;
    }
}
