package com.ruyn.baseproject.presenter.services;

import android.support.annotation.NonNull;

import com.ruyn.baseproject.model.ResponseBase;
import com.ruyn.baseproject.model.SignInData;
import com.ruyn.baseproject.model.SignInRequestBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Copyright (C) 2019 EdgeWorks Software.
 * All rights reserved.
 *
 * @author ruyn.
 * @since Apr-27-2019
 */
public interface ApiService {
    @POST("/api2/signin")
    Call<ResponseBase<SignInData>> login(@Header("Version") String version,
                                         @NonNull @Body SignInRequestBody body);

}
