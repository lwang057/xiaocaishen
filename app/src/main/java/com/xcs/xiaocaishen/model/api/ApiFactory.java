package com.xcs.xiaocaishen.model.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author lwang
 * @date 2018/8/1
 * @description api工厂类，对联网框架进行封装
 */

public class ApiFactory {

    private static AppApi appApi;
    private static OkHttpClient client;
    private static final int TIME_OUT = 10;

    public ApiFactory() {
    }

    /**
     * 实例化Retrofit，返回AppApi可直接调用api
     *
     * @return
     */
    public static AppApi getAppApi() {
        if (appApi == null) {
            synchronized (ApiFactory.class) {
                appApi = new Retrofit.Builder()
                        .baseUrl(AppApi.BASE_URL)
                        .client(getClient())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(AppApi.class);
            }
        }
        return appApi;
    }

    /**
     * 返回OkHttpClient实例
     *
     * @return
     */
    public static OkHttpClient getClient() {
        if (client == null) {
            synchronized (ApiFactory.class) {
                if (client == null) {
                    client = new OkHttpClient().newBuilder()
                            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                            .addInterceptor(new RequestInterceptor())
                            .build();
                }
            }
        }
        return client;
    }


}
