package com.google.firebase.crashlytics.a.f;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class b {

    /* renamed from: b  reason: collision with root package name */
    private static final OkHttpClient f38574b = new OkHttpClient().newBuilder().callTimeout(10000, TimeUnit.MILLISECONDS).build();

    /* renamed from: a  reason: collision with root package name */
    public final a f38575a;

    /* renamed from: c  reason: collision with root package name */
    private final String f38576c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, String> f38577d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, String> f38578e;

    /* renamed from: f  reason: collision with root package name */
    private MultipartBody.Builder f38579f = null;

    public b(a aVar, String str, Map<String, String> map) {
        this.f38575a = aVar;
        this.f38576c = str;
        this.f38577d = map;
        this.f38578e = new HashMap();
    }

    public final b a(String str, String str2) {
        this.f38578e.put(str, str2);
        return this;
    }

    private MultipartBody.Builder b() {
        if (this.f38579f == null) {
            this.f38579f = new MultipartBody.Builder().setType(MultipartBody.FORM);
        }
        return this.f38579f;
    }

    public final b b(String str, String str2) {
        this.f38579f = b().addFormDataPart(str, str2);
        return this;
    }

    public final b a(String str, String str2, String str3, File file) {
        this.f38579f = b().addFormDataPart(str, str2, RequestBody.create(MediaType.parse(str3), file));
        return this;
    }

    public final d a() throws IOException {
        Request.Builder cacheControl = new Request.Builder().cacheControl(new CacheControl.Builder().noCache().build());
        HttpUrl.Builder newBuilder = HttpUrl.parse(this.f38576c).newBuilder();
        for (Map.Entry next : this.f38577d.entrySet()) {
            newBuilder = newBuilder.addEncodedQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        Request.Builder url = cacheControl.url(newBuilder.build());
        for (Map.Entry next2 : this.f38578e.entrySet()) {
            url = url.header((String) next2.getKey(), (String) next2.getValue());
        }
        MultipartBody.Builder builder = this.f38579f;
        String str = null;
        Response execute = f38574b.newCall(url.method(this.f38575a.name(), builder == null ? null : builder.build()).build()).execute();
        if (execute.body() != null) {
            str = execute.body().string();
        }
        return new d(execute.code(), str, execute.headers());
    }
}
