package net.one97.paytm.nativesdk.NetworkHandler;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.f;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.GzipUtils;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import org.json.JSONObject;

public class VolleyPostRequest extends Request {
    private static final String PROTOCOL_CHARSET = "utf-8";
    private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", new Object[]{PROTOCOL_CHARSET});
    private final String TAG = VolleyPostRequest.class.getName();
    private Class classType;
    private Response.ErrorListener mErrorListener;
    private Map<String, String> mHeaders;
    private boolean mIsFromHawkEye = false;
    private Response.Listener mListener;
    private Map<String, String> mParams;
    private final String mRequestBody;
    private String mUrl;
    private Request.Priority requestPriority;
    private String resultCode;
    private long startTime;

    public int compareTo(Object obj) {
        return 0;
    }

    public VolleyError parseNetworkError(VolleyError volleyError) {
        return volleyError;
    }

    public VolleyPostRequest(int i2, String str, Map<String, String> map, Map<String, String> map2, String str2, Response.Listener listener, Response.ErrorListener errorListener) {
        super(i2, str, errorListener);
        this.mHeaders = map;
        this.mRequestBody = str2;
        this.mParams = map2;
        this.mUrl = str;
        this.mListener = listener;
        this.mErrorListener = errorListener;
        this.startTime = System.currentTimeMillis();
    }

    public VolleyPostRequest(int i2, String str, Map<String, String> map, Map<String, String> map2, String str2, Response.Listener listener, Response.ErrorListener errorListener, Class cls) {
        super(i2, str, errorListener);
        this.mHeaders = map;
        this.mRequestBody = str2;
        this.mParams = map2;
        this.mUrl = str;
        this.mListener = listener;
        this.classType = cls;
        this.mErrorListener = errorListener;
        this.startTime = System.currentTimeMillis();
        LogUtility.d(this.TAG, "====request====".concat(String.valueOf(str2)));
        LogUtility.d(this.TAG, "=======url====".concat(String.valueOf(str)));
        setRetryPolicy(new DefaultRetryPolicy(0, 1, 1.0f));
    }

