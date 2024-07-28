package com.paytm.android.chat.network.interceptors;

import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Response;

public final class CacheInterceptor implements Interceptor {
    /* access modifiers changed from: private */
    public static final String AGE = AGE;
    /* access modifiers changed from: private */
    public static final String CACHE_CONTROL = CACHE_CONTROL;
    /* access modifiers changed from: private */
    public static final String CACHE_HEADER = CACHE_HEADER;
    public static final Companion Companion = new Companion((g) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String getCACHE_CONTROL() {
            return CacheInterceptor.CACHE_CONTROL;
        }

        public final String getCACHE_HEADER() {
            return CacheInterceptor.CACHE_HEADER;
        }

        public final String getAGE() {
            return CacheInterceptor.AGE;
        }
    }

    public final Response intercept(Interceptor.Chain chain) {
        k.c(chain, "chain");
        chain.request();
        Response proceed = chain.proceed(chain.request());
        k.a((Object) proceed, "originalResponse");
        if (!proceed.isSuccessful() || proceed.header(CACHE_CONTROL) == null) {
            return proceed;
        }
        Response.Builder newBuilder = proceed.newBuilder();
        String str = CACHE_CONTROL;
        StringBuilder sb = new StringBuilder();
        sb.append(CACHE_HEADER);
        Headers headers = proceed.headers();
        k.a((Object) headers, "originalResponse.headers()");
        sb.append(getMaxCachingAge(headers));
        Response build = newBuilder.header(str, sb.toString()).build();
        k.a((Object) build, "originalResponse.newBuil…                 .build()");
        return build;
    }

    private final long getMaxCachingAge(Headers headers) {
        int i2;
        int i3 = 0;
        try {
            String str = headers.get(CACHE_CONTROL);
            String c2 = str != null ? p.d(str, "=", str) : null;
            if (c2 == null) {
                k.a();
            }
            i2 = Integer.parseInt(c2);
        } catch (Exception unused) {
            i2 = 0;
        }
        try {
            String str2 = headers.get(AGE);
            if (str2 == null) {
                k.a();
            }
            k.a((Object) str2, "headers.get(AGE)!!");
            i3 = Integer.parseInt(str2);
        } catch (Exception unused2) {
        }
        return (long) Math.abs(i2 - i3);
    }
}
