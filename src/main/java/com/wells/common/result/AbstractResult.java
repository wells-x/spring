package com.wells.common.result;

/**
 * @author sheng
 */
public abstract class AbstractResult {
    protected int code;
    protected String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
