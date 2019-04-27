package com.ruyn.baseproject.model;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright (C) 2019.
 * All rights reserved.
 *
 * @author ruyn.
 * @since Apr-27-2019
 */
public class SignInData {

    @SerializedName("access_token")
    private String mAccessToken;

    @SerializedName("refresh_token")
    private String mRefreshToken;

    @SerializedName("verify_token")
    private String mVerifyToken;

    @SerializedName("verified")
    private int mVerified;


    public String getAccessToken() {
        return mAccessToken;
    }

    public void setAccessToken(String accessToken) {
        mAccessToken = accessToken;
    }

    public String getRefreshToken() {
        return mRefreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        mRefreshToken = refreshToken;
    }

    public String getVerifyToken() {
        return mVerifyToken;
    }

    public void setVerifyToken(String verifyToken) {
        mVerifyToken = verifyToken;
    }

    public int getVerified() {
        return mVerified;
    }

    public void setVerified(int verified) {
        mVerified = verified;
    }

    @Override
    public String toString() {
        return "SignInData{" +
                "mAccessToken='" + mAccessToken + '\'' +
                ", mRefreshToken='" + mRefreshToken + '\'' +
                ", mVerifyToken=" + mVerifyToken +
                ", mVerified=" + mVerified+
                '}';
    }
}

