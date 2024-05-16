package org.example.springbootjavajpastandardapi.common.exception;

import lombok.Getter;
import org.example.springbootjavajpastandardapi.common.error.ErrorCodeIfs;

@Getter
public class ApiResponseException extends RuntimeException implements ApiResponseExceptionIfs {

    private final ErrorCodeIfs errorCodeIfs;
    private final String errorDescription;

    public ApiResponseException(ErrorCodeIfs errorCodeIfs) {
        super(errorCodeIfs.getDescription());
        this.errorCodeIfs = errorCodeIfs;
        this.errorDescription = errorCodeIfs.getDescription();
    }

    public ApiResponseException(ErrorCodeIfs errorCodeIfs, String errorDescription) {
        super(errorCodeIfs.getDescription());
        this.errorCodeIfs = errorCodeIfs;
        this.errorDescription = errorDescription;
    }

    public ApiResponseException(ErrorCodeIfs errorCodeIfs, Throwable tx) {
        super(tx);
        this.errorCodeIfs = errorCodeIfs;
        this.errorDescription = errorCodeIfs.getDescription();
    }

    public ApiResponseException(ErrorCodeIfs errorCodeIfs, String errorDescription, Throwable tx) {
        super(tx);
        this.errorCodeIfs = errorCodeIfs;
        this.errorDescription = errorDescription;
    }

}
