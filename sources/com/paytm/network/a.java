package com.paytm.network;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.nebula.util.H5Utils;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.b.i;
import com.paytm.network.b.k;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkCustomVolleyError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.network.model.PaytmCommonApiSuccessModel;
import com.paytm.utility.q;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONObject;

public class a {

    /* renamed from: e  reason: collision with root package name */
    private static boolean f42856e = true;
    /* access modifiers changed from: private */
    public IJRPaytmDataModel A;
    private d B;
    private int C = -1;
    private int D;
    /* access modifiers changed from: private */
    public String E = AppConstants.X_APP_RID;
    /* access modifiers changed from: private */
    public String F = "";
    private boolean G;
    private boolean H;

    /* renamed from: a  reason: collision with root package name */
    c f42857a;

    /* renamed from: b  reason: collision with root package name */
    C0715a f42858b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42859c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42860d;

    /* renamed from: f  reason: collision with root package name */
    private String f42861f;

    /* renamed from: g  reason: collision with root package name */
    private String f42862g;

    /* renamed from: h  reason: collision with root package name */
    private JSONObject f42863h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f42864i = true;
    private Object j;
    private boolean k = true;
    /* access modifiers changed from: private */
    public c l;
    /* access modifiers changed from: private */
    public final Context m;
    private boolean n;
    private boolean o;
    private String p;
    /* access modifiers changed from: private */
    public String q;
    private Map<String, String> r;
    /* access modifiers changed from: private */
    public Map<String, String> s;
    /* access modifiers changed from: private */
    public String t;
    /* access modifiers changed from: private */
    public com.paytm.network.listener.b u;
    private boolean v = true;
    private RetryPolicy w;
    /* access modifiers changed from: private */
    public b x;
    /* access modifiers changed from: private */
    public String y;
    /* access modifiers changed from: private */
    public String z;

    /* renamed from: com.paytm.network.a$a  reason: collision with other inner class name */
    public enum C0715a {
        GET(0),
        POST(1),
        PUT(2),
        DELETE(3),
        HEAD(4),
        OPTIONS(5),
        TRACE(6),
        PATCH(7);
        
        int value;

        private C0715a(int i2) {
            this.value = i2;
        }
    }

    public enum c {
        BUS("BUS"),
        TRAIN("TRAIN"),
        FLIGHT("FLIGHT"),
        HOTELS("HOTELS"),
        INBOX("INBOX"),
        GOLD("GOLD"),
        RECHARGES("RECHARGES"),
        TRANSPORTAION("TRANSPORTATION"),
        AM_PARK("AM_PARK"),
        EVENT("EVENT"),
        GAMEPIND("GAMES"),
        DEALS("DEALS"),
        SMS("SMS"),
        CHAT("CHAT"),
        CST("CST"),
        INSURANCE("INSURANCE"),
        KYC("KYC"),
        ACCEPTPAYMENT("ACCEPTPAYMENT"),
        ADDMONEY("ADDMONEY"),
        MONEYTRANSFER("MONEYTRANSFER"),
        PASSBOOK("PASSBOOK"),
        PAY("PAY"),
        PAYMENTSBANK("PAYMENTSBANK"),
        MOVIES("MOVIES"),
        CASHBACK("CASHBACK"),
        WIFI(H5Utils.NETWORK_TYPE_WIFI),
        TRANSPORT_IOCL("TRANSPORT_IOCL"),
        TRANSPORT_BRTS("TRANSPORT_BRTS"),
        AUTH("AUTH"),
        OAUTH("OAUTH"),
        P2P("P2P"),
        WALLET(SDKConstants.AI_KEY_WALLET),
        PAYMENTS("PAYMENTS"),
        SMART_RETAIL("SMART_RETAIL"),
        TRAVEL_PASS("TRAVEL_PASS"),
        EDUCATION("EDUCATION"),
        HOME("HOME"),
        PAYTM_FIRST("PAYTM_FIRST"),
        PAYTM_MONEY("PAYTM_MONEY"),
        MALL("MALL"),
        P2B("P2B"),
        APP_MANAGER("APP_MANAGER"),
        CHANNEL("CHANNEL"),
        TRAVEL_HOME("TRAVEL_HOME"),
        H5("H5"),
        UTILITY("UTILITY"),
        UPI("UPI"),
        COMS("COMS");
        
