package net.one97.paytm.payments.visascp.network;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.payments.visascp.network.model.BaseModel;
import net.one97.paytm.payments.visascp.util.VisaSCPConstants;

public class VolleyRequest extends JsonRequest<BaseModel> {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f606 = 1;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f607;

    /* renamed from: ˊ  reason: contains not printable characters */
    private BaseModel f608;

    /* renamed from: ˋ  reason: contains not printable characters */
    private HashMap<String, String> f609;

    public VolleyRequest(int i2, String str, String str2, BaseModel baseModel, Response.Listener<BaseModel> listener, Response.ErrorListener errorListener) {
        super(i2, str, str2, listener, errorListener);
        setRetryPolicy(new DefaultRetryPolicy(5000, 0, 0.0f));
        this.f608 = baseModel;
        String str3 = VisaSCPConstants.LOG_TAG;
        "URL = ".concat(String.valueOf(str));
        String str4 = VisaSCPConstants.LOG_TAG;
        "Request Body = ".concat(String.valueOf(str2));
    }

    public VolleyRequest(int i2, String str, String str2, HashMap<String, String> hashMap, BaseModel baseModel, Response.Listener<BaseModel> listener, Response.ErrorListener errorListener) {
        super(i2, str, str2, listener, errorListener);
        setRetryPolicy(new DefaultRetryPolicy(5000, 0, 0.0f));
        this.f609 = hashMap;
        this.f608 = baseModel;
        String str3 = VisaSCPConstants.LOG_TAG;
        "URL = ".concat(String.valueOf(str));
        String str4 = VisaSCPConstants.LOG_TAG;
        "Request Body = ".concat(String.valueOf(str2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: net.one97.paytm.payments.visascp.network.model.BaseModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.android.volley.Response<net.one97.paytm.payments.visascp.network.model.BaseModel> parseNetworkResponse(com.android.volley.NetworkResponse r6) {
        /*
            r5 = this;
            com.google.gson.f r0 = new com.google.gson.f
            r0.<init>()
            java.lang.String r1 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x007f }
            byte[] r2 = r6.data     // Catch:{ UnsupportedEncodingException -> 0x007f }
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.headers     // Catch:{ UnsupportedEncodingException -> 0x007f }
            java.lang.String r4 = "utf-8"
            java.lang.String r3 = com.android.volley.toolbox.HttpHeaderParser.parseCharset(r3, r4)     // Catch:{ UnsupportedEncodingException -> 0x007f }
            r1.<init>(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x007f }
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ UnsupportedEncodingException -> 0x007f }
            java.lang.String r2 = "Response = "
            r2.concat(r1)     // Catch:{ UnsupportedEncodingException -> 0x007f }
            net.one97.paytm.payments.visascp.network.model.BaseModel r2 = new net.one97.paytm.payments.visascp.network.model.BaseModel     // Catch:{ UnsupportedEncodingException -> 0x007f }
            r2.<init>()     // Catch:{ UnsupportedEncodingException -> 0x007f }
            java.lang.String r3 = "OK"
            boolean r3 = r3.equalsIgnoreCase(r1)     // Catch:{ UnsupportedEncodingException -> 0x007f }
            r4 = 1
            if (r3 == 0) goto L_0x002c
            r3 = 1
            goto L_0x002d
        L_0x002c:
            r3 = 0
        L_0x002d:
            if (r3 == r4) goto L_0x0056
            int r2 = f607
            int r2 = r2 + 75
            int r3 = r2 % 128
            f606 = r3
            int r2 = r2 % 2
            net.one97.paytm.payments.visascp.network.model.BaseModel r2 = r5.f608     // Catch:{ UnsupportedEncodingException -> 0x007f }
            java.lang.Class r2 = r2.getClass()     // Catch:{ UnsupportedEncodingException -> 0x007f }
            java.lang.Object r0 = r0.a((java.lang.String) r1, r2)     // Catch:{ UnsupportedEncodingException -> 0x007f }
            r2 = r0
            net.one97.paytm.payments.visascp.network.model.BaseModel r2 = (net.one97.paytm.payments.visascp.network.model.BaseModel) r2     // Catch:{ UnsupportedEncodingException -> 0x007f }
            int r0 = f607
            int r0 = r0 + 51
            int r0 = r0 - r4
            int r1 = ~r0
            r0 = r0 & -1
            int r0 = r0 << r4
            int r1 = r1 + r0
            int r0 = r1 % 128
            f606 = r0
            int r1 = r1 % 2
        L_0x0056:
            r2.setResponse(r6)     // Catch:{ UnsupportedEncodingException -> 0x007f }
            com.android.volley.Cache$Entry r6 = com.android.volley.toolbox.HttpHeaderParser.parseCacheHeaders(r6)     // Catch:{ UnsupportedEncodingException -> 0x007f }
            com.android.volley.Response r6 = com.android.volley.Response.success(r2, r6)     // Catch:{ UnsupportedEncodingException -> 0x007f }
            int r0 = f606
            r1 = r0 & 105(0x69, float:1.47E-43)
            int r2 = ~r1
            r0 = r0 | 105(0x69, float:1.47E-43)
            r0 = r0 & r2
            int r1 = r1 << r4
            r2 = r0 | r1
            int r2 = r2 << r4
            r0 = r0 ^ r1
            int r2 = r2 - r0
            int r0 = r2 % 128
            f607 = r0
            int r2 = r2 % 2
            r0 = 46
            if (r2 != 0) goto L_0x007c
            r1 = 39
            goto L_0x007e
        L_0x007c:
            r1 = 46
        L_0x007e:
            return r6
        L_0x007f:
            java.lang.String r6 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r6 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            com.android.volley.ParseError r6 = new com.android.volley.ParseError
            r6.<init>()
            com.android.volley.Response r6 = com.android.volley.Response.error(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.network.VolleyRequest.parseNetworkResponse(com.android.volley.NetworkResponse):com.android.volley.Response");
    }

    public void deliverError(VolleyError volleyError) {
        super.deliverError(volleyError);
        String str = VisaSCPConstants.LOG_TAG;
        new StringBuilder("Error Response = ").append(volleyError.toString());
        int i2 = f607;
        int i3 = ((i2 ^ 85) | (i2 & 85)) << 1;
        int i4 = -(((~i2) & 85) | (i2 & -86));
        int i5 = (i3 & i4) + (i4 | i3);
        f606 = i5 % 128;
        if (i5 % 2 == 0) {
        }
    }

    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(VisaSCPConstants.HEADER_KEY_ACCEPT, VisaSCPConstants.HEADER_VALUE_APP_JSON);
        hashMap.put(VisaSCPConstants.HEADER_KEY_CONTENT_TYPE, VisaSCPConstants.HEADER_VALUE_APP_JSON);
        if ((this.f609 == null ? 'Q' : '7') != 'Q') {
            int i2 = f607;
            int i3 = ((i2 | 101) << 1) - (i2 ^ 101);
            f606 = i3 % 128;
            int i4 = i3 % 2;
            hashMap.putAll(this.f609);
            int i5 = f607;
            int i6 = ((i5 | 23) << 1) - (i5 ^ 23);
            f606 = i6 % 128;
            int i7 = i6 % 2;
        }
        String str = VisaSCPConstants.LOG_TAG;
        new StringBuilder("Headers = ").append(hashMap.toString());
        int i8 = (f607 + 56) - 1;
        f606 = i8 % 128;
        int i9 = i8 % 2;
        return hashMap;
    }
}
