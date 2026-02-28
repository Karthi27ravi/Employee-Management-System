package org.example.ems_new.Exception;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ErrorCode {

    private LocalDateTime localTime;
    private String error;
    private String message;
    private int status;
    private String path;

    public ErrorCode(LocalDateTime localTime, String error, String message, int status, String path){
        this.localTime = localTime;
        this.error = error;
        this.message = message;
        this.status = status;
        this.path = path;
    }
}
