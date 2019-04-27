package com.ruyn.baseproject;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;

import com.ruyn.baseproject.common.Constant;
import com.ruyn.baseproject.presenter.services.ApiService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Copyright (C) 2019.
 * All rights reserved.
 *
 * @author ruyn.
 * @since Apr-27-2019
 */
public class BaseApplication extends MultiDexApplication {



    public final static int CONNECT_TIMEOUT = 60;
    public final static int WRITE_TIMEOUT = 60;
    public final static int READ_TIMEOUT = 60;


    /**
     * Singleton Instance
     */
    private static BaseApplication mInstance;
    /**
     * API Service Instance
     */
    private ApiService mService;

    /**
     * Default Constructor
     */
    public BaseApplication() {
        super();

        mInstance = this;
    }

    private static OkHttpClient setClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request request = original.newBuilder()
                                .addHeader("Content-Type", "application/json")
                                .addHeader("Accept-Language", "US")
                                .method(original.method(), original.body()).build();
                        return chain.proceed(request);
                    }
                });
        if (!BuildConfig.BUILD_TYPE.equalsIgnoreCase(Constant.RELEASE)) {
            okHttpClient.addInterceptor(interceptor);
        }
        return okHttpClient.build();

    }


    /**
     * Get Singleton Instance
     *
     * @return BaseApplication
     */
    public static BaseApplication getInstance() {
        if (mInstance == null) {
            mInstance = new BaseApplication();
        }
        return mInstance;
    }

    /**
     * Get API Service
     *
     * @return ApiService
     */
    public ApiService getService() {
        return mService;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        //sAnalytics = GoogleAnalytics.getInstance(this);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        //creat retrofit
        // Create Retrofit Builder
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(BuildConfig.BASE_URL);
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addConverterFactory(ScalarsConverterFactory.create());
        builder.client(setClient());
        // Set Log Enable for Retrofit

        // Create Retrofit
        Retrofit retrofit = builder.build();
        mService = retrofit.create(ApiService.class);

    }




}
