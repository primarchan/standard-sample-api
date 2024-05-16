package org.example.springbootjavajpastandardapi.common.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.example.springbootjavajpastandardapi.common.api.ApiResponse;
import org.example.springbootjavajpastandardapi.common.error.ErrorCodeIfs;
import org.example.springbootjavajpastandardapi.common.exception.ApiResponseException;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Order(Integer.MIN_VALUE)  /* 최우선 에러 처리 */
@RestControllerAdvice
public class ApiResponseExceptionHandler {

    @ExceptionHandler(ApiResponseException.class)
    public ResponseEntity<ApiResponse<Object>> exceptionHandler(ApiResponseException exception) {
        log.error("", exception);

        ErrorCodeIfs errorCode = exception.getErrorCodeIfs();

        return ResponseEntity
                .status(errorCode.getHttpStatusCode())
                .body(ApiResponse.ERROR(errorCode, exception.getErrorDescription()));
    }

}
