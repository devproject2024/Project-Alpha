package com.paytm.network.retrofit;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

final class ErrorAPI$Companion$create$1 implements Interceptor {
    public static final ErrorAPI$Companion$create$1 INSTANCE = new ErrorAPI$Companion$create$1();

    ErrorAPI$Companion$create$1() {
    }

    public final Response intercept(Interceptor.Chain chain) {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        newBuilder.header("Accept", "application/json").method(request.method(), request.body());
        return chain.proceed(newBuilder.build());
    }
}
