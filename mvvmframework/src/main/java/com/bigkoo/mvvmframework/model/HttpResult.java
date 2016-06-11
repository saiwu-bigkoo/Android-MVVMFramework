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


    private int status;

    private T content;
    private String msg;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public T getContent() {
        return content;
    }

    public String getMsg() {
        return msg;
    }
}
