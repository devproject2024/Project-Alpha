package com.paytm.pai.network;

import kotlin.g.b.k;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f43385a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final long f43386b = 3;

    /* renamed from: c  reason: collision with root package name */
    private static OkHttpClient f43387c;

    /* renamed from: d  reason: collision with root package name */
    private static OkHttpClient f43388d;

    private c() {
    }

    public static OkHttpClient a(boolean z, boolean z2) {
        OkHttpClient okHttpClient;
        OkHttpClient okHttpClient2;
        if (z && (okHttpClient2 = f43388d) != null) {
            if (okHttpClient2 == null) {
                k.a();
            }
            return okHttpClient2;
        } else if (z || (okHttpClient = f43387c) == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            if (z2) {
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            } else {
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
            }
            OkHttpClient.Builder addInterceptor = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);
            OkHttpClient build = addInterceptor.build();
            if (z) {
                addInterceptor.addInterceptor(new a());
                f43388d = build;
            } else {
                f43387c = build;
            }
            k.a((Object) build, "client");
            return build;
        } else {
            if (okHttpClient == null) {
                k.a();
            }
            return okHttpClient;
        }
    }
}
