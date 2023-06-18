package com.example.Web.contans;

public enum ReponsitoryCode {
    SUCCESS(200,"OK"),
    NOT_FOUND(404,"NOT FOUND"),
    NO_PARAM(6001,"NO PARAM"),
    NO_CONTENT(2004,"NO CONTANT"),
    INTERNAL_SERVER_ERROR(5000,"Intenal sever error");
    private int code;
    private String message;
    public int getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }

    private ReponsitoryCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


}
