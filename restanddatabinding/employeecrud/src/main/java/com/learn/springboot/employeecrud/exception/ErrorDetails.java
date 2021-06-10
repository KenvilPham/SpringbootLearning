package com.learn.springboot.employeecrud.exception;
import java.util.Date;

public class ErrorDetails {
    private Date timeStamp;
    private String message;
    private String detail;

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }

    public ErrorDetails(Date timeStamp, String message, String detail) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.detail = detail;
    }
    
}
