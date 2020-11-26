package com.gyc.springbootstudy.exception;

/**
 * Created by GYC
 * 2020/11/26 10:58
 */
public class FileException extends RuntimeException {

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}