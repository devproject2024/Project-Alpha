package com.business.a;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.business.a.a;
import com.business.merchant_payments.common.utility.AppConstants;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class c implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    a.b f7272a;

    /* renamed from: b  reason: collision with root package name */
    a.C0102a f7273b;

    /* renamed from: c  reason: collision with root package name */
    a.c f7274c;

    public final Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        boolean z;
        Request request = chain.request();
        a.C0102a aVar = this.f7273b;
        boolean z2 = false;
        String str2 = "";
        if (aVar != null) {
            HashMap<String, String> a2 = aVar.a();
            if (a2 == null || !a2.containsKey(AppConstants.X_APP_RID)) {
                str = str2;
            } else {
                str = a2.get(AppConstants.X_APP_RID);
            }
            if (!(a2 == null || a2.size() == 0)) {
                String str3 = request.headers().get("should_send_common_headers");
                if (!TextUtils.isEmpty(str3) && !str3.equalsIgnoreCase("true")) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    request = request.newBuilder().build();
                    for (String next : a2.keySet()) {
                        request = request.newBuilder().addHeader(next, a2.get(next)).build();
                    }
                }
            }
        } else {
            str = str2;
        }
        a.b bVar = this.f7272a;
        if (bVar != null) {
            str2 = bVar.a();
        }
        if (this.f7274c.getAppContext() != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f7274c.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                z2 = true;
            }
            if (z2) {
                try {
                    Response proceed = chain.proceed(request);
                    if (proceed != null) {
                        HashMap<String, String> a3 = a(request, str2, str);
                        a3.put("responseCode", String.valueOf(proceed.code()));
                        a3.put("responseTime", String.valueOf(proceed.receivedResponseAtMillis() - proceed.sentRequestAtMillis()));
                        if (proceed.body() != null) {
                            a3.put("responseSize", String.valueOf(proceed.body().contentLength()));
                        }
                        if (!(proceed.request() == null || proceed.request().url() == null)) {
                            a3.put("uri", proceed.request().url().toString());
                        }
                        if (proceed.code() < 200 || proceed.code() >= 400) {
                            if (!TextUtils.isEmpty(proceed.message())) {
                                a3.put("errorMsg", proceed.message());
                            }
                            a3.put(CLConstants.FIELD_ERROR_CODE, String.valueOf(proceed.code()));
                            if (proceed.body() != null) {
                                try {
                                    a3.put("customMessage", proceed.peekBody(Long.MAX_VALUE).string());
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        this.f7272a.a(a3);
                    }
                    return proceed;
                } catch (Exception e3) {
                    long connectTimeoutMillis = (long) chain.connectTimeoutMillis();
                    if (request != null) {
                        HashMap<String, String> a4 = a(request, str2, str);
                        a4.put("responseTime", String.valueOf(connectTimeoutMillis));
                        this.f7272a.a(a4);
                    }
                    throw new IOException(e3.getMessage());
                }
            }
        }
        if (request != null) {
            try {
                HashMap<String, String> a5 = a(request, str2, str);
                a5.put("customMessage", "No Network Connection");
                this.f7272a.a(a5);
            } catch (Exception unused) {
                throw new IOException("No Network is Available!");
            }
        }
        request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=604800").build();
        return chain.proceed(request);
    }

    private static HashMap<String, String> a(Request request, String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("screen_name", str);
            if (request.url() != null) {
                hashMap.put("uri", request.url().toString());
            }
            hashMap.put("requestSize", String.valueOf(request.body().contentLength()));
            hashMap.put(AppConstants.X_APP_RID, str2);
        } catch (Exception unused) {
        }
        return hashMap;
    }
}
