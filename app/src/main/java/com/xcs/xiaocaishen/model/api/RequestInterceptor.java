package com.xcs.xiaocaishen.model.api;

import com.xcs.xiaocaishen.config.Const;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author lwang
 * @date 2018/8/1
 * @description 网络加载拦截器，在这里进行请求和响应的统一处理
 */

public class RequestInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        // 这个chain里面包含了request和response，所以要什么都可以从这里拿
        Request request1 = chain.request();

        // 给每个请求添加请求头
        Request.Builder builder = request1.newBuilder()
                .addHeader("token", Const.TOKEN);

        Request request = builder.build();
        return chain.proceed(request);
    }

}
