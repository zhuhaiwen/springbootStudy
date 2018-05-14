package com.founder.utils.globalexception;

/**
 * 统一异常信息
 *
 * @author zhuhw
 * @date 2018/5/11 16:40
 */
public class ErrorInfo<T> {

    public static final Integer ok = 0;
    public static final Integer error = 100;

    private Integer code;
    private String message;
    private String url;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
