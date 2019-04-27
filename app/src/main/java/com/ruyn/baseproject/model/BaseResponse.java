package com.ruyn.baseproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Copyright (C) 2019.
 * All rights reserved.
 *
 * @author ruyn.
 * @since Apr-27-2019
 */
public class BaseResponse<T> {
    @SerializedName("code")
    @Expose
    private Integer code;

    @SerializedName("status")
    @Expose
    private boolean status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private T data;

    /**
     * @return The code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @param code The code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * @return The status
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return The data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(T data) {
        this.data = data;
    }

}

