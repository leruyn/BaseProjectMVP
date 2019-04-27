package com.ruyn.baseproject.model;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright (C) 2019.
 * All rights reserved.
 *
 * @author ruyn.
 * @since Apr-27-2019
 */
public class SignInRequestBody {
    @SerializedName("phone")
    private String mPhone;

    @SerializedName("area_code")
    private String mAreaCode;

    @SerializedName("email")
    private String mEmail;

    public SignInRequestBody() {
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmAreaCode() {
        return mAreaCode;
    }

    public void setmAreaCode(String mAreaCode) {
        this.mAreaCode = mAreaCode;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}
