package com.demo_230712.bean;

/**
 * 新增修改等统一的DTO
 * Created by chang_kaidi on 2019/9/4 0004.
 */
public class Result<T> {
    private boolean success = true;
    private Integer code = 0;
    private String msg;
    private T data;

    public boolean isSuccess() {
        return this.code == 0;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
        if(code != 0){
            success = false;
        }
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public Result() {
        super();
    }
    public Result(boolean success) {
        this.success = success;
        if(success){
            code = 0;
        }
    }
    public Result(int code) {
        super();
        success = false;
        this.code = code;
    }
    public Result(String msg) {
        success = false;
        this.msg = msg;
    }
    public Result(boolean success, String msg) {
        super();
        this.success = success;
        this.msg = msg;
    }
    public Result(int code, String msg) {
        super();
        success = false;
        this.code = code;
        this.msg = msg;
    }

    /*设置返回为成功*/
    public static Result ok() {
        return new Result();
    }
    /*设置返回为成功,同时设置返回数据*/
    public Result<T> ok(T data) {
        Result<T> result = new Result<T>();
        result.setData(data);
        return result;
    }
    /*设置返回为失败,默认未知异常*/
    public static Result error() {
        return error(500, "未知异常，请联系管理员!");
    }
    /*设置返回为失败,同时设置异常信息*/
    public static Result error(String msg) {
        return error(500, msg);
    }
    /*设置返回为失败,同时设置code,msg*/
    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    public static Result<Object> error(Integer code, String msg, Object data) {
        Result<Object> result = new Result<Object>();
        result.setData(data);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    public static Result success(Object data) {
        Result<Object> result = new Result<Object>();
        result.setData(data);
        return result;
    }
    public static Result success(String msg) {
        Result result = new Result();
        result.setMsg(msg);
        return result;
    }

}