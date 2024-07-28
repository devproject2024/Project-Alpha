package com.paytm.network;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.b.k;
import com.paytm.network.listener.c;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkCustomVolleyError;
import com.paytm.network.model.PaytmMultipartApiSuccessModel;
import com.paytm.utility.q;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private boolean A;
    private Map<String, String> B;
    private Map<String, File> C;

    /* renamed from: a  reason: collision with root package name */
    a.c f42906a;

    /* renamed from: b  reason: collision with root package name */
    a.C0715a f42907b;

    /* renamed from: c  reason: collision with root package name */
    g f42908c;

    /* renamed from: d  reason: collision with root package name */
    final Context f42909d;

    /* renamed from: e  reason: collision with root package name */
    String f42910e;

    /* renamed from: f  reason: collision with root package name */
    String f42911f;

    /* renamed from: g  reason: collision with root package name */
    Map<String, String> f42912g;

    /* renamed from: h  reason: collision with root package name */
    c f42913h;

    /* renamed from: i  reason: collision with root package name */
    boolean f42914i;
    String j;
    String k;
    IJRPaytmDataModel l;
    String m = AppConstants.X_APP_RID;
    String n = "";
    private boolean o = true;
    private Object p;
    private boolean q;
    private boolean r;
    private boolean s;
    private Map<String, String> t;
    private boolean u = true;
    private RetryPolicy v;
    private a w;
    private b x;
    private int y = -1;
    private int z;

    public enum a {
        USER_FACING("true"),
        SILENT("false");
        
        private final String stringValue;

        private a(String str) {
            this.stringValue = str;
        }

        public final String toString() {
            return this.stringValue;
        }
    }

    public d(e eVar) {
        this.f42909d = eVar.f42916a;
        this.f42906a = eVar.f42921f;
        this.f42911f = eVar.f42923h;
        this.f42913h = eVar.f42924i;
        this.w = eVar.j;
        this.j = eVar.k;
        this.k = eVar.l;
        this.x = new b(this, (byte) 0);
        this.v = eVar.m;
        this.f42910e = eVar.o;
        this.t = eVar.f42919d;
        this.q = eVar.p;
        this.r = eVar.q;
        this.f42912g = eVar.f42920e;
        this.B = eVar.f42917b;
        this.C = eVar.f42918c;
        this.f42907b = eVar.f42922g;
        this.l = eVar.n;
        this.y = eVar.s;
        this.z = eVar.r;
        this.A = eVar.t;
        RetryPolicy retryPolicy = this.v;
        if (retryPolicy != null) {
            this.y = retryPolicy.getCurrentRetryCount();
            this.z = this.v.getCurrentTimeout();
        }
        NetworkCustomVolleyError networkCustomVolleyError = new NetworkCustomVolleyError(H5BridgeContext.INVALID_ID);
        networkCustomVolleyError.setErrorType(NetworkCustomError.ErrorType.NetworkError);
        if (this.f42913h == null) {
            this.o = false;
            q.d("validate :- mApiListener is null");
            throw new IllegalArgumentException("Invalid Params : No Listener registered for this api call");
        } else if (this.f42909d == null) {
            networkCustomVolleyError.setErrorType(NetworkCustomError.ErrorType.InvalidArgumentError);
            networkCustomVolleyError.setmAlertTitle("Invalid Params");
            networkCustomVolleyError.setAlertMessage("Invalid Params : Context can not be null");
            q.d("validate :- context is null");
            b bVar = this.x;
            if (bVar != null) {
                bVar.onErrorResponse(networkCustomVolleyError);
            }
            this.o = false;
        } else if (this.f42911f == null) {
            networkCustomVolleyError.setErrorType(NetworkCustomError.ErrorType.InvalidArgumentError);
            networkCustomVolleyError.setmAlertTitle("Invalid Params");
            networkCustomVolleyError.setAlertMessage("Invalid Params : Url cannot be null");
            q.d("validate :- url is null");
            b bVar2 = this.x;
            if (bVar2 != null) {
                bVar2.onErrorResponse(networkCustomVolleyError);
            }
            this.o = false;
        } else if (this.w == null) {
            networkCustomVolleyError.setErrorType(NetworkCustomError.ErrorType.InvalidArgumentError);
            networkCustomVolleyError.setmAlertTitle("Invalid Params");
            networkCustomVolleyError.setAlertMessage("Invalid Params : User Facing Param is null");
            b bVar3 = this.x;
            if (bVar3 != null) {
                bVar3.onErrorResponse(networkCustomVolleyError);
            }
            this.o = false;
        } else if (this.f42906a == null) {
            networkCustomVolleyError.setErrorType(NetworkCustomError.ErrorType.InvalidArgumentError);
            networkCustomVolleyError.setmAlertTitle("Invalid Params");
            networkCustomVolleyError.setAlertMessage("Invalid Params : VerticalId Param is null");
            b bVar4 = this.x;
            if (bVar4 != null) {
                bVar4.onErrorResponse(networkCustomVolleyError);
            }
            this.o = false;
        } else if (TextUtils.isEmpty(this.j)) {
            networkCustomVolleyError.setErrorType(NetworkCustomError.ErrorType.InvalidArgumentError);
            networkCustomVolleyError.setmAlertTitle("Invalid Params");
            networkCustomVolleyError.setAlertMessage("Invalid Params : ScreenName Param is either null or empty");
            b bVar5 = this.x;
            if (bVar5 != null) {
                bVar5.onErrorResponse(networkCustomVolleyError);
            }
            this.o = false;
        } else if (this.l == null) {
            NetworkCustomVolleyError networkCustomVolleyError2 = new NetworkCustomVolleyError("ResponseModel is null");
            networkCustomVolleyError2.setErrorType(NetworkCustomError.ErrorType.InvalidArgumentError);
            networkCustomVolleyError2.setmAlertTitle("Invalid Params");
            networkCustomVolleyError2.setAlertMessage("Invalid Params : ResponseModel is null");
            b bVar6 = this.x;
            if (bVar6 != null) {
                bVar6.onErrorResponse(networkCustomVolleyError2);
            }
            this.o = false;
        }
    }

    public static String a(String str, String str2, Map<String, String> map) {
        if (str == null) {
            return null;
        }
        try {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            if (str2 != null) {
                buildUpon.appendEncodedPath(str2);
            }
            if (map != null && map.size() > 0) {
                for (String next : map.keySet()) {
                    buildUpon.appendQueryParameter(next, map.get(next));
                }
            }
            return buildUpon.build().toString();
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public final void a() {
        if (!this.o) {
            q.d("not making api call, as the validation failed");
            return;
        }
        String a2 = a(this.f42911f, this.f42910e, this.f42912g);
        if (this.f42907b == a.C0715a.GET && i.b(a2)) {
            a(i.a(a2));
            if (!this.s) {
                return;
            }
        }
        String b2 = b();
        if (b2 == null || !URLUtil.isValidUrl(b2)) {
            this.f42913h.handleErrorCode(-1, this.l, new NetworkCustomError("Invalid Url :- ".concat(String.valueOf(b2))));
            return;
        }
        if (this.t == null) {
            this.t = new HashMap();
        }
        if (this.r) {
            b2 = k.a(b2);
        }
        Map<String, String> map = this.t;
        Context context = this.f42909d;
        if (context != null) {
            this.n = com.paytm.network.b.d.a(context);
            map.put(this.m, this.n);
        }
        Context context2 = this.f42909d;
        int i2 = this.f42907b.value;
        b bVar = this.x;
        this.f42908c = new g(context2, i2, b2, bVar, bVar, this.C, this.B, this.t, this.l, this.f42906a, this.A);
        Object obj = this.p;
        if (obj != null) {
            this.f42908c.setTag(obj);
        }
        q.d("performNetworkRequest " + this.f42908c);
        if (com.paytm.network.b.b.a(this.f42909d)) {
            q.d("performNetworkRequest making api call for url ".concat(String.valueOf(b2)));
            f.b(this.f42909d).add(this.f42908c);
            return;
        }
        q.d("performNetworkRequest no internet connection ".concat(String.valueOf(b2)));
        NetworkCustomVolleyError networkCustomVolleyError = new NetworkCustomVolleyError(H5BridgeContext.INVALID_ID);
        networkCustomVolleyError.setErrorType(NetworkCustomError.ErrorType.NoConnectionError);
        b bVar2 = this.x;
        if (bVar2 != null) {
            bVar2.onErrorResponse(networkCustomVolleyError);
        }
    }

    private static void a(Uri.Builder builder, Map<String, String> map) {
        if (builder != null && map != null) {
            for (String next : map.keySet()) {
                builder.appendQueryParameter(next, URLEncoder.encode(map.get(next)));
            }
        }
    }

    private String b() {
        try {
            Uri.Builder buildUpon = Uri.parse(this.f42911f).buildUpon();
            Map<String, String> b2 = com.paytm.utility.c.b(this.f42909d, false);
            if (this.f42910e != null) {
                buildUpon.appendEncodedPath(this.f42910e);
            }
            a(buildUpon, this.f42912g);
            if (this.q) {
                a(buildUpon, b2);
            }
            return buildUpon.build().toString();
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (this.A) {
            com.paytm.network.a.a.a.a(new n(new PaytmMultipartApiSuccessModel(this.f42913h, iJRPaytmDataModel)));
            return;
        }
        c cVar = this.f42913h;
        if (cVar != null) {
            cVar.onApiSuccess(iJRPaytmDataModel);
        }
    }

    class b implements Response.ErrorListener, Response.Listener<IJRPaytmDataModel> {
        private b() {
        }

        /* synthetic */ b(d dVar, byte b2) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0042, code lost:
            r0 = r4.f42915a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onResponse(java.lang.Object r5) {
            /*
                r4 = this;
                com.paytm.network.model.IJRPaytmDataModel r5 = (com.paytm.network.model.IJRPaytmDataModel) r5
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "onResponse "
                r0.<init>(r1)
                com.paytm.network.d r1 = com.paytm.network.d.this
                com.paytm.network.g r1 = r1.f42908c
                r0.append(r1)
                java.lang.String r1 = " model "
                r0.append(r1)
                r0.append(r5)
                java.lang.String r0 = r0.toString()
                com.paytm.utility.q.d(r0)
                com.paytm.network.d r0 = com.paytm.network.d.this
                com.paytm.network.g r0 = r0.f42908c
                if (r0 == 0) goto L_0x002f
                com.paytm.network.d r0 = com.paytm.network.d.this
                com.paytm.network.g r0 = r0.f42908c
                boolean r0 = r0.isCanceled()
                if (r0 != 0) goto L_0x009d
            L_0x002f:
                com.paytm.network.d r0 = com.paytm.network.d.this
                r0.a(r5)
                com.paytm.network.d r0 = com.paytm.network.d.this
                com.paytm.network.a$a r0 = r0.f42907b
                com.paytm.network.a$a r1 = com.paytm.network.a.C0715a.GET
                if (r0 != r1) goto L_0x0060
                com.paytm.network.d r0 = com.paytm.network.d.this
                boolean r0 = r0.f42914i
                if (r0 != 0) goto L_0x0060
                com.paytm.network.d r0 = com.paytm.network.d.this
                java.lang.String r1 = r0.f42911f
                if (r1 == 0) goto L_0x0060
                if (r5 != 0) goto L_0x004b
                goto L_0x0060
            L_0x004b:
                java.lang.String r2 = r0.f42910e
                java.util.Map<java.lang.String, java.lang.String> r3 = r0.f42912g
                java.lang.String r1 = com.paytm.network.d.a(r1, r2, r3)
                com.paytm.network.a$a r0 = r0.f42907b
                com.paytm.network.a$a r2 = com.paytm.network.a.C0715a.GET
                if (r0 != r2) goto L_0x0060
                if (r1 == 0) goto L_0x0060
                if (r5 == 0) goto L_0x0060
                com.paytm.network.i.a(r1, r5)
            L_0x0060:
                if (r5 == 0) goto L_0x009d
                com.paytm.network.model.NetworkResponse r0 = r5.getNetworkResponse()
                if (r0 == 0) goto L_0x009d
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                com.paytm.network.d r1 = com.paytm.network.d.this
                java.lang.String r1 = r1.j
                java.lang.String r2 = "screen_name"
                r0.put(r2, r1)
                com.paytm.network.d r1 = com.paytm.network.d.this
                java.lang.String r1 = r1.k
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x0089
                com.paytm.network.d r1 = com.paytm.network.d.this
                java.lang.String r1 = r1.k
                java.lang.String r2 = "subVerticalName"
                r0.put(r2, r1)
            L_0x0089:
                r5.getNetworkResponse()
                r5.getNetworkResponse()
                com.paytm.network.d r5 = com.paytm.network.d.this
                java.lang.String r5 = r5.m
                com.paytm.network.d r1 = com.paytm.network.d.this
                java.lang.String r1 = r1.n
                r0.put(r5, r1)
                com.paytm.network.b.i.f()
            L_0x009d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.network.d.b.onResponse(java.lang.Object):void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:46:0x011a  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0123  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onErrorResponse(com.android.volley.VolleyError r10) {
            /*
                r9 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "onErrorResponse "
                r0.<init>(r1)
                com.paytm.network.d r2 = com.paytm.network.d.this
                com.paytm.network.g r2 = r2.f42908c
                r0.append(r2)
                java.lang.String r2 = " volleyError "
                r0.append(r2)
                r0.append(r10)
                java.lang.String r0 = r0.toString()
                com.paytm.utility.q.d(r0)
                com.paytm.network.d r0 = com.paytm.network.d.this
                com.paytm.network.g r0 = r0.f42908c
                if (r0 == 0) goto L_0x0033
                com.paytm.network.d r0 = com.paytm.network.d.this
                com.paytm.network.g r0 = r0.f42908c
                boolean r0 = r0.isCanceled()
                if (r0 == 0) goto L_0x0033
                java.lang.String r10 = "request is cancelled "
                com.paytm.utility.q.d(r10)
                return
            L_0x0033:
                r0 = -1
                com.paytm.network.model.NetworkCustomError r2 = new com.paytm.network.model.NetworkCustomError
                java.lang.String r3 = r10.getMessage()
                r2.<init>((java.lang.String) r3)
                com.paytm.network.model.NetworkCustomError$ErrorType r3 = com.paytm.network.model.NetworkCustomError.ErrorType.NetworkError
                r4 = 401(0x191, float:5.62E-43)
                com.paytm.network.d r5 = com.paytm.network.d.this     // Catch:{ Exception -> 0x00f6 }
                android.content.Context r5 = r5.f42909d     // Catch:{ Exception -> 0x00f6 }
                android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x00f6 }
                int r6 = com.paytm.networkmodule.R.string.error_dialog_title     // Catch:{ Exception -> 0x00f6 }
                java.lang.String r5 = r5.getString(r6)     // Catch:{ Exception -> 0x00f6 }
                com.paytm.network.d r6 = com.paytm.network.d.this     // Catch:{ Exception -> 0x00f6 }
                android.content.Context r6 = r6.f42909d     // Catch:{ Exception -> 0x00f6 }
                android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x00f6 }
                int r7 = com.paytm.networkmodule.R.string.error_dialog_body     // Catch:{ Exception -> 0x00f6 }
                java.lang.String r6 = r6.getString(r7)     // Catch:{ Exception -> 0x00f6 }
                com.paytm.network.d r7 = com.paytm.network.d.this     // Catch:{ Exception -> 0x00f6 }
                java.lang.String r7 = r7.f42911f     // Catch:{ Exception -> 0x00f6 }
                r2.setUrl(r7)     // Catch:{ Exception -> 0x00f6 }
                r2.setmAlertTitle(r6)     // Catch:{ Exception -> 0x00f6 }
                r2.setAlertMessage(r5)     // Catch:{ Exception -> 0x00f6 }
                if (r10 == 0) goto L_0x006f
                com.android.volley.NetworkResponse r5 = r10.networkResponse     // Catch:{ Exception -> 0x00f6 }
                goto L_0x0070
            L_0x006f:
                r5 = 0
            L_0x0070:
                if (r10 == 0) goto L_0x0082
                boolean r6 = r10 instanceof com.paytm.network.model.NetworkCustomVolleyError     // Catch:{ Exception -> 0x00f6 }
                if (r6 == 0) goto L_0x0082
                r3 = r10
                com.paytm.network.model.NetworkCustomVolleyError r3 = (com.paytm.network.model.NetworkCustomVolleyError) r3     // Catch:{ Exception -> 0x00f6 }
                com.android.volley.NetworkResponse r5 = r3.networkResponse     // Catch:{ Exception -> 0x00f6 }
                r3 = r10
                com.paytm.network.model.NetworkCustomVolleyError r3 = (com.paytm.network.model.NetworkCustomVolleyError) r3     // Catch:{ Exception -> 0x00f6 }
                com.paytm.network.model.NetworkCustomError$ErrorType r3 = r3.getErrorType()     // Catch:{ Exception -> 0x00f6 }
            L_0x0082:
                java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x00f6 }
                r6.<init>()     // Catch:{ Exception -> 0x00f6 }
                java.lang.String r7 = "screen_name"
                com.paytm.network.d r8 = com.paytm.network.d.this     // Catch:{ Exception -> 0x00f6 }
                java.lang.String r8 = r8.j     // Catch:{ Exception -> 0x00f6 }
                r6.put(r7, r8)     // Catch:{ Exception -> 0x00f6 }
                com.paytm.network.d r7 = com.paytm.network.d.this     // Catch:{ Exception -> 0x00f6 }
                java.lang.String r7 = r7.k     // Catch:{ Exception -> 0x00f6 }
                boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x00f6 }
                if (r7 != 0) goto L_0x00a3
                java.lang.String r7 = "subVerticalName"
                com.paytm.network.d r8 = com.paytm.network.d.this     // Catch:{ Exception -> 0x00f6 }
                java.lang.String r8 = r8.k     // Catch:{ Exception -> 0x00f6 }
                r6.put(r7, r8)     // Catch:{ Exception -> 0x00f6 }
            L_0x00a3:
                if (r5 == 0) goto L_0x00ae
                int r0 = r5.statusCode     // Catch:{ Exception -> 0x00f6 }
                com.paytm.network.model.NetworkResponse r5 = com.paytm.network.b.i.a((com.android.volley.NetworkResponse) r5)     // Catch:{ Exception -> 0x00f6 }
                r2.setNetworkResponse(r5)     // Catch:{ Exception -> 0x00f6 }
            L_0x00ae:
                r5 = 403(0x193, float:5.65E-43)
                if (r0 != r5) goto L_0x00bc
                r2.setStatusCode(r4)     // Catch:{ Exception -> 0x00b8 }
                r0 = 401(0x191, float:5.62E-43)
                goto L_0x00bc
            L_0x00b8:
                r10 = move-exception
                r0 = 401(0x191, float:5.62E-43)
                goto L_0x00f7
            L_0x00bc:
                com.paytm.network.d r4 = com.paytm.network.d.this     // Catch:{ Exception -> 0x00f6 }
                java.lang.String r4 = r4.m     // Catch:{ Exception -> 0x00f6 }
                com.paytm.network.d r5 = com.paytm.network.d.this     // Catch:{ Exception -> 0x00f6 }
                java.lang.String r5 = r5.n     // Catch:{ Exception -> 0x00f6 }
                r6.put(r4, r5)     // Catch:{ Exception -> 0x00f6 }
                com.paytm.network.b.i.f()     // Catch:{ Exception -> 0x00f6 }
                boolean r4 = r10 instanceof com.android.volley.AuthFailureError     // Catch:{ Exception -> 0x00f6 }
                if (r4 == 0) goto L_0x00d4
                com.paytm.network.model.NetworkCustomError$ErrorType r10 = com.paytm.network.model.NetworkCustomError.ErrorType.AuthFailureError     // Catch:{ Exception -> 0x00f6 }
                r2.setErrorType(r10)     // Catch:{ Exception -> 0x00f6 }
                goto L_0x00fe
            L_0x00d4:
                boolean r4 = r10 instanceof com.android.volley.ServerError     // Catch:{ Exception -> 0x00f6 }
                if (r4 == 0) goto L_0x00de
                com.paytm.network.model.NetworkCustomError$ErrorType r10 = com.paytm.network.model.NetworkCustomError.ErrorType.ServerError     // Catch:{ Exception -> 0x00f6 }
                r2.setErrorType(r10)     // Catch:{ Exception -> 0x00f6 }
                goto L_0x00fe
            L_0x00de:
                boolean r4 = r10 instanceof com.android.volley.TimeoutError     // Catch:{ Exception -> 0x00f6 }
                if (r4 == 0) goto L_0x00e8
                com.paytm.network.model.NetworkCustomError$ErrorType r10 = com.paytm.network.model.NetworkCustomError.ErrorType.TimeOutError     // Catch:{ Exception -> 0x00f6 }
                r2.setErrorType(r10)     // Catch:{ Exception -> 0x00f6 }
                goto L_0x00fe
            L_0x00e8:
                boolean r10 = r10 instanceof com.android.volley.NoConnectionError     // Catch:{ Exception -> 0x00f6 }
                if (r10 == 0) goto L_0x00f2
                com.paytm.network.model.NetworkCustomError$ErrorType r10 = com.paytm.network.model.NetworkCustomError.ErrorType.NoConnectionError     // Catch:{ Exception -> 0x00f6 }
                r2.setErrorType(r10)     // Catch:{ Exception -> 0x00f6 }
                goto L_0x00fe
            L_0x00f2:
                r2.setErrorType(r3)     // Catch:{ Exception -> 0x00f6 }
                goto L_0x00fe
            L_0x00f6:
                r10 = move-exception
            L_0x00f7:
                java.lang.String r10 = r10.getMessage()
                com.paytm.utility.q.b(r10)
            L_0x00fe:
                com.paytm.network.d r10 = com.paytm.network.d.this
                android.content.Context r10 = r10.f42909d
                com.paytm.network.model.CJRError r10 = com.paytm.network.b.f.a((android.content.Context) r10, (com.paytm.network.model.NetworkCustomError) r2)
                java.lang.String r3 = r10.getTitle()
                r2.setmAlertTitle(r3)
                java.lang.String r10 = r10.getMessage()
                r2.setAlertMessage(r10)
                com.paytm.network.model.NetworkCustomError$ErrorType r10 = r2.getErrorType()
                if (r10 == 0) goto L_0x0123
                com.paytm.network.model.NetworkCustomError$ErrorType r10 = r2.getErrorType()
                java.lang.String r10 = r10.name()
                goto L_0x0125
            L_0x0123:
                java.lang.String r10 = ""
            L_0x0125:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>(r1)
                com.paytm.network.d r1 = com.paytm.network.d.this
                com.paytm.network.g r1 = r1.f42908c
                r3.append(r1)
                java.lang.String r1 = " errorType "
                r3.append(r1)
                r3.append(r10)
                java.lang.String r10 = " status code "
                r3.append(r10)
                r3.append(r0)
                java.lang.String r10 = r3.toString()
                com.paytm.utility.q.d(r10)
                com.paytm.network.d r10 = com.paytm.network.d.this
                com.paytm.network.listener.c r10 = r10.f42913h
                com.paytm.network.d r1 = com.paytm.network.d.this
                com.paytm.network.model.IJRPaytmDataModel r1 = r1.l
                r10.handleErrorCode(r0, r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.network.d.b.onErrorResponse(com.android.volley.VolleyError):void");
        }
    }
}