        String value;

        private c(String str) {
            this.value = str;
        }
    }

    public enum b {
        USER_FACING("true"),
        SILENT("false");
        
        private final String stringValue;

        private b(String str) {
            this.stringValue = str;
        }

        public final String toString() {
            return this.stringValue;
        }
    }

    public final void a(boolean z2) {
        this.f42860d = z2;
    }

    public a(Context context, C0715a aVar, String str, Map map, String str2, IJRPaytmDataModel iJRPaytmDataModel, com.paytm.network.listener.b bVar) {
        this.m = context;
        this.f42857a = null;
        this.f42858b = aVar;
        this.q = str;
        this.p = null;
        this.s = map;
        this.r = null;
        this.t = str2;
        this.u = bVar;
        this.A = iJRPaytmDataModel;
        this.f42859c = true;
        this.B = new d(this, (byte) 0);
        d();
    }

    public a(b bVar) {
        this.m = bVar.f42877a;
        this.f42858b = bVar.f42879c;
        this.f42857a = bVar.f42878b;
        this.q = bVar.f42880d;
        this.p = bVar.f42881e;
        this.s = bVar.f42882f;
        this.r = bVar.f42883g;
        this.t = bVar.f42884h;
        this.u = bVar.j;
        this.A = bVar.f42885i;
        this.f42859c = bVar.k;
        this.f42860d = bVar.l;
        this.v = bVar.m;
        this.x = bVar.n;
        this.y = bVar.o;
        this.z = bVar.p;
        this.B = new d(this, (byte) 0);
        this.n = bVar.r;
        this.w = bVar.q;
        this.f42862g = bVar.s;
        this.k = bVar.u;
        this.f42861f = bVar.v;
        this.C = bVar.x;
        this.D = bVar.w;
        this.G = bVar.y;
        this.H = bVar.z;
        RetryPolicy retryPolicy = this.w;
        if (retryPolicy != null) {
            this.C = retryPolicy.getCurrentRetryCount();
            this.D = this.w.getCurrentTimeout();
        }
        d();
    }

    public final void b(boolean z2) {
        this.f42859c = z2;
    }

