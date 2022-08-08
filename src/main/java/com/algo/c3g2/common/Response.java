package com.algo.c3g2.common;


import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
@Data
public class Response {
    private Response(){}
    private String code;
    private String msg;
    private Map<String, Object> data = new HashMap<>();
    public static Response SUCCESS() {
        Response response = new Response();
        response.setCode("200");
        response.setMsg("请求成功！");
        return response;
    }
    public static Response FAIL() {
        Response response = new Response();
        response.setCode("400");
        response.setMsg("请求失败！");
        return response;
    }

    public static Response FAIL(String code, String msg) {
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }


    public static Response FAIL(String msg) {
        Response response = new Response();
        response.setCode("400");
        response.setMsg(msg);
        return response;
    }
    public static Response SUCCESS(String msg) {
        Response response = new Response();
        response.setCode("200");
        response.setMsg(msg);
        return response;
    }
    public  Response data(String msg,Object data) {
        this.data.put(msg, data);
        return this;
    }

    public static Response SUCCESS(String code,String msg) {
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}