    public Response parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            String str = networkResponse.headers.get("Content-Encoding");
            String str2 = networkResponse.data != null ? (str == null || !str.equals("gzip")) ? new String(networkResponse.data) : GzipUtils.convertString(GzipUtils.convertReader(networkResponse.data)) : "";
            if (!this.mIsFromHawkEye) {
                getStatusCode(str2);
            }
            LogUtility.d(this.TAG, "=====response======".concat(String.valueOf(str2)));
            if (this.classType == String.class) {
                return Response.success(str2, HttpHeaderParser.parseCacheHeaders(networkResponse));
            }
            return Response.success(new f().a(str2, this.classType), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Exception e2) {
            LogUtility.d("VolleyPostRequest", e2.toString());
            return Response.error(new CustomVolleyError(networkResponse, this.mUrl, e2.getLocalizedMessage()));
        }
    }

    public void deliverResponse(Object obj) {
        try {
            if (this.mListener != null) {
                this.mListener.onResponse(obj);
                if (!this.mIsFromHawkEye) {
                    HawkEyeEvent.getInstance(PaytmSDK.getAppContext()).logApiEvent(false, this.mUrl, this.startTime, String.valueOf(System.currentTimeMillis() - this.startTime), Integer.parseInt(this.resultCode));
                }
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> map = this.mParams;
        return map != null ? map : super.getParams();
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        if (this.mHeaders == null) {
            this.mHeaders = new HashMap();
        }
        this.mHeaders.put("Accept-Encoding", "gzip");
        Map<String, String> map = this.mHeaders;
        return map != null ? map : super.getHeaders();
    }

    public byte[] getBody() throws AuthFailureError {
        try {
            return this.mRequestBody == null ? super.getBody() : this.mRequestBody.getBytes(PROTOCOL_CHARSET);
        } catch (UnsupportedEncodingException unused) {
            return super.getBody();
        }
    }

    public String getBodyContentType() {
        try {
            return getParams() != null ? "application/x-www-form-urlencoded" : PROTOCOL_CONTENT_TYPE;
        } catch (AuthFailureError e2) {
            LogUtility.printStackTrace(e2);
            return PROTOCOL_CONTENT_TYPE;
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00ac */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b7 A[Catch:{ Exception -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00dd A[Catch:{ Exception -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f0 A[Catch:{ Exception -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void deliverError(com.android.volley.VolleyError r12) {
        /*
            r11 = this;
            com.android.volley.NetworkResponse r0 = r12.networkResponse
            boolean r1 = r12 instanceof com.android.volley.TimeoutError
            if (r1 == 0) goto L_0x0038
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r3 = "screenName"
            java.lang.String r4 = "payment-gateway"
            r2.put(r3, r4)
            java.lang.String r3 = "event_category"
            java.lang.String r4 = "payment_gateway"
            r2.put(r3, r4)
            net.one97.paytm.nativesdk.DirectPaymentBL r3 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r3 = r3.getVerticalName()
            java.lang.String r4 = "vertical_name"
            r2.put(r4, r3)
            java.lang.String r3 = "event_action"
            java.lang.String r4 = "api_timeout"
            r2.put(r3, r4)
            java.lang.String r3 = r11.mUrl
            java.lang.String r4 = "event_label"
            r2.put(r4, r3)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r2)
        L_0x0038:
            java.lang.String r2 = ""
            r3 = 0
            if (r1 == 0) goto L_0x006e
            net.one97.paytm.nativesdk.DirectPaymentBL r1 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            boolean r1 = r1.isToCreateOrderPaytmSdk()
            if (r1 == 0) goto L_0x006e
            net.one97.paytm.nativesdk.common.model.CustomVolleyError r1 = new net.one97.paytm.nativesdk.common.model.CustomVolleyError     // Catch:{ Exception -> 0x0066 }
            com.android.volley.NetworkResponse r4 = r12.networkResponse     // Catch:{ Exception -> 0x0066 }
            java.lang.String r5 = r11.mUrl     // Catch:{ Exception -> 0x0066 }
            r1.<init>(r4, r5, r2)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r3 = "NETWORK_ERROR"
            r1.setErrorMsg(r3)     // Catch:{ Exception -> 0x0064 }
            com.android.volley.Response$ErrorListener r3 = r11.mErrorListener     // Catch:{ Exception -> 0x0064 }
            if (r3 == 0) goto L_0x0063
            com.android.volley.Response$ErrorListener r3 = r11.mErrorListener     // Catch:{ Exception -> 0x0064 }
            net.one97.paytm.nativesdk.common.model.CustomVolleyError r4 = new net.one97.paytm.nativesdk.common.model.CustomVolleyError     // Catch:{ Exception -> 0x0064 }
            r4.<init>()     // Catch:{ Exception -> 0x0064 }
            r3.onErrorResponse(r4)     // Catch:{ Exception -> 0x0064 }
        L_0x0063:
            return
        L_0x0064:
            r3 = move-exception
            goto L_0x006a
        L_0x0066:
            r1 = move-exception
            r10 = r3
            r3 = r1
            r1 = r10
        L_0x006a:
            net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r3)
            goto L_0x006f
        L_0x006e:
            r1 = r3
        L_0x006f:
            if (r0 == 0) goto L_0x00ce
            byte[] r3 = r0.data
            if (r3 == 0) goto L_0x00ce
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x00cd }
            byte[] r4 = r0.data     // Catch:{ Exception -> 0x00cd }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00cd }
            boolean r2 = r11.mIsFromHawkEye     // Catch:{ Exception -> 0x00cb }
            if (r2 != 0) goto L_0x0086
            int r2 = r0.statusCode     // Catch:{ Exception -> 0x00cb }
            r4 = 401(0x191, float:5.62E-43)
            if (r2 == r4) goto L_0x009e
        L_0x0086:
            int r2 = r0.statusCode     // Catch:{ Exception -> 0x00cb }
            r4 = 410(0x19a, float:5.75E-43)
            if (r2 == r4) goto L_0x009e
            int r2 = r0.statusCode     // Catch:{ Exception -> 0x00cb }
            r4 = 480(0x1e0, float:6.73E-43)
            if (r2 == r4) goto L_0x009e
            int r2 = r0.statusCode     // Catch:{ Exception -> 0x00cb }
            r4 = 753(0x2f1, float:1.055E-42)
            if (r2 == r4) goto L_0x009e
            int r2 = r0.statusCode     // Catch:{ Exception -> 0x00cb }
            r4 = 403(0x193, float:5.65E-43)
            if (r2 != r4) goto L_0x00cb
        L_0x009e:
            net.one97.paytm.nativesdk.common.model.CustomVolleyError r2 = new net.one97.paytm.nativesdk.common.model.CustomVolleyError     // Catch:{ Exception -> 0x00cb }
            int r0 = r0.statusCode     // Catch:{ Exception -> 0x00cb }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x00cb }
            r2.<init>(r0)     // Catch:{ Exception -> 0x00cb }
            r2.setErrorMsg(r3)     // Catch:{ Exception -> 0x00ac }
        L_0x00ac:
            java.lang.String r0 = r11.mUrl     // Catch:{ Exception -> 0x00ca }
            r2.setUrl(r0)     // Catch:{ Exception -> 0x00ca }
            net.one97.paytm.nativesdk.app.PaytmSDKCallbackListener r0 = net.one97.paytm.nativesdk.PaytmSDK.getCallbackListener()     // Catch:{ Exception -> 0x00ca }
            if (r0 == 0) goto L_0x00ca
            android.app.Activity r0 = net.one97.paytm.nativesdk.Utils.SDKUtility.getTopActivity()     // Catch:{ Exception -> 0x00ca }
            boolean r1 = r0 instanceof net.one97.paytm.nativesdk.instruments.InstrumentActivity     // Catch:{ Exception -> 0x00ca }
            if (r1 == 0) goto L_0x00ca
            r0.finish()     // Catch:{ Exception -> 0x00ca }
            net.one97.paytm.nativesdk.app.PaytmSDKCallbackListener r0 = net.one97.paytm.nativesdk.PaytmSDK.getCallbackListener()     // Catch:{ Exception -> 0x00ca }
            r0.onSessionExpire(r2)     // Catch:{ Exception -> 0x00ca }
            return
        L_0x00ca:
            r1 = r2
        L_0x00cb:
            r2 = r3
            goto L_0x00ce
        L_0x00cd:
        L_0x00ce:
            if (r1 != 0) goto L_0x00d9
            net.one97.paytm.nativesdk.common.model.CustomVolleyError r1 = new net.one97.paytm.nativesdk.common.model.CustomVolleyError
            com.android.volley.NetworkResponse r0 = r12.networkResponse
            java.lang.String r3 = r11.mUrl
            r1.<init>(r0, r3, r2)
        L_0x00d9:
            com.android.volley.Response$ErrorListener r0 = r11.mErrorListener     // Catch:{ Exception -> 0x0110 }
            if (r0 == 0) goto L_0x00e2
            com.android.volley.Response$ErrorListener r0 = r11.mErrorListener     // Catch:{ Exception -> 0x0110 }
            r0.onErrorResponse(r1)     // Catch:{ Exception -> 0x0110 }
        L_0x00e2:
            boolean r0 = r11.mIsFromHawkEye     // Catch:{ Exception -> 0x0110 }
            if (r0 != 0) goto L_0x010f
            com.android.volley.NetworkResponse r0 = r12.networkResponse     // Catch:{ Exception -> 0x0110 }
            if (r0 == 0) goto L_0x010f
            com.android.volley.NetworkResponse r0 = r12.networkResponse     // Catch:{ Exception -> 0x0110 }
            byte[] r0 = r0.data     // Catch:{ Exception -> 0x0110 }
            if (r0 == 0) goto L_0x010f
            android.content.Context r0 = net.one97.paytm.nativesdk.PaytmSDK.getAppContext()     // Catch:{ Exception -> 0x0110 }
            net.one97.paytm.nativesdk.NetworkHandler.HawkEyeEvent r1 = net.one97.paytm.nativesdk.NetworkHandler.HawkEyeEvent.getInstance(r0)     // Catch:{ Exception -> 0x0110 }
            r2 = 1
            java.lang.String r3 = r11.mUrl     // Catch:{ Exception -> 0x0110 }
            long r4 = r11.startTime     // Catch:{ Exception -> 0x0110 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0110 }
            long r8 = r11.startTime     // Catch:{ Exception -> 0x0110 }
            long r6 = r6 - r8
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x0110 }
            com.android.volley.NetworkResponse r12 = r12.networkResponse     // Catch:{ Exception -> 0x0110 }
            int r7 = r12.statusCode     // Catch:{ Exception -> 0x0110 }
            r1.logApiEvent(r2, r3, r4, r6, r7)     // Catch:{ Exception -> 0x0110 }
        L_0x010f:
            return
        L_0x0110:
            r12 = move-exception
            net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest.deliverError(com.android.volley.VolleyError):void");
    }

    public Request.Priority getPriority() {
        Request.Priority priority = this.requestPriority;
        if (priority != null) {
            return priority;
        }
        return super.getPriority();
    }

    public void setRequestPriority(Request.Priority priority) {
        this.requestPriority = priority;
    }

    /* access modifiers changed from: package-private */
    public void setFromHawkEye() {
        this.mIsFromHawkEye = true;
    }

    private void getStatusCode(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("body")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("body");
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("resultInfo");
                    if (optJSONObject2 != null && optJSONObject2.has("resultCode")) {
                        this.resultCode = optJSONObject2.getString("resultCode");
                    } else if (optJSONObject2 == null || !optJSONObject2.has("code")) {
                        this.resultCode = "0000";
                    } else {
                        this.resultCode = optJSONObject2.getString("code");
                    }
                } else {
                    this.resultCode = "0000";
                }
            } else {
                this.resultCode = "0000";
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }
}
