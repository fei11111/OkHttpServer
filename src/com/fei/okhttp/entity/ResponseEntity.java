package com.fei.okhttp.entity;

public class ResponseEntity<T> {

    public String code = "0011";
    public String msg = "服务器发生异常";
    public T data = null;

}