    private void d() {
        if (this.u == null) {
            this.f42864i = false;
            q.d("validate :- mApiListener is null");
            throw new IllegalArgumentException("Invalid Params : No Listener registered for this api call");
        } else if (this.m == null) {
            NetworkCustomVolleyError networkCustomVolleyError = new NetworkCustomVolleyError("Context can not be null");
            networkCustomVolleyError.setErrorType(NetworkCustomError.ErrorType.InvalidArgumentError);
            networkCustomVolleyError.setmAlertTitle("Invalid Params");
            networkCustomVolleyError.setAlertMessage("Invalid Params : Context can not be null");
            q.d("validate :- context is null");
            d dVar = this.B;
            if (dVar != null) {
                dVar.onErrorResponse(networkCustomVolleyError);
            }
            this.f42864i = false;
        } else if (this.q == null) {
            NetworkCustomVolleyError networkCustomVolleyError2 = new NetworkCustomVolleyError("Url cannot be null");
            networkCustomVolleyError2.setErrorType(NetworkCustomError.ErrorType.InvalidArgumentError);
            networkCustomVolleyError2.setmAlertTitle("Invalid Params");
            networkCustomVolleyError2.setAlertMessage("Invalid Params : Url cannot be null");
            q.d("validate :- url is null");
            d dVar2 = this.B;
            if (dVar2 != null) {
                dVar2.onErrorResponse(networkCustomVolleyError2);
            }
            this.f42864i = false;
        } else if (this.x == null) {
            NetworkCustomVolleyError networkCustomVolleyError3 = new NetworkCustomVolleyError("User Facing Param is null");
            networkCustomVolleyError3.setErrorType(NetworkCustomError.ErrorType.InvalidArgumentError);
            networkCustomVolleyError3.setmAlertTitle("Invalid Params");
            networkCustomVolleyError3.setAlertMessage("Invalid Params : User Facing Param is null");
            d dVar3 = this.B;
            if (dVar3 != null) {
                dVar3.onErrorResponse(networkCustomVolleyError3);
            }
            this.f42864i = false;
        } else if (this.f42857a == null) {
            NetworkCustomVolleyError networkCustomVolleyError4 = new NetworkCustomVolleyError("VerticalId Param is null");
            networkCustomVolleyError4.setErrorType(NetworkCustomError.ErrorType.InvalidArgumentError);
            networkCustomVolleyError4.setmAlertTitle("Invalid Params");
            networkCustomVolleyError4.setAlertMessage("Invalid Params : VerticalId Param is null");
            d dVar4 = this.B;
            if (dVar4 != null) {
                dVar4.onErrorResponse(networkCustomVolleyError4);
            }
            this.f42864i = false;
        } else if (TextUtils.isEmpty(this.y)) {
            NetworkCustomVolleyError networkCustomVolleyError5 = new NetworkCustomVolleyError("ScreenName Param is either null or empty");
            networkCustomVolleyError5.setErrorType(NetworkCustomError.ErrorType.InvalidArgumentError);
            networkCustomVolleyError5.setmAlertTitle("Invalid Params");
            networkCustomVolleyError5.setAlertMessage("Invalid Params : ScreenName Param is either null or empty");
            d dVar5 = this.B;
            if (dVar5 != null) {
                dVar5.onErrorResponse(networkCustomVolleyError5);
            }
            this.f42864i = false;
        } else if (this.A == null) {
            NetworkCustomVolleyError networkCustomVolleyError6 = new NetworkCustomVolleyError("ResponseModel is null");
            networkCustomVolleyError6.setErrorType(NetworkCustomError.ErrorType.InvalidArgumentError);
            networkCustomVolleyError6.setmAlertTitle("Invalid Params");
            networkCustomVolleyError6.setAlertMessage("Invalid Params : ResponseModel is null");
            d dVar6 = this.B;
            if (dVar6 != null) {
                dVar6.onErrorResponse(networkCustomVolleyError6);
            }
            this.f42864i = false;
        }
    }

