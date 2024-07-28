package com.paytm.network;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.activity.AJRCommonNetworkDialogActivity;
import com.paytm.network.b.i;
import com.paytm.network.listener.a;
import com.paytm.network.model.CJRIllegalCodeError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomVolleyError;
import com.paytm.utility.q;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public class c extends Request<IJRPaytmDataModel> implements Handler.Callback, Serializable {
    private static final int DEFAULT_MAX_RETRIES = 0;
    public static final int DEFAULT_RETRY_COUNT = 1;
    public static final String EXCEPTION_NAME = "exception_name";
    public static final int MAX_RETRY_COUNT = 3;
    public static final int MIN_SOCKET_TIMEOUT_MS = 2500;
    public static final int MY_SOCKET_TIMEOUT_MS = 60000;
    public static final String OUT_OF_MEMORY_EXCEPTION = "out_of_memory_exception";
    private static final String PROTOCOL_CHARSET = "utf-8";
    private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", new Object[]{PROTOCOL_CHARSET});
    private static CopyOnWriteArrayList<Double> mApiTimingStack = new CopyOnWriteArrayList<>();
    private final int SHOW_DIALOG;
    private String TAG;
    private boolean cacheHit;
    private boolean forceReceiveUiThread;
    private boolean isDDEFound;
    private long mApiTime;
    private final Context mContext;
    private IJRPaytmDataModel mDataModel;
    private JSONObject mDisplayJsonObject;
    private final boolean mEnableHeaderCaching;
    private String mErrorCode;
    private String mErrorReportingAddress;
    private f mGson;
    private Handler mHandler;
    private Map<String, String> mHeaders;
    private Response.Listener<IJRPaytmDataModel> mListener;
    private a mMatricesEventListener;
    private String mMessage;
    private String mNegativeButtonText;
    private String mPositiveButtonText;
    private String mRequestBody;
    private String mRequestBodyContentType;
    private int mRetryCount;
    private boolean mShouldDisplayErrorAfterParsing;
    private int mTimeout;
    private String mUrl;
    private String mVolleyCacheKey;
    private String uniqueReference;
    private a.c verticalId;

    public int getTrafficStatsTag() {
        return super.getTrafficStatsTag();
    }

    /* access modifiers changed from: protected */
    public void deliverResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        if (this.forceReceiveUiThread) {
            this.mListener.onResponse(iJRPaytmDataModel);
        }
    }

    public void deliverError(VolleyError volleyError) {
        super.deliverError(volleyError);
    }

    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        return super.setRetryPolicy(new DefaultRetryPolicy(getTimeout(), getRetryCount(), 1.0f));
    }

    private int getRetryCount() {
        int i2 = this.mRetryCount;
        if (i2 < 0) {
            this.mRetryCount = 1;
        } else if (i2 > 3) {
            this.mRetryCount = 3;
        }
        q.d("getRetrycount returning " + this.mRetryCount);
        return this.mRetryCount;
    }

    public void setRetryCount(int i2) {
        this.mRetryCount = i2;
    }

    private int getTimeout() {
        int i2 = this.mTimeout;
        if (i2 == 0) {
            this.mTimeout = 60000;
        } else if (i2 < 2500) {
            this.mTimeout = 2500;
        }
        q.d("getRetrycount returning " + this.mTimeout);
        return this.mTimeout;
    }

    public void setTimeOut(int i2) {
        this.mTimeout = i2;
    }

    public c(Context context, a.c cVar, a.C0715a aVar, String str, Map<String, String> map, Response.Listener<IJRPaytmDataModel> listener, Response.ErrorListener errorListener, IJRPaytmDataModel iJRPaytmDataModel, String str2) {
        this(context, cVar, aVar, str, map, listener, errorListener, iJRPaytmDataModel, str2, true, true);
    }

    public c(Context context, a.c cVar, a.C0715a aVar, String str, Map<String, String> map, Response.Listener<IJRPaytmDataModel> listener, Response.ErrorListener errorListener, IJRPaytmDataModel iJRPaytmDataModel, String str2, boolean z, boolean z2) {
        super(aVar.value, str, errorListener);
        this.SHOW_DIALOG = 1;
        this.TAG = c.class.getName();
        this.uniqueReference = "";
        this.isDDEFound = false;
        this.mRetryCount = -1;
        this.cacheHit = false;
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.verticalId = cVar;
        this.mListener = listener;
        this.mHeaders = map;
        this.mDataModel = iJRPaytmDataModel;
        this.mRequestBody = str2;
        this.mUrl = str;
        this.mGson = new f();
        this.mContext = context;
        this.mApiTime = 0;
        this.mTimeout = 60000;
        this.mRetryCount = -1;
        if (i.e()) {
            this.mMatricesEventListener = new com.paytm.network.listener.a(str);
        }
        this.cacheHit = false;
        this.mApiTime = System.currentTimeMillis();
        this.forceReceiveUiThread = z;
        this.mEnableHeaderCaching = z2;
        q.d("startTime : " + this.mApiTime);
    }

    private String getMethodName(int i2) {
        for (a.C0715a aVar : a.C0715a.values()) {
            if (aVar.value == i2) {
                return aVar.name();
            }
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x0261  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.android.volley.Response<com.paytm.network.model.IJRPaytmDataModel> parseNetworkResponse(com.android.volley.NetworkResponse r19) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            boolean r0 = r1.cacheHit
            if (r0 != 0) goto L_0x0027
            long r3 = r1.mApiTime
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0027
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r0 = java.lang.String.valueOf(r3)
            java.lang.String r5 = "endTime : "
            java.lang.String r0 = r5.concat(r0)
            com.paytm.utility.q.d(r0)
            long r5 = r1.mApiTime
            long r3 = r3 - r5
            r1.updateNetworkSpeed(r3, r2)
        L_0x0027:
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.headers
            java.lang.String r3 = "Content-Encoding"
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
            if (r2 == 0) goto L_0x003f
            byte[] r4 = r2.data
            if (r4 == 0) goto L_0x003f
            java.lang.String r4 = new java.lang.String
            byte[] r5 = r2.data
            r4.<init>(r5)
            goto L_0x0041
        L_0x003f:
            java.lang.String r4 = "response is null"
        L_0x0041:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Time Taken For Api :- "
            r5.<init>(r6)
            java.lang.String r6 = r1.mUrl
            r5.append(r6)
            java.lang.String r6 = " Completion is :- "
            r5.append(r6)
            long r6 = r1.mApiTime
            r5.append(r6)
            java.lang.String r6 = " ms"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.paytm.utility.q.d(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "URL : Request Type :: "
            r5.<init>(r6)
            int r6 = r18.getMethod()
            java.lang.String r6 = r1.getMethodName(r6)
            r5.append(r6)
            java.lang.String r6 = "\n Header :: "
            r5.append(r6)
            java.util.Map<java.lang.String, java.lang.String> r6 = r1.mHeaders
            r5.append(r6)
            java.lang.String r6 = "\n URL ::"
            r5.append(r6)
            java.lang.String r6 = r1.mUrl
            r5.append(r6)
            java.lang.String r6 = "\n Body :: "
            r5.append(r6)
            java.lang.String r6 = r1.mRequestBody
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.paytm.utility.q.d(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Status Code :: "
            r5.<init>(r6)
            int r6 = r2.statusCode
            r5.append(r6)
            java.lang.String r6 = "\n response.data :: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = " encoding "
            r5.append(r4)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            com.paytm.utility.q.d(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "network speed :- "
            r0.<init>(r4)
            double r4 = com.paytm.network.b.i.g()
            r0.append(r4)
            java.lang.String r4 = " api time "
            r0.append(r4)
            long r4 = r1.mApiTime
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.paytm.utility.q.d(r0)
            int r6 = r2.statusCode
            com.paytm.network.model.NetworkCustomVolleyError r15 = new com.paytm.network.model.NetworkCustomVolleyError
            java.lang.String r0 = "parsing_error"
            r15.<init>((java.lang.String) r0, (com.android.volley.NetworkResponse) r2)
            android.content.Context r0 = r1.mContext
            android.content.res.Resources r0 = r0.getResources()
            int r4 = com.paytm.networkmodule.R.string.message_error_data_display
            java.lang.String r4 = r0.getString(r4)
            java.lang.String r0 = r1.mUrl     // Catch:{ Exception -> 0x0126 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0126 }
            if (r0 != 0) goto L_0x012e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0126 }
            r0.<init>()     // Catch:{ Exception -> 0x0126 }
            r0.append(r4)     // Catch:{ Exception -> 0x0126 }
            java.lang.String r5 = "("
            r0.append(r5)     // Catch:{ Exception -> 0x0126 }
            java.lang.String r5 = r1.mUrl     // Catch:{ Exception -> 0x0126 }
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x0126 }
            android.net.Uri$Builder r5 = r5.buildUpon()     // Catch:{ Exception -> 0x0126 }
            android.net.Uri$Builder r5 = r5.clearQuery()     // Catch:{ Exception -> 0x0126 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0126 }
            r0.append(r5)     // Catch:{ Exception -> 0x0126 }
            java.lang.String r5 = ")"
            r0.append(r5)     // Catch:{ Exception -> 0x0126 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0126 }
            r4 = r0
            goto L_0x012e
        L_0x0126:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x012e:
            android.content.Context r0 = r1.mContext
            android.content.res.Resources r0 = r0.getResources()
            int r5 = com.paytm.networkmodule.R.string.parse_error_title
            java.lang.String r14 = r0.getString(r5)
            android.content.Context r0 = r1.mContext
            android.content.res.Resources r0 = r0.getResources()
            int r5 = com.paytm.networkmodule.R.string.parse_error_body
            java.lang.String r13 = r0.getString(r5)
            android.content.Context r0 = r1.mContext
            android.content.res.Resources r0 = r0.getResources()
            int r5 = com.paytm.networkmodule.R.string.error_data_display
            java.lang.String r0 = r0.getString(r5)
            r15.setmAlertTitle(r0)
            r15.setAlertMessage(r4)
            java.lang.String r0 = r1.mUrl
            r15.setUrl(r0)
            java.lang.String r0 = r1.uniqueReference
            r15.setUniqueReference(r0)
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.headers     // Catch:{ Exception -> 0x0230 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x0230 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0230 }
            byte[] r3 = r2.data     // Catch:{ Exception -> 0x0230 }
            if (r3 == 0) goto L_0x0222
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ OutOfMemoryError -> 0x01e3 }
            if (r3 != 0) goto L_0x0187
            java.lang.String r3 = "gzip"
            boolean r0 = r0.equals(r3)     // Catch:{ OutOfMemoryError -> 0x01e3 }
            if (r0 == 0) goto L_0x0187
            byte[] r0 = r2.data     // Catch:{ OutOfMemoryError -> 0x01e3 }
            java.io.Reader r0 = com.paytm.network.b.g.a((byte[]) r0)     // Catch:{ OutOfMemoryError -> 0x01e3 }
            java.lang.String r0 = com.paytm.network.b.g.a((java.io.Reader) r0)     // Catch:{ OutOfMemoryError -> 0x01e3 }
            goto L_0x018e
        L_0x0187:
            java.lang.String r0 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x01e3 }
            byte[] r3 = r2.data     // Catch:{ OutOfMemoryError -> 0x01e3 }
            r0.<init>(r3)     // Catch:{ OutOfMemoryError -> 0x01e3 }
        L_0x018e:
            boolean r3 = com.google.a.a.a.o.a(r6)     // Catch:{ Exception -> 0x0230 }
            if (r3 != 0) goto L_0x01a9
            r3 = 304(0x130, float:4.26E-43)
            if (r6 != r3) goto L_0x0199
            goto L_0x01a9
        L_0x0199:
            java.lang.String r0 = "Fail - statusCode: "
            java.lang.String r2 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x0230 }
            java.lang.String r0 = r0.concat(r2)     // Catch:{ Exception -> 0x0230 }
            com.paytm.utility.q.d(r0)     // Catch:{ Exception -> 0x0230 }
            r3 = r15
            goto L_0x0274
        L_0x01a9:
            com.paytm.network.model.NetworkResponse r3 = com.paytm.network.b.i.a((com.android.volley.NetworkResponse) r19)     // Catch:{ Exception -> 0x0230 }
            com.paytm.network.model.IJRPaytmDataModel r4 = r1.mDataModel     // Catch:{ Exception -> 0x0230 }
            r4.setNetworkResponse(r3)     // Catch:{ Exception -> 0x0230 }
            com.paytm.network.model.IJRPaytmDataModel r4 = r1.mDataModel     // Catch:{ Exception -> 0x0230 }
            com.google.gsonhtcfix.f r5 = r1.mGson     // Catch:{ Exception -> 0x0230 }
            com.paytm.network.model.IJRPaytmDataModel r0 = r4.parseResponse(r0, r5)     // Catch:{ Exception -> 0x0230 }
            r1.mDataModel = r0     // Catch:{ Exception -> 0x0230 }
            com.paytm.network.model.IJRPaytmDataModel r0 = r1.mDataModel     // Catch:{ Exception -> 0x0230 }
            r0.setNetworkResponse(r3)     // Catch:{ Exception -> 0x0230 }
            boolean r0 = r1.forceReceiveUiThread     // Catch:{ Exception -> 0x0230 }
            if (r0 != 0) goto L_0x01cc
            com.android.volley.Response$Listener<com.paytm.network.model.IJRPaytmDataModel> r0 = r1.mListener     // Catch:{ Exception -> 0x0230 }
            com.paytm.network.model.IJRPaytmDataModel r3 = r1.mDataModel     // Catch:{ Exception -> 0x0230 }
            r0.onResponse(r3)     // Catch:{ Exception -> 0x0230 }
        L_0x01cc:
            boolean r0 = r1.mEnableHeaderCaching     // Catch:{ Exception -> 0x0230 }
            if (r0 == 0) goto L_0x01db
            com.paytm.network.model.IJRPaytmDataModel r0 = r1.mDataModel     // Catch:{ Exception -> 0x0230 }
            com.android.volley.Cache$Entry r2 = com.android.volley.toolbox.HttpHeaderParser.parseCacheHeaders(r19)     // Catch:{ Exception -> 0x0230 }
            com.android.volley.Response r0 = com.android.volley.Response.success(r0, r2)     // Catch:{ Exception -> 0x0230 }
            return r0
        L_0x01db:
            com.paytm.network.model.IJRPaytmDataModel r0 = r1.mDataModel     // Catch:{ Exception -> 0x0230 }
            r2 = 0
            com.android.volley.Response r0 = com.android.volley.Response.success(r0, r2)     // Catch:{ Exception -> 0x0230 }
            return r0
        L_0x01e3:
            r0 = move-exception
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x0230 }
            r2.<init>()     // Catch:{ Exception -> 0x0230 }
            java.lang.String r3 = "exception_name"
            java.lang.String r4 = "out_of_memory_exception"
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0230 }
            com.paytm.network.j r3 = com.paytm.network.b.i.f()     // Catch:{ Exception -> 0x0230 }
            if (r3 == 0) goto L_0x021d
            com.paytm.network.j r4 = com.paytm.network.b.i.f()     // Catch:{ Exception -> 0x0230 }
            android.content.Context r5 = r1.mContext     // Catch:{ Exception -> 0x0230 }
            java.lang.String r7 = r1.mUrl     // Catch:{ Exception -> 0x0230 }
            java.lang.String r8 = r1.mRequestBody     // Catch:{ Exception -> 0x0230 }
            java.lang.String r9 = r15.getMessage()     // Catch:{ Exception -> 0x0230 }
            long r10 = r15.getNetworkTimeMs()     // Catch:{ Exception -> 0x0230 }
            com.paytm.network.a$b r12 = com.paytm.network.a.b.SILENT     // Catch:{ Exception -> 0x0230 }
            com.paytm.network.a$c r3 = r1.verticalId     // Catch:{ Exception -> 0x0230 }
            r16 = 0
            r18.getHeaders()     // Catch:{ Exception -> 0x0230 }
            r17 = r13
            r13 = r2
            r2 = r14
            r14 = r3
            r3 = r15
            r15 = r16
            r4.a((android.content.Context) r5, (int) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (long) r10, (com.paytm.network.a.b) r12, (java.util.HashMap<java.lang.String, java.lang.String>) r13, (com.paytm.network.a.c) r14, (com.paytm.network.model.ConnectionMatrices) r15)     // Catch:{ Exception -> 0x022e }
            goto L_0x0221
        L_0x021d:
            r17 = r13
            r2 = r14
            r3 = r15
        L_0x0221:
            throw r0     // Catch:{ Exception -> 0x022e }
        L_0x0222:
            r17 = r13
            r2 = r14
            r3 = r15
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x022e }
            java.lang.String r4 = ""
            r0.<init>(r4)     // Catch:{ Exception -> 0x022e }
            throw r0     // Catch:{ Exception -> 0x022e }
        L_0x022e:
            r0 = move-exception
            goto L_0x0235
        L_0x0230:
            r0 = move-exception
            r17 = r13
            r2 = r14
            r3 = r15
        L_0x0235:
            java.lang.String r4 = r0.getMessage()
            com.paytm.utility.q.b(r4)
            boolean r4 = r0 instanceof com.google.gsonhtcfix.p
            if (r4 != 0) goto L_0x0244
            boolean r0 = r0 instanceof org.json.JSONException
            if (r0 == 0) goto L_0x0274
        L_0x0244:
            r3.setmAlertTitle(r2)
            r4 = r17
            r3.setAlertMessage(r4)
            com.paytm.network.model.NetworkCustomError$ErrorType r0 = com.paytm.network.model.NetworkCustomError.ErrorType.ParsingError
            r3.setErrorType(r0)
            r0 = 1
            r1.isDDEFound = r0
            int[] r5 = com.paytm.network.c.AnonymousClass1.f42905a
            com.paytm.network.a$c r6 = r1.verticalId
            int r6 = r6.ordinal()
            r5 = r5[r6]
            if (r5 == r0) goto L_0x0261
            goto L_0x0274
        L_0x0261:
            java.lang.String r0 = r3.getMessage()
            r1.mErrorCode = r0
            java.lang.String r0 = "error.bus@paytm.com"
            r1.mErrorReportingAddress = r0
            boolean r0 = r18.shouldDisplayErrorAfterParsing()
            if (r0 == 0) goto L_0x0274
            r1.displayDialog(r2, r4)
        L_0x0274:
            com.android.volley.Response r0 = com.android.volley.Response.error(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.network.c.parseNetworkResponse(com.android.volley.NetworkResponse):com.android.volley.Response");
    }

    /* renamed from: com.paytm.network.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f42905a = new int[a.c.values().length];

        static {
            try {
                f42905a[a.c.BUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void updateNetworkSpeed(long r6, com.android.volley.NetworkResponse r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            if (r8 == 0) goto L_0x000e
            byte[] r1 = r8.data     // Catch:{ all -> 0x000c }
            if (r1 == 0) goto L_0x000e
            byte[] r8 = r8.data     // Catch:{ all -> 0x000c }
            int r0 = r8.length     // Catch:{ all -> 0x000c }
            goto L_0x000e
        L_0x000c:
            r6 = move-exception
            goto L_0x0071
        L_0x000e:
            if (r0 == 0) goto L_0x0073
            r1 = 0
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 != 0) goto L_0x0017
            goto L_0x0073
        L_0x0017:
            double r1 = (double) r0
            double r3 = (double) r6
            double r1 = r1 / r3
            r3 = 4620693217682128896(0x4020000000000000, double:8.0)
            double r1 = r1 * r3
            r3 = 0
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x0026
            monitor-exit(r5)
            return
        L_0x0026:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x000c }
            java.lang.String r3 = "url : "
            r8.<init>(r3)     // Catch:{ all -> 0x000c }
            java.lang.String r3 = r5.mUrl     // Catch:{ all -> 0x000c }
            r8.append(r3)     // Catch:{ all -> 0x000c }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x000c }
            com.paytm.utility.q.d(r8)     // Catch:{ all -> 0x000c }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x000c }
            java.lang.String r3 = "time(msec) : "
            r8.<init>(r3)     // Catch:{ all -> 0x000c }
            r8.append(r6)     // Catch:{ all -> 0x000c }
            java.lang.String r6 = " size(bytes) : "
            r8.append(r6)     // Catch:{ all -> 0x000c }
            r8.append(r0)     // Catch:{ all -> 0x000c }
            java.lang.String r6 = " speed(Kbps) : "
            r8.append(r6)     // Catch:{ all -> 0x000c }
            r8.append(r1)     // Catch:{ all -> 0x000c }
            java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x000c }
            com.paytm.utility.q.d(r6)     // Catch:{ all -> 0x000c }
            r5.updateToStack(r1)     // Catch:{ all -> 0x000c }
            int r6 = r5.getStackSize()     // Catch:{ all -> 0x000c }
            r7 = 3
            if (r6 >= r7) goto L_0x0068
            monitor-exit(r5)
            return
        L_0x0068:
            double r6 = r5.getStackAverage()     // Catch:{ all -> 0x000c }
            com.paytm.network.b.i.a((double) r6)     // Catch:{ all -> 0x000c }
            monitor-exit(r5)
            return
        L_0x0071:
            monitor-exit(r5)
            throw r6
        L_0x0073:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.network.c.updateNetworkSpeed(long, com.android.volley.NetworkResponse):void");
    }

    private double getStackAverage() {
        Iterator<Double> it2 = mApiTimingStack.iterator();
        long j = 0;
        while (it2.hasNext()) {
            j = (long) (((double) j) + it2.next().doubleValue());
        }
        return (double) (j / 3);
    }

    private int getStackSize() {
        return mApiTimingStack.size();
    }

    private void updateToStack(double d2) {
        if (d2 > 0.0d) {
            if (getStackSize() >= 3) {
                mApiTimingStack.remove(0);
            }
            mApiTimingStack.add(Double.valueOf(d2));
        }
    }

    private Pair<NetworkCustomVolleyError, CJRIllegalCodeError> getVolleyError(String str, int i2) {
        CJRIllegalCodeError cJRIllegalCodeError;
        Exception e2;
        String str2;
        NetworkCustomVolleyError networkCustomVolleyError = new NetworkCustomVolleyError(String.valueOf(i2));
        networkCustomVolleyError.setUrl(this.mUrl);
        networkCustomVolleyError.setUniqueReference(this.uniqueReference);
        CJRIllegalCodeError cJRIllegalCodeError2 = new CJRIllegalCodeError();
        try {
            cJRIllegalCodeError = (CJRIllegalCodeError) this.mGson.a(str, cJRIllegalCodeError2.getClass());
            try {
                if (cJRIllegalCodeError.getAdditionalInfo() != null) {
                    if (cJRIllegalCodeError.getAdditionalInfo() == null) {
                        str2 = null;
                    } else {
                        str2 = cJRIllegalCodeError.getAdditionalInfo().getConfirmationFlag();
                    }
                    networkCustomVolleyError.setUniqueReference(str2);
                }
                if (!(cJRIllegalCodeError == null || cJRIllegalCodeError.getStatusError() == null || cJRIllegalCodeError.getStatusError().getmMessage() == null)) {
                    networkCustomVolleyError.setAlertMessage(cJRIllegalCodeError.getStatusError().getmMessage().getMessage());
                    networkCustomVolleyError.setmAlertTitle(cJRIllegalCodeError.getStatusError().getmMessage().getTitle());
                }
            } catch (Exception e3) {
                e2 = e3;
                q.b(e2.getMessage());
                return new Pair<>(networkCustomVolleyError, cJRIllegalCodeError);
            }
        } catch (Exception e4) {
            CJRIllegalCodeError cJRIllegalCodeError3 = cJRIllegalCodeError2;
            e2 = e4;
            cJRIllegalCodeError = cJRIllegalCodeError3;
            q.b(e2.getMessage());
            return new Pair<>(networkCustomVolleyError, cJRIllegalCodeError);
        }
        return new Pair<>(networkCustomVolleyError, cJRIllegalCodeError);
    }

    private boolean handleOtherStatusCodes(int i2, String str, String str2) {
        displayDialog(str, str2);
        return false;
    }

    private void displayDialog(String str, String str2) {
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("alert_title", str);
        bundle.putString("alert_message", str2);
        obtain.setData(bundle);
        obtain.what = 1;
        this.mHandler.sendMessage(obtain);
    }

    public Map<String, String> getHeaders() {
        try {
            if (this.mHeaders == null) {
                this.mHeaders = new HashMap();
            }
            this.mHeaders.put("Accept-Encoding", "gzip");
            return this.mHeaders != null ? this.mHeaders : super.getHeaders();
        } catch (AuthFailureError e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public byte[] getBody() throws AuthFailureError {
        try {
            if (this.mRequestBody == null) {
                return null;
            }
            return this.mRequestBody.getBytes(PROTOCOL_CHARSET);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public String getBodyContentType() {
        if (!TextUtils.isEmpty(this.mRequestBodyContentType)) {
            return this.mRequestBodyContentType;
        }
        return PROTOCOL_CONTENT_TYPE;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        String string = message.getData().getString("alert_title");
        String string2 = message.getData().getString("alert_message");
        JSONObject jSONObject = this.mDisplayJsonObject;
        String str = "";
        String jSONObject2 = jSONObject != null ? jSONObject.toString() : str;
        Context context = this.mContext;
        String str2 = this.mPositiveButtonText;
        String str3 = this.mNegativeButtonText;
        String str4 = this.mErrorCode;
        String str5 = this.mErrorReportingAddress;
        String str6 = this.mUrl;
        boolean z = this.isDDEFound;
        if (context == null || TextUtils.isEmpty(string2)) {
            return false;
        }
        Intent intent = new Intent(context, AJRCommonNetworkDialogActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("alert_title", string);
        intent.putExtra("alert_message", string2);
        intent.putExtra("vertical_error_code", str4);
        intent.putExtra("vertical_email_id", str5);
        intent.putExtra("vertical_url", str6);
        intent.putExtra("dde_found", z);
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        }
        intent.putExtra("positive-button-text", str2);
        if (!TextUtils.isEmpty(str3)) {
            str = str3;
        }
        intent.putExtra("negative-button-text", str);
        intent.putExtra("should-display-title", true);
        intent.putExtra("display_error_content", jSONObject2);
        context.startActivity(intent);
        return false;
    }

    public void setDisplayErrorDialogContent(JSONObject jSONObject) {
        this.mDisplayJsonObject = jSONObject;
    }

    public String getUniqueReference() {
        return this.uniqueReference;
    }

    public void setUniqueReference(String str) {
        this.uniqueReference = str;
    }

    public boolean shouldDisplayErrorAfterParsing() {
        return this.mShouldDisplayErrorAfterParsing;
    }

    public void setShouldDisplayErrorAfterParsing(boolean z) {
        this.mShouldDisplayErrorAfterParsing = z;
    }

    public String getCacheKey() {
        if (!TextUtils.isEmpty(this.mVolleyCacheKey)) {
            return this.mVolleyCacheKey;
        }
        return getkey(this.mUrl);
    }

    private static String getkey(String str) {
        try {
            return Uri.parse(str).buildUpon().clearQuery().build().toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public void setVolleyCacheKey(String str) {
        this.mVolleyCacheKey = str;
    }

    public void setRequestBodyContentType(String str) {
        this.mRequestBodyContentType = str;
    }

    public com.paytm.network.listener.a getmMatricesEventListener() {
        return this.mMatricesEventListener;
    }

    public void addMarker(String str) {
        super.addMarker(str);
        if ("cache-hit".equals(str)) {
            this.cacheHit = true;
            q.d("served from cache : ".concat(String.valueOf(str)));
        }
    }
}
