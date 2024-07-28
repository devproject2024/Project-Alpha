package com.paytm.erroranalytics.data.b;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.paytm.erroranalytics.e;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.zip.GZIPOutputStream;
import net.one97.paytm.upi.util.UpiConstants;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

final class a implements Callable<C0713a> {

    /* renamed from: a  reason: collision with root package name */
    private URL f42784a;

    /* renamed from: b  reason: collision with root package name */
    private C0713a f42785b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f42786c;

    /* renamed from: d  reason: collision with root package name */
    private String f42787d;

    /* renamed from: e  reason: collision with root package name */
    private String f42788e;

    private a(String str, String str2, String str3) throws MalformedURLException {
        this.f42784a = new URL(str);
        this.f42787d = str2;
        this.f42788e = str3;
    }

    static a a(String str, String str2, String str3) throws MalformedURLException {
        a aVar = new a(str, str2, str3);
        aVar.f42786c = true;
        return aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C0713a call() {
        if (this.f42786c) {
            String str = e.f42808a;
            new StringBuilder("Api connection initiated for URl ").append(this.f42784a);
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
            OkHttpClient build = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
            try {
                byte[] bytes = this.f42787d.getBytes(AppConstants.UTF_8);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                Request.Builder post = new Request.Builder().url(this.f42784a).addHeader(UpiConstants.CACHE_CONTROL, "no-cache").addHeader("Content-Encoding", "gzip").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), byteArrayOutputStream.toByteArray()));
                if (this.f42788e != null) {
                    post.addHeader("authorization", "Basic " + this.f42788e);
                }
                String str2 = e.f42808a;
                new StringBuilder("REQUEST : ").append(this.f42787d);
                Response execute = FirebasePerfOkHttpClient.execute(build.newCall(post.build()));
                this.f42785b = new C0713a();
                this.f42785b.f42789a = execute.networkResponse().code();
                try {
                    this.f42785b.f42790b = execute.body().string();
                } catch (IOException e2) {
                    if (e2.getMessage() != null) {
                        e2.getMessage();
                    }
                    this.f42785b.f42791c = e2;
                }
                String str3 = e.f42808a;
                new StringBuilder("RESPONSE CODE : ").append(this.f42785b.f42789a);
            } catch (IOException e3) {
                if (e3.getMessage() != null) {
                    e3.getMessage();
                }
                if (this.f42785b == null) {
                    this.f42785b = new C0713a();
                }
                C0713a aVar = this.f42785b;
                aVar.f42791c = e3;
                aVar.f42789a = 1;
            }
        }
        return this.f42785b;
    }

    /* renamed from: com.paytm.erroranalytics.data.b.a$a  reason: collision with other inner class name */
    class C0713a {

        /* renamed from: a  reason: collision with root package name */
        int f42789a;

        /* renamed from: b  reason: collision with root package name */
        String f42790b;

        /* renamed from: c  reason: collision with root package name */
        Throwable f42791c;

        C0713a() {
        }
    }
}
