package com.planmate.server.exception.post;

import com.planmate.server.exception.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class PostNotFoundException extends RuntimeException {
    private String message;
    private ErrorCode code;

    public PostNotFoundException(Long id) {
        super(id.toString());
        this.message = id.toString();
    }
}
