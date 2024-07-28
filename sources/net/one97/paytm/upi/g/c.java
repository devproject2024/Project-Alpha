package net.one97.paytm.upi.g;

import android.content.Context;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.paytm.utility.b;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.util.GzipUtils;
import org.json.JSONObject;

public class c extends StringRequest {

    /* renamed from: a  reason: collision with root package name */
    private final Response.Listener<String> f66961a;

    /* renamed from: b  reason: collision with root package name */
    private String f66962b;

    @Deprecated
    public c(String str, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        this((Context) null, 1, str, listener, errorListener);
    }

    public c(Context context, int i2, final String str, Response.Listener<String> listener, final Response.ErrorListener errorListener) {
        super(i2, str, listener, new Response.ErrorListener() {
            /* JADX WARNING: Code restructure failed: missing block: B:30:0x0095, code lost:
                r8 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:32:0x0097, code lost:
                r8 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:35:0x009a, code lost:
                r8.printStackTrace();
                r8 = new net.one97.paytm.upi.common.UpiCustomVolleyError("");
                r8.setUrl(r4);
                r8.setUniqueReference("");
                r8.setmErrorCode(java.lang.String.valueOf(r1));
                r0 = r6;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b3, code lost:
                if (r0 != null) goto L_0x00b5;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b5, code lost:
                r0.onErrorResponse(r8);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b9, code lost:
                r8.printStackTrace();
                r8 = new net.one97.paytm.upi.common.UpiCustomVolleyError(java.lang.String.valueOf(r0));
                r8.setUrl(r4);
                r8.setmErrorCode(java.lang.String.valueOf(r1));
                r0 = r6;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d3, code lost:
                if (r0 != null) goto L_0x00d5;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d5, code lost:
                r0.onErrorResponse(r8);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
                return;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x0097 A[Catch:{ f -> 0x0097, Exception -> 0x0095 }, ExcHandler: f (r8v1 'e' net.one97.paytm.upi.g.f A[CUSTOM_DECLARE, Catch:{ f -> 0x0097, Exception -> 0x0095 }]), Splitter:B:6:0x000c] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onErrorResponse(com.android.volley.VolleyError r8) {
                /*
                    r7 = this;
                    com.android.volley.NetworkResponse r0 = r8.networkResponse
                    if (r0 == 0) goto L_0x0007
                    int r1 = r0.statusCode
                    goto L_0x0008
                L_0x0007:
                    r1 = -1
                L_0x0008:
                    java.lang.String r2 = ""
                    if (r0 == 0) goto L_0x0099
                    java.util.Map<java.lang.String, java.lang.String> r3 = r0.headers     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    java.lang.String r4 = "Content-Encoding"
                    java.lang.Object r3 = r3.get(r4)     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    java.lang.String r3 = (java.lang.String) r3     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    byte[] r4 = r0.data     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    if (r4 == 0) goto L_0x0037
                    if (r3 == 0) goto L_0x002f
                    java.lang.String r4 = "gzip"
                    boolean r3 = r3.equals(r4)     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    if (r3 == 0) goto L_0x002f
                    byte[] r3 = r0.data     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    java.io.Reader r3 = net.one97.paytm.upi.util.GzipUtils.convertReader(r3)     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    java.lang.String r3 = net.one97.paytm.upi.util.GzipUtils.convertString(r3)     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    goto L_0x0038
                L_0x002f:
                    java.lang.String r3 = new java.lang.String     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    byte[] r4 = r0.data     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    r3.<init>(r4)     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    goto L_0x0038
                L_0x0037:
                    r3 = r2
                L_0x0038:
                    boolean r4 = com.paytm.utility.k.b()     // Catch:{ Exception -> 0x006d, f -> 0x0097 }
                    if (r4 != 0) goto L_0x0071
                    net.one97.paytm.upi.g.g$b r4 = new net.one97.paytm.upi.g.g$b     // Catch:{ Exception -> 0x006d, f -> 0x0097 }
                    r4.<init>()     // Catch:{ Exception -> 0x006d, f -> 0x0097 }
                    r4.a((int) r1)     // Catch:{ Exception -> 0x006d, f -> 0x0097 }
                    java.lang.String r5 = r4     // Catch:{ Exception -> 0x006d, f -> 0x0097 }
                    java.lang.String r5 = net.one97.paytm.upi.util.UpiAppUtils.removeParams(r5)     // Catch:{ Exception -> 0x006d, f -> 0x0097 }
                    r4.b(r5)     // Catch:{ Exception -> 0x006d, f -> 0x0097 }
                    long r5 = r8.getNetworkTimeMs()     // Catch:{ Exception -> 0x006d, f -> 0x0097 }
                    java.lang.String r8 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x006d, f -> 0x0097 }
                    r4.a((java.lang.String) r8)     // Catch:{ Exception -> 0x006d, f -> 0x0097 }
                    net.one97.paytm.upi.common.UpiGTMLoader r8 = net.one97.paytm.upi.common.UpiGTMLoader.getInstance()     // Catch:{ Exception -> 0x006d, f -> 0x0097 }
                    boolean r8 = r8.isIncludeResponse()     // Catch:{ Exception -> 0x006d, f -> 0x0097 }
                    if (r8 == 0) goto L_0x0067
                    r4.c(r3)     // Catch:{ Exception -> 0x006d, f -> 0x0097 }
                L_0x0067:
                    java.lang.String r8 = "error"
                    net.one97.paytm.upi.g.g.a(r4, r8)     // Catch:{ Exception -> 0x006d, f -> 0x0097 }
                    goto L_0x0071
                L_0x006d:
                    r8 = move-exception
                    r8.printStackTrace()     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                L_0x0071:
                    com.android.volley.Response$ErrorListener r8 = r6     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    if (r8 == 0) goto L_0x008f
                    net.one97.paytm.upi.common.UpiCustomVolleyError r8 = new net.one97.paytm.upi.common.UpiCustomVolleyError     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    r8.<init>((java.lang.String) r4)     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    java.lang.String r4 = r4     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    r8.setUrl(r4)     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    java.lang.String r4 = java.lang.String.valueOf(r1)     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    r8.setmErrorCode(r4)     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    com.android.volley.Response$ErrorListener r4 = r6     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    r4.onErrorResponse(r8)     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                L_0x008f:
                    net.one97.paytm.upi.g.f r8 = new net.one97.paytm.upi.g.f     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    r8.<init>(r3)     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                    throw r8     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                L_0x0095:
                    r8 = move-exception
                    goto L_0x009a
                L_0x0097:
                    r8 = move-exception
                    goto L_0x00b9
                L_0x0099:
                    throw r8     // Catch:{ f -> 0x0097, Exception -> 0x0095 }
                L_0x009a:
                    r8.printStackTrace()
                    net.one97.paytm.upi.common.UpiCustomVolleyError r8 = new net.one97.paytm.upi.common.UpiCustomVolleyError
                    r8.<init>((java.lang.String) r2)
                    java.lang.String r0 = r4
                    r8.setUrl(r0)
                    r8.setUniqueReference(r2)
                    java.lang.String r0 = java.lang.String.valueOf(r1)
                    r8.setmErrorCode(r0)
                    com.android.volley.Response$ErrorListener r0 = r6
                    if (r0 == 0) goto L_0x00b8
                    r0.onErrorResponse(r8)
                L_0x00b8:
                    return
                L_0x00b9:
                    r8.printStackTrace()
                    net.one97.paytm.upi.common.UpiCustomVolleyError r8 = new net.one97.paytm.upi.common.UpiCustomVolleyError
                    java.lang.String r0 = java.lang.String.valueOf(r0)
                    r8.<init>((java.lang.String) r0)
                    java.lang.String r0 = r4
                    r8.setUrl(r0)
                    java.lang.String r0 = java.lang.String.valueOf(r1)
                    r8.setmErrorCode(r0)
                    com.android.volley.Response$ErrorListener r0 = r6
                    if (r0 == 0) goto L_0x00d8
                    r0.onErrorResponse(r8)
                L_0x00d8:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.g.c.AnonymousClass1.onErrorResponse(com.android.volley.VolleyError):void");
            }
        });
        if (context != null) {
            this.f66962b = b.e(context, str);
        } else {
            this.f66962b = str;
        }
        this.f66961a = listener;
        PaytmLogs.d("CJRStringRequest::Request:::", toString());
        PaytmLogs.d("CJRStringRequest::Url:::", this.f66962b);
    }

    public c(int i2, String str, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        this((Context) null, i2, str, listener, errorListener);
    }

    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        return super.setRetryPolicy(new DefaultRetryPolicy(60000, 1, 1.0f));
    }

    public void deliverResponse(String str) {
        try {
            if (this.f66961a != null) {
                this.f66961a.onResponse(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Response<String> parseNetworkResponse(NetworkResponse networkResponse) {
        String str;
        try {
            String str2 = networkResponse.headers.get("Content-Encoding");
            String str3 = "";
            if (networkResponse.data != null) {
                if (str2 != null) {
                    if (str2.equals("gzip")) {
                        str = GzipUtils.convertString(GzipUtils.convertReader(networkResponse.data));
                    }
                }
                String str4 = new String(networkResponse.data);
                str4.getBytes();
                str = str4;
            } else {
                str = str3;
            }
            try {
                str3 = new JSONObject(str).toString(4);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            PaytmLogs.d("CJRStringRequest::Response:::", "=====response======".concat(String.valueOf(str3)));
            return Response.success(str, getCacheEntry());
        } catch (Exception e3) {
            e3.printStackTrace();
            return Response.error(new VolleyError((Throwable) e3));
        }
    }
}
