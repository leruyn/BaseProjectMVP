package com.ruyn.baseproject.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ruyn.baseproject.R;
import com.ruyn.baseproject.presenter.presenters.AuthPresenter;
import com.ruyn.baseproject.presenter.services.ApiResponseCode;
import com.ruyn.baseproject.presenter.services.ApiTask;
import com.ruyn.baseproject.presenter.services.OnResponseListener;

public class MainActivity extends AppCompatActivity implements OnResponseListener {

    private AuthPresenter mAuthPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuthPresenter = new AuthPresenter(this, this);
        mAuthPresenter.login("m@gmail.com", "123456");

    }

    @Override
    public boolean onResponse(ApiTask task, int status, String messageError) {
        if (status == ApiResponseCode.SUCCESS) {

        }
        return false;
    }

    @Override
    public boolean willProcess(ApiTask task, int status) {
        return false;
    }
}
