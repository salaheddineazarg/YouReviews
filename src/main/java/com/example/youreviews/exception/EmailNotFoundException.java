package com.example.youreviews.exception;

import javax.naming.AuthenticationException;

public class EmailNotFoundException extends AuthenticationException {

    public EmailNotFoundException(String msg) {
        super(msg);
    }

    public EmailNotFoundException(String msg, Throwable cause) {

        super(msg);
        initCause(cause);
    }
}
