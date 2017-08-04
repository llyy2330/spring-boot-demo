package com.ncf.emc.common.result;


public class Result<T> extends BaseResult {

    private T data;


    public Result() {
        this(null);
    }

    public Result(T data) {
        if (data != null) {
            this.data = data;
        }
    }

//    //@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
