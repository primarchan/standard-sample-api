package org.example.springbootjavajpastandardapi.common.api;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springbootjavajpastandardapi.common.error.ErrorCodeIfs;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private Result result;

    @Valid
    private T body;

    public static <T> ApiResponse<T> OK(T data) {
        return ApiResponse.<T>builder()
                .result(Result.OK())
                .body(data)
                .build();
    }

    public static ApiResponse<Object> ERROR(Result result) {
        return ApiResponse.<Object>builder()
                .result(result)
                .build();
    }

    public static ApiResponse<Object> ERROR(ErrorCodeIfs errorCodeIfs) {
        return ApiResponse.<Object>builder()
                .result(Result.ERROR(errorCodeIfs))
                .build();
    }

    public static ApiResponse<Object> ERROR(ErrorCodeIfs errorCodeIfs, Throwable tx) {
        return ApiResponse.<Object>builder()
                .result(Result.ERROR(errorCodeIfs, tx))
                .build();
    }

    public static ApiResponse<Object> ERROR(ErrorCodeIfs errorCodeIfs, String description) {
        return ApiResponse.<Object>builder()
                .result(Result.ERROR(errorCodeIfs, description))
                .build();
    }

}
