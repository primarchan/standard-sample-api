package org.example.springbootjavajpastandardapi.common.exception;

import org.example.springbootjavajpastandardapi.common.error.ErrorCodeIfs;

public interface ApiResponseExceptionIfs {

    ErrorCodeIfs getErrorCodeIfs();

    String getErrorDescription();

}
