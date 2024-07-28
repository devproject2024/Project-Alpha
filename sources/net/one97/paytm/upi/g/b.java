package net.one97.paytm.upi.g;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.f;
import com.paytm.utility.k;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.g.g;
import net.one97.paytm.upi.util.GzipUtils;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public class b extends Request<UpiBaseDataModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Response.Listener<UpiBaseDataModel> f66950a;

    /* renamed from: b  reason: collision with root package name */
    private final f f66951b;

    /* renamed from: c  reason: collision with root package name */
    private UpiBaseDataModel f66952c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, String> f66953d;

    /* renamed from: e  reason: collision with root package name */
    private String f66954e;

    /* renamed from: f  reason: collision with root package name */
    private Response.ErrorListener f66955f;

    /* renamed from: g  reason: collision with root package name */
    private String f66956g;

    /* renamed from: h  reason: collision with root package name */
    private String f66957h;

    /* renamed from: i  reason: collision with root package name */
    private Map<String, String> f66958i;

    public /* synthetic */ void deliverResponse(Object obj) {
        this.f66950a.onResponse((UpiBaseDataModel) obj);
    }

    public b(String str, Response.Listener<UpiBaseDataModel> listener, Response.ErrorListener errorListener, UpiBaseDataModel upiBaseDataModel, Map<String, String> map, Map<String, String> map2, String str2) {
        this(str, listener, errorListener, upiBaseDataModel, map, map2, str2, (byte) 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public b(String str, Response.Listener<UpiBaseDataModel> listener, Response.ErrorListener errorListener, UpiBaseDataModel upiBaseDataModel, Map<String, String> map, Map<String, String> map2, String str2, byte b2) {
        this(str, listener, errorListener, upiBaseDataModel, map, map2, str2, 0);
        System.currentTimeMillis();
    }

    private b(final String str, Response.Listener<UpiBaseDataModel> listener, final Response.ErrorListener errorListener, UpiBaseDataModel upiBaseDataModel, Map<String, String> map, Map<String, String> map2, String str2, char c2) {
        super(1, str, new Response.ErrorListener() {
            public final void onErrorResponse(VolleyError volleyError) {
                NetworkResponse networkResponse = volleyError.networkResponse;
                UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError(String.valueOf(volleyError.networkResponse));
                upiCustomVolleyError.setUrl(str);
                upiCustomVolleyError.setmErrorCode(String.valueOf(volleyError.networkResponse.statusCode));
                errorListener.onErrorResponse(upiCustomVolleyError);
                if (networkResponse != null) {
                    try {
                        String str = networkResponse.headers.get("Content-Encoding");
                        String str2 = networkResponse.data != null ? (str == null || !str.equals("gzip")) ? new String(networkResponse.data) : GzipUtils.convertString(GzipUtils.convertReader(networkResponse.data)) : "";
                        if (!k.b()) {
                            g.b bVar = new g.b();
                            bVar.a(networkResponse.statusCode);
                            bVar.b(UpiAppUtils.removeParams(str));
                            bVar.a(String.valueOf(volleyError.getNetworkTimeMs()));
                            if (UpiGTMLoader.getInstance().isIncludeResponse()) {
                                bVar.c(str2);
                            }
                            g.a(bVar, "error");
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    throw volleyError;
                }
            }
        });
        this.f66954e = b.class.getName();
        this.f66950a = listener;
        this.f66955f = errorListener;
        this.f66952c = upiBaseDataModel;
        this.f66951b = new f();
        this.f66953d = map2;
        this.f66956g = str;
        this.f66957h = str2;
        this.f66958i = map;
        PaytmLogs.d(this.f66954e, str);
        Map<String, String> map3 = this.f66953d;
        if (map3 != null) {
            PaytmLogs.d(this.f66954e, map3.toString());
        }
        PaytmLogs.d(this.f66954e, str2);
    }

    public Response<UpiBaseDataModel> parseNetworkResponse(NetworkResponse networkResponse) {
        String str;
        String str2 = "";
        try {
            String str3 = networkResponse.headers.get("Content-Encoding");
            if (networkResponse.data != null) {
                str = (str3 == null || !str3.equals("gzip")) ? new String(networkResponse.data) : GzipUtils.convertString(GzipUtils.convertReader(networkResponse.data));
                str2 = new JSONObject(str).toString(4);
                PaytmLogs.d(this.f66954e, "=====response======".concat(String.valueOf(str2)));
                return Response.success(this.f66951b.a(str, this.f66952c.getClass()), HttpHeaderParser.parseCacheHeaders(networkResponse));
            }
        } catch (Exception unused) {
            this.f66955f.onErrorResponse(new UpiCustomVolleyError());
        }
        str = str2;
        try {
            str2 = new JSONObject(str).toString(4);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        PaytmLogs.d(this.f66954e, "=====response======".concat(String.valueOf(str2)));
        return Response.success(this.f66951b.a(str, this.f66952c.getClass()), HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    public void deliverError(VolleyError volleyError) {
        NetworkResponse networkResponse = volleyError.networkResponse;
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError(volleyError.networkResponse, (networkResponse == null || networkResponse.data == null) ? "" : new String(networkResponse.data));
        try {
            if (this.f66955f != null && (volleyError instanceof UpiCustomVolleyError)) {
                upiCustomVolleyError.setUrl(((UpiCustomVolleyError) volleyError).getUrl());
            }
            if (volleyError.networkResponse != null) {
                upiCustomVolleyError.setmErrorCode(String.valueOf(volleyError.networkResponse.statusCode));
            } else {
                upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
            }
            this.f66955f.onErrorResponse(upiCustomVolleyError);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        return super.setRetryPolicy(new DefaultRetryPolicy(60000, 1, 1.0f));
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        if (this.f66953d == null) {
            this.f66953d = new HashMap();
        }
        this.f66953d.put("Accept-Encoding", "gzip");
        Map<String, String> map = this.f66953d;
        return map != null ? map : super.getHeaders();
    }

    public byte[] getBody() throws AuthFailureError {
        try {
            if (this.f66957h == null) {
                return null;
            }
            return this.f66957h.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> map = this.f66958i;
        return map != null ? map : super.getParams();
    }
}
