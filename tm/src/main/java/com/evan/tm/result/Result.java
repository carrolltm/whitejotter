package com.evan.tm.result;

public class Result {

    // 响应码
    // 这里的code应该是固定的，最好采用枚举形式
    private int code;
    public Result(int code){
        this.code=code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
