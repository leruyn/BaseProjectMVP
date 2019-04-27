package com.ruyn.baseproject.model;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright (C) 2019.
 * All rights reserved.
 *
 * @author ruyn.
 * @since Apr-27-2019
 */
public class ResponseBase<T> extends Response {
    @SerializedName("data")
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseBase{" +
                "data=" + data +
                '}';
    }
}