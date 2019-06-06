package com.tdeado.utils.bean;

import org.apache.commons.lang.StringUtils;

import java.util.List;

public class Result {
    private int code;
    private String msg;
    private Object data;
    private List state;
    public static Result ok(Object object){
        Result ret=new Result();
        ret.setCode(0);
        ret.setMsg("success");
        ret.setData(object);
        return ret;
    }
    public static Result ok(Object object,List map){
        Result ret=new Result();
        ret.setCode(0);
        ret.setMsg("success");
        ret.setData(object);
        ret.setState(map);
        return ret;
    }
    public static Result err(String msg){
        Result ret=new Result();
        ret.setCode(500);
        ret.setMsg(msg);
        ret.setData(null);
        return ret;
    }
    public static Result err(String msg, int code){
        Result ret=new Result();
        ret.setCode(code);
        ret.setMsg(msg);
        ret.setData(null);
        return ret;
    }
    public int getCode() {
        return code;
    }

    public List getState() {
        return state;
    }

    public void setState(List state) {
        this.state = state;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        if (StringUtils.isBlank(msg)){
            this.msg = "error";
        }else {
            this.msg = msg;
        }
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
