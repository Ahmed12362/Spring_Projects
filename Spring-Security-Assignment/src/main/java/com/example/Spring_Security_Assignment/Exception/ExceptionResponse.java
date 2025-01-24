package com.example.Spring_Security_Assignment.Exception;

import jakarta.persistence.Column;

public class ExceptionResponse {
    private int status;
    private long time_stamp;
    private String message;

    public ExceptionResponse(int status, long time_stamp, String message) {
        this.status = status;
        this.time_stamp = time_stamp;
        this.message = message;
    }
    public ExceptionResponse(){}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(long time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
