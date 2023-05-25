package com.planmate.server.exception.post;

import com.planmate.server.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ScrapNotFoundException extends RuntimeException {
    private String message;
    private ErrorCode code;

    public ScrapNotFoundException(Long id) {
        super(id.toString());
        this.message = id.toString();
    }
}
