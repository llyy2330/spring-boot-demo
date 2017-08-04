package com.ncf.emc.web.conf;


import com.ncf.emc.common.result.ReturnCodeEnum;

public class BaseResult {
    private Integer code = ReturnCodeEnum.RESTFUL_SUCCESS.value();
    private String msg = ReturnCodeEnum.RESTFUL_SUCCESS.getDesc();

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
