package com.enigma.reimbursment.online.models.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ResponseMessage <T>{

    private int code;

    private String message;

    private T data;

    private LocalDateTime timestap;

    public ResponseMessage(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTimestap() {
        return timestap;
    }

    public void setTimestap(LocalDateTime timestap) {
        this.timestap = timestap;
    }

    public static <T> ResponseMessage<T> success(T data) {
        return new ResponseMessage<>(HttpStatus.OK.value(), null, data);
    }

    public static <T> ResponseMessage<T> error (HttpStatus status) {
        return error(status.value(),status.getReasonPhrase());
    }

    public static <T> ResponseMessage<T> error (int code,String message) {
        return error(code, message);
    }

    public static <T> ResponseMessage<T> error (int code, String message,T data) {
        return new ResponseMessage<>(code, message, data);
    }
}
