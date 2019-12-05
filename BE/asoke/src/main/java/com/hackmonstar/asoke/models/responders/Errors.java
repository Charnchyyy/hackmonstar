package com.hackmonstar.asoke.models.responders;

public class Errors {
    private String code;
    private String message;

    public Errors(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
