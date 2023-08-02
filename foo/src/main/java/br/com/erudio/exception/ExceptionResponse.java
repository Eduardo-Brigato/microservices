package br.com.erudio.exception;

import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
public class ExceptionResponse implements Serializable {
    private static final Long serialVersionUID = 1L;

    private final Date timeStamp;
    private final String message;
    private final String detalis;

    public ExceptionResponse(Date timeStamp, String message, String detalis) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.detalis = detalis;
    }
}