    private static String a(String str, String str2, Map<String, String> map) {
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

    public static void a(Context context, Object obj) {
        f.b(context).cancelAll(obj);
    }

    public final void a() {
        if (!this.f42864i) {
            q.d("not making api call, as the validation failed");
            return;
        }
        String a2 = a(this.q, this.p, this.r);
        if (this.f42858b == C0715a.GET && i.b(a2)) {
            a(i.a(a2));
            if (!this.o) {
                return;
            }
        }
        String e2 = e();
        if (e2 == null || !URLUtil.isValidUrl(e2)) {
            this.u.handleErrorCode(-1, this.A, new NetworkCustomError("Invalid Url :- ".concat(String.valueOf(e2))));
            return;
        }
        if (this.n) {
            e2 = com.paytm.network.b.b.b(e2, "POST");
        }
        if (this.s == null) {
            this.s = new HashMap();
        }
        if (this.k) {
            e2 = k.a(e2);
        }
        a(this.s);
        Context context = this.m;
        c cVar = this.f42857a;
        C0715a aVar = this.f42858b;
        Map<String, String> map = this.s;
        d dVar = this.B;
        this.l = new c(context, cVar, aVar, e2, map, dVar, dVar, this.A, this.t, this.G, this.H);
        this.l.setDisplayErrorDialogContent(this.f42863h);
        this.l.setTimeOut(this.D);
        this.l.setRetryCount(this.C);
        this.l.setRetryPolicy(new DefaultRetryPolicy());
        this.l.setShouldDisplayErrorAfterParsing(this.v);
        if (!TextUtils.isEmpty(this.f42861f)) {
            this.l.setRequestBodyContentType(this.f42861f);
        }
        if (!TextUtils.isEmpty(this.f42862g)) {
            this.l.setVolleyCacheKey(this.f42862g);
        }
        Object obj = this.j;
        if (obj != null) {
            this.l.setTag(obj);
        }
        q.d("performNetworkRequest " + this.l);
        if (com.paytm.network.b.b.a(this.m)) {
            q.d("performNetworkRequest making api call for url ".concat(String.valueOf(e2)));
            this.l.getmMatricesEventListener().f42961b = System.currentTimeMillis();
            a(this.m, this.l, this.B, this.j, f42856e);
            return;
        }
        q.d("performNetworkRequest no internet connection ".concat(String.valueOf(e2)));
        a("No Network");
    }

    private void a(Map<String, String> map) {
        Context context = this.m;
        if (context != null) {
            this.F = com.paytm.network.b.d.a(context);
            map.put(this.E, this.F);
        }
    }

    private void a(String str) {
        NetworkCustomVolleyError networkCustomVolleyError = new NetworkCustomVolleyError(str);
        networkCustomVolleyError.setErrorType(NetworkCustomError.ErrorType.NoConnectionError);
        d dVar = this.B;
        if (dVar != null) {
            dVar.onErrorResponse(networkCustomVolleyError);
        }
    }

    public final void b() {
        c cVar = this.l;
        if (cVar != null) {
            cVar.cancel();
        }
    }

    public final void a(Object obj) {
        c cVar = this.l;
        if (!(cVar == null || obj == null)) {
            cVar.setTag(obj);
        }
        this.j = obj;
    }

    public final Object c() {
        c cVar = this.l;
        if (cVar != null) {
            return cVar.getTag();
        }
        return null;
    }

    private static void a(Context context, c cVar, d dVar, Object obj, boolean z2) {
        String url = cVar.getUrl();
        i.c(url);
        if (i.d(url)) {
            q.d("Throttle Limit Reached, not making api call for url : ".concat(String.valueOf(url)));
            NetworkCustomVolleyError networkCustomVolleyError = new NetworkCustomVolleyError(H5BridgeContext.INVALID_ID);
            networkCustomVolleyError.setErrorType(NetworkCustomError.ErrorType.ApiCallLimitExceededError);
            if (dVar != null) {
                dVar.onErrorResponse(networkCustomVolleyError);
            }
        }
        f.a(context, cVar, obj, z2);
    }

    private String e() {
        try {
            Uri.Builder buildUpon = Uri.parse(this.q).buildUpon();
            Map<String, String> b2 = com.paytm.utility.c.b(this.m, false);
            if (this.p != null) {
                buildUpon.appendEncodedPath(this.p);
            }
            a(buildUpon, this.r);
            if (this.f42859c) {
                a(buildUpon, b2);
            }
            return buildUpon.build().toString();
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    private static void a(Uri.Builder builder, Map<String, String> map) {
        if (builder != null && map != null) {
            for (String next : map.keySet()) {
                builder.appendQueryParameter(next, URLEncoder.encode(map.get(next)));
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (this.G) {
            com.paytm.network.a.a.a.a(new m(new PaytmCommonApiSuccessModel(this.u, iJRPaytmDataModel)));
            return;
        }
        com.paytm.network.listener.b bVar = this.u;
        if (bVar != null) {
            bVar.onApiSuccess(iJRPaytmDataModel);
        }
    }

    class d implements Response.ErrorListener, Response.Listener<IJRPaytmDataModel> {
        private d() {
        }

        /* synthetic */ d(a aVar, byte b2) {
            this();
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
            q.d("onResponse " + a.this.l + " model " + iJRPaytmDataModel);
            if (a.this.l == null || !a.this.l.isCanceled()) {
                a.this.a(iJRPaytmDataModel);
                if (a.this.f42858b == C0715a.GET && !a.this.f42860d) {
                    a aVar = a.this;
                    a.a(aVar, aVar.q, iJRPaytmDataModel);
                }
                if (iJRPaytmDataModel != null && iJRPaytmDataModel.getNetworkResponse() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("screen_name", a.this.y);
                    if (!TextUtils.isEmpty(a.this.z)) {
                        hashMap.put("subVerticalName", a.this.z);
                    }
                    NetworkResponse networkResponse = iJRPaytmDataModel.getNetworkResponse();
                    int i2 = iJRPaytmDataModel.getNetworkResponse().statusCode;
                    hashMap.put(a.this.E, a.this.F);
                    if (i.f() != null) {
                        j f2 = i.f();
                        Context h2 = a.this.m;
                        String c2 = a.this.q;
                        String unused = a.this.t;
                        f2.a(h2, i2, c2, iJRPaytmDataModel.getNetworkResponse().networkTimeMs, networkResponse, a.this.x, (HashMap<String, String>) hashMap, a.this.f42857a, a.this.l.getmMatricesEventListener() == null ? null : a.this.l.getmMatricesEventListener().a(), i.g());
                        com.paytm.network.listener.a aVar2 = a.this.l.getmMatricesEventListener();
                        aVar2.f42960a.setTotalRoundTripTime(iJRPaytmDataModel.getNetworkResponse().networkTimeMs + aVar2.f42960a.getRequestWaitTime());
                    }
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:68:0x0212  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x021b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onErrorResponse(com.android.volley.VolleyError r23) {
            /*
                r22 = this;
                r1 = r22
                r0 = r23
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "onErrorResponse "
                r2.<init>(r3)
                com.paytm.network.a r4 = com.paytm.network.a.this
                com.paytm.network.c r4 = r4.l
                r2.append(r4)
                java.lang.String r4 = " volleyError "
                r2.append(r4)
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                com.paytm.utility.q.d(r2)
                com.paytm.network.a r2 = com.paytm.network.a.this
                com.paytm.network.c r2 = r2.l
                if (r2 == 0) goto L_0x003d
                com.paytm.network.a r2 = com.paytm.network.a.this
                com.paytm.network.c r2 = r2.l
                boolean r2 = r2.isCanceled()
                if (r2 == 0) goto L_0x003d
                java.lang.String r0 = "request is cancelled "
                com.paytm.utility.q.d(r0)
                return
            L_0x003d:
                r2 = -1
                com.paytm.network.model.NetworkCustomError r4 = new com.paytm.network.model.NetworkCustomError
                java.lang.String r5 = r23.getMessage()
                r4.<init>((java.lang.String) r5)
                com.paytm.network.model.NetworkCustomError$ErrorType r5 = com.paytm.network.model.NetworkCustomError.ErrorType.NetworkError
                r6 = 401(0x191, float:5.62E-43)
                com.paytm.network.a r7 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                android.content.Context r7 = r7.m     // Catch:{ Exception -> 0x01ec }
                android.content.res.Resources r7 = r7.getResources()     // Catch:{ Exception -> 0x01ec }
                int r8 = com.paytm.networkmodule.R.string.error_dialog_title     // Catch:{ Exception -> 0x01ec }
                java.lang.String r7 = r7.getString(r8)     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a r8 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                android.content.Context r8 = r8.m     // Catch:{ Exception -> 0x01ec }
                android.content.res.Resources r8 = r8.getResources()     // Catch:{ Exception -> 0x01ec }
                int r9 = com.paytm.networkmodule.R.string.error_dialog_body     // Catch:{ Exception -> 0x01ec }
                java.lang.String r8 = r8.getString(r9)     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a r9 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                java.lang.String r9 = r9.q     // Catch:{ Exception -> 0x01ec }
                r4.setUrl(r9)     // Catch:{ Exception -> 0x01ec }
                r4.setmAlertTitle(r8)     // Catch:{ Exception -> 0x01ec }
                r4.setAlertMessage(r7)     // Catch:{ Exception -> 0x01ec }
                r7 = 0
                if (r0 == 0) goto L_0x0080
                com.android.volley.NetworkResponse r8 = r0.networkResponse     // Catch:{ Exception -> 0x01ec }
                goto L_0x0081
            L_0x0080:
                r8 = r7
            L_0x0081:
                if (r0 == 0) goto L_0x0093
                boolean r9 = r0 instanceof com.paytm.network.model.NetworkCustomVolleyError     // Catch:{ Exception -> 0x01ec }
                if (r9 == 0) goto L_0x0093
                r5 = r0
                com.paytm.network.model.NetworkCustomVolleyError r5 = (com.paytm.network.model.NetworkCustomVolleyError) r5     // Catch:{ Exception -> 0x01ec }
                com.android.volley.NetworkResponse r8 = r5.networkResponse     // Catch:{ Exception -> 0x01ec }
                r5 = r0
                com.paytm.network.model.NetworkCustomVolleyError r5 = (com.paytm.network.model.NetworkCustomVolleyError) r5     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.model.NetworkCustomError$ErrorType r5 = r5.getErrorType()     // Catch:{ Exception -> 0x01ec }
            L_0x0093:
                java.util.HashMap r15 = new java.util.HashMap     // Catch:{ Exception -> 0x01ec }
                r15.<init>()     // Catch:{ Exception -> 0x01ec }
                java.lang.String r9 = "screen_name"
                com.paytm.network.a r10 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                java.lang.String r10 = r10.y     // Catch:{ Exception -> 0x01ec }
                r15.put(r9, r10)     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a r9 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                java.lang.String r9 = r9.z     // Catch:{ Exception -> 0x01ec }
                boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x01ec }
                if (r9 != 0) goto L_0x00bb
                java.lang.String r9 = "subVerticalName"
                com.paytm.network.a r10 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                java.lang.String r10 = r10.z     // Catch:{ Exception -> 0x01ec }
                r15.put(r9, r10)     // Catch:{ Exception -> 0x01ec }
            L_0x00bb:
                if (r8 == 0) goto L_0x00c6
                int r2 = r8.statusCode     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.model.NetworkResponse r8 = com.paytm.network.b.i.a((com.android.volley.NetworkResponse) r8)     // Catch:{ Exception -> 0x01ec }
                r4.setNetworkResponse(r8)     // Catch:{ Exception -> 0x01ec }
            L_0x00c6:
                r8 = 403(0x193, float:5.65E-43)
                if (r2 != r8) goto L_0x00d5
                r4.setStatusCode(r6)     // Catch:{ Exception -> 0x00d0 }
                r2 = 401(0x191, float:5.62E-43)
                goto L_0x00d5
            L_0x00d0:
                r0 = move-exception
                r2 = 401(0x191, float:5.62E-43)
                goto L_0x01ed
            L_0x00d5:
                com.paytm.network.a r6 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                java.lang.String r6 = r6.E     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a r8 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                java.lang.String r8 = r8.F     // Catch:{ Exception -> 0x01ec }
                r15.put(r6, r8)     // Catch:{ Exception -> 0x01ec }
                boolean r6 = r0 instanceof com.android.volley.AuthFailureError     // Catch:{ Exception -> 0x01ec }
                if (r6 == 0) goto L_0x00eb
                com.paytm.network.model.NetworkCustomError$ErrorType r5 = com.paytm.network.model.NetworkCustomError.ErrorType.AuthFailureError     // Catch:{ Exception -> 0x01ec }
                goto L_0x00ff
            L_0x00eb:
                boolean r6 = r0 instanceof com.android.volley.ServerError     // Catch:{ Exception -> 0x01ec }
                if (r6 == 0) goto L_0x00f2
                com.paytm.network.model.NetworkCustomError$ErrorType r5 = com.paytm.network.model.NetworkCustomError.ErrorType.ServerError     // Catch:{ Exception -> 0x01ec }
                goto L_0x00ff
            L_0x00f2:
                boolean r6 = r0 instanceof com.android.volley.TimeoutError     // Catch:{ Exception -> 0x01ec }
                if (r6 == 0) goto L_0x00f9
                com.paytm.network.model.NetworkCustomError$ErrorType r5 = com.paytm.network.model.NetworkCustomError.ErrorType.TimeOutError     // Catch:{ Exception -> 0x01ec }
                goto L_0x00ff
            L_0x00f9:
                boolean r6 = r0 instanceof com.android.volley.NoConnectionError     // Catch:{ Exception -> 0x01ec }
                if (r6 == 0) goto L_0x00ff
                com.paytm.network.model.NetworkCustomError$ErrorType r5 = com.paytm.network.model.NetworkCustomError.ErrorType.NoConnectionError     // Catch:{ Exception -> 0x01ec }
            L_0x00ff:
                r4.setErrorType(r5)     // Catch:{ Exception -> 0x01ec }
                if (r5 == 0) goto L_0x0109
                java.lang.String r5 = r5.name()     // Catch:{ Exception -> 0x01ec }
                goto L_0x010a
            L_0x0109:
                r5 = r7
            L_0x010a:
                java.lang.String r6 = r23.getMessage()     // Catch:{ Exception -> 0x01ec }
                boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x01ec }
                if (r6 != 0) goto L_0x0118
                java.lang.String r5 = r23.getMessage()     // Catch:{ Exception -> 0x01ec }
            L_0x0118:
                com.paytm.network.a r6 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                java.lang.String r6 = r6.q     // Catch:{ Exception -> 0x01ec }
                byte r6 = com.paytm.network.errorlogging.a.a(r6, r5)     // Catch:{ Exception -> 0x01ec }
                java.lang.String r8 = "Logging Type : "
                java.lang.String r9 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x01ec }
                java.lang.String r8 = r8.concat(r9)     // Catch:{ Exception -> 0x01ec }
                com.paytm.utility.q.d(r8)     // Catch:{ Exception -> 0x01ec }
                r8 = 1
                if (r6 != r8) goto L_0x018e
                com.paytm.network.j r6 = com.paytm.network.b.i.f()     // Catch:{ Exception -> 0x01ec }
                if (r6 == 0) goto L_0x01f4
                com.paytm.network.j r9 = com.paytm.network.b.i.f()     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a r6 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                android.content.Context r10 = r6.m     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a r6 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                java.lang.String r12 = r6.q     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a r6 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                java.lang.String r13 = r6.t     // Catch:{ Exception -> 0x01ec }
                long r16 = r23.getNetworkTimeMs()     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a r0 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a$b r0 = r0.x     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a r6 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a$c r6 = r6.f42857a     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a r8 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.c r8 = r8.l     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.listener.a r8 = r8.getmMatricesEventListener()     // Catch:{ Exception -> 0x01ec }
                if (r8 != 0) goto L_0x016b
            L_0x0168:
                r20 = r7
                goto L_0x017a
            L_0x016b:
                com.paytm.network.a r7 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.c r7 = r7.l     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.listener.a r7 = r7.getmMatricesEventListener()     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.model.ConnectionMatrices r7 = r7.a()     // Catch:{ Exception -> 0x01ec }
                goto L_0x0168
            L_0x017a:
                com.paytm.network.a r7 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                java.util.Map unused = r7.s     // Catch:{ Exception -> 0x01ec }
                r11 = r2
                r14 = r5
                r7 = r15
                r15 = r16
                r17 = r0
                r18 = r7
                r19 = r6
                r9.a((android.content.Context) r10, (int) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (long) r15, (com.paytm.network.a.b) r17, (java.util.HashMap<java.lang.String, java.lang.String>) r18, (com.paytm.network.a.c) r19, (com.paytm.network.model.ConnectionMatrices) r20)     // Catch:{ Exception -> 0x01ec }
                goto L_0x01f4
            L_0x018e:
                r7 = r15
                r8 = 2
                if (r6 != r8) goto L_0x01e9
                com.paytm.network.a r6 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                android.content.Context r9 = r6.m     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a r6 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                java.lang.String r11 = r6.q     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a r6 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                java.lang.String r12 = r6.t     // Catch:{ Exception -> 0x01ec }
                long r14 = r23.getNetworkTimeMs()     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a r0 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a$b r16 = r0.x     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a r0 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a$c r0 = r0.f42857a     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a r6 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.c r6 = r6.l     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.listener.a r6 = r6.getmMatricesEventListener()     // Catch:{ Exception -> 0x01ec }
                if (r6 == 0) goto L_0x01cb
                com.paytm.network.a r6 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.c r6 = r6.l     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.listener.a r6 = r6.getmMatricesEventListener()     // Catch:{ Exception -> 0x01ec }
                r6.a()     // Catch:{ Exception -> 0x01ec }
            L_0x01cb:
                com.paytm.network.a r6 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.c r6 = r6.l     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.listener.a r19 = r6.getmMatricesEventListener()     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.j r20 = com.paytm.network.b.i.f()     // Catch:{ Exception -> 0x01ec }
                com.paytm.network.a r6 = com.paytm.network.a.this     // Catch:{ Exception -> 0x01ec }
                java.util.Map r21 = r6.s     // Catch:{ Exception -> 0x01ec }
                r10 = r2
                r13 = r5
                r17 = r7
                r18 = r0
                com.paytm.network.errorlogging.a.a(r9, r10, r11, r12, r13, r14, r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x01ec }
                goto L_0x01f4
            L_0x01e9:
                com.paytm.network.errorlogging.a.f42925a = r5     // Catch:{ Exception -> 0x01ec }
                goto L_0x01f4
            L_0x01ec:
                r0 = move-exception
            L_0x01ed:
                java.lang.String r0 = r0.getMessage()
                com.paytm.utility.q.b(r0)
            L_0x01f4:
                com.paytm.network.a r0 = com.paytm.network.a.this
                android.content.Context r0 = r0.m
                com.paytm.network.model.CJRError r0 = com.paytm.network.b.f.a((android.content.Context) r0, (com.paytm.network.model.NetworkCustomError) r4)
                java.lang.String r5 = r0.getTitle()
                r4.setmAlertTitle(r5)
                java.lang.String r0 = r0.getMessage()
                r4.setAlertMessage(r0)
                com.paytm.network.model.NetworkCustomError$ErrorType r0 = r4.getErrorType()
                if (r0 == 0) goto L_0x021b
                com.paytm.network.model.NetworkCustomError$ErrorType r0 = r4.getErrorType()
                java.lang.String r0 = r0.name()
                goto L_0x021d
            L_0x021b:
                java.lang.String r0 = ""
            L_0x021d:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>(r3)
                com.paytm.network.a r3 = com.paytm.network.a.this
                com.paytm.network.c r3 = r3.l
                r5.append(r3)
                java.lang.String r3 = " errorType "
                r5.append(r3)
                r5.append(r0)
                java.lang.String r0 = " status code "
                r5.append(r0)
                r5.append(r2)
                java.lang.String r0 = r5.toString()
                com.paytm.utility.q.d(r0)
                com.paytm.network.a r0 = com.paytm.network.a.this
                com.paytm.network.listener.b r0 = r0.u
                com.paytm.network.a r3 = com.paytm.network.a.this
                com.paytm.network.model.IJRPaytmDataModel r3 = r3.A
                r0.handleErrorCode(r2, r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.network.a.d.onErrorResponse(com.android.volley.VolleyError):void");
        }
    }

    static /* synthetic */ void a(a aVar, String str, IJRPaytmDataModel iJRPaytmDataModel) {
        if (str != null && iJRPaytmDataModel != null) {
            String a2 = a(str, aVar.p, aVar.r);
            if (aVar.f42858b == C0715a.GET && a2 != null && iJRPaytmDataModel != null) {
                i.a(a2, iJRPaytmDataModel);
            }
        }
    }
}
