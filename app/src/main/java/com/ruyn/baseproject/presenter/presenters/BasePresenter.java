package com.ruyn.baseproject.presenter.presenters;

import android.content.Context;

import com.ruyn.baseproject.BaseApplication;
import com.ruyn.baseproject.model.BaseResponse;
import com.ruyn.baseproject.model.SignInRequestBody;
import com.ruyn.baseproject.presenter.services.ApiResponseCallback;
import com.ruyn.baseproject.presenter.services.ApiResponseCode;
import com.ruyn.baseproject.presenter.services.ApiService;
import com.ruyn.baseproject.presenter.services.ApiTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Copyright (C) 2019.
 * All rights reserved.
 *
 * @author ruyn.
 * @since Apr-27-2019
 */
public abstract class BasePresenter implements ApiResponseCallback {
    /**
     * The Context
     */
    final Context mContext;
    /**
     * z
     * The Api Service
     */
    final ApiService mService;

    public BasePresenter(Context context) {
        mContext = context;
        mService = BaseApplication.getInstance().getService();
    }

    /**
     * Process Response
     *
     * @param task ApiTask
     * @return True if Task is finished and do next task
     */
    @Override
    public final boolean onResponse(ApiTask task) {
        int status = ApiResponseCode.CANNOT_CONNECT_TO_SERVER;
        String messageError = "";
        Response response = task.getResponse();

        if (response != null) {
            switch (response.raw().code()) {
                case ApiResponseCode.HTTP_CODE_SUCCESS:
                    status = ((BaseResponse) response.body()).getCode();
                    messageError = ((BaseResponse) response.body()).getMessage();
                    break;
                default:
                    try {
                        String errorObject = response.errorBody().string().toString();
                        JSONObject jsonObject = new JSONObject(errorObject);
                        status = jsonObject.getInt("code");
                        messageError = jsonObject.getString("message");
                        JSONObject dataJson = new JSONObject(jsonObject.getJSONObject("data").toString());

                        if (dataJson.length() != 0) {
                            Iterator<String> keys = dataJson.keys();
                            if (keys.hasNext()) {
                                String key = (String) keys.next();
                                JSONArray jsonArray = new JSONArray(dataJson.getString(key).toString());// First key in your json object
                                messageError = jsonArray.get(0).toString();
                            }
                        } else {
                            messageError = jsonObject.getString("message");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    switch (response.raw().code()) {
                        case ApiResponseCode.BAD_REQUEST:
                            if (messageError.isEmpty())
                                messageError = response.raw().message();
                            break;
                        case ApiResponseCode.UN_AUTHORIZED: {
                            break;
                        }
                        default:
                            if (messageError.isEmpty())
                                messageError = response.raw().message();
                            break;
                    }
                    break;
            }

        } else {
            status = 500;
            if (mContext != null) {

            }
        }

        return onPostResponse(task, status, messageError);
    }

    /**
     * Process Response
     *
     * @param task   ApiTask
     * @param status int
     * @return True if Task is finished and do next task
     */
    public abstract boolean onPostResponse(ApiTask task, int status, String messageError);

    protected Call createLoginRequest(String email, String pass) {
        SignInRequestBody signInData = new SignInRequestBody();
        signInData.setmPhone(email);
        signInData.setmAreaCode(pass);

        return mService.login("",signInData);
    }

}
