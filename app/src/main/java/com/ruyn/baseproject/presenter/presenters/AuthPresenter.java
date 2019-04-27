package com.ruyn.baseproject.presenter.presenters;

import android.content.Context;

import com.ruyn.baseproject.presenter.services.ApiTask;
import com.ruyn.baseproject.presenter.services.ApiTaskType;
import com.ruyn.baseproject.presenter.services.OnResponseListener;

/**
 * Copyright (C) 2019.
 * All rights reserved.
 *
 * @author ruyn.
 * @since Apr-27-2019
 */
public class AuthPresenter extends BasePresenter {

    private OnResponseListener mListener;

    /**
     * Default Constructor
     *
     * @param context Context
     */
    public AuthPresenter(Context context, OnResponseListener mListener) {
        super(context);
        this.mListener = mListener;
    }

    public void login(final String email, final String password) {
        ApiTask.execute(() -> createLoginRequest(email, password), ApiTaskType.LOGIN, this);
    }

    @Override
    public boolean onPostResponse(ApiTask task, int status, String messageError) {
        return mListener.onResponse(task, status, messageError);
    }
}
