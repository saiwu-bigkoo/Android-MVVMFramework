package com.bigkoo.mvvmframework.model;

/**
 * Created by Sai on 16/6/1.
 */
public class HttpResult<T>  {

    /**
     * 默认约定返回 格式 ： {"status":0,"msg":"提示消息","content":{}}
     * status : 0
     * msg : 提示消息
     * content : {} 或 {[{},{},{}]}
     */


    private int code;

    private T content;
    private String msg;

    public void setCode(int code) {
        this.code = code;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public T getContent() {
        return content;
    }

    public String getMsg() {
        return msg;
    }
}
