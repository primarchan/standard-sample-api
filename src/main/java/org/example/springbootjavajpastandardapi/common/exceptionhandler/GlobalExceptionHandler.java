package org.example.springbootjavajpastandardapi.common.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.example.springbootjavajpastandardapi.common.api.ApiResponse;
import org.example.springbootjavajpastandardapi.common.error.ErrorCode;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Order(value = Integer.MAX_VALUE) /* 가장 마지막 에러 처리 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> exceptionHandler(Exception exception) {
        log.error("", exception);

        return ResponseEntity
                .status(500)
                .body(ApiResponse.ERROR(ErrorCode.SERVER_ERROR));
    }

}
