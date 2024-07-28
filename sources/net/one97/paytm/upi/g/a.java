package net.one97.paytm.upi.g;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
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

public class a extends Request<UpiBaseDataModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Response.Listener<UpiBaseDataModel> f66939a;

    /* renamed from: b  reason: collision with root package name */
    private final f f66940b;

    /* renamed from: c  reason: collision with root package name */
    private UpiBaseDataModel f66941c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, String> f66942d;

    /* renamed from: e  reason: collision with root package name */
    private String f66943e;

    /* renamed from: f  reason: collision with root package name */
    private Response.ErrorListener f66944f;

    /* renamed from: g  reason: collision with root package name */
    private String f66945g;

    /* renamed from: h  reason: collision with root package name */
    private String f66946h;

    /* renamed from: i  reason: collision with root package name */
    private String f66947i;

    public /* synthetic */ void deliverResponse(Object obj) {
        this.f66939a.onResponse((UpiBaseDataModel) obj);
    }

    public a(String str, Response.Listener<UpiBaseDataModel> listener, Response.ErrorListener errorListener, UpiBaseDataModel upiBaseDataModel, Map<String, String> map) {
        this(str, listener, errorListener, upiBaseDataModel, map, (String) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(String str, Response.Listener<UpiBaseDataModel> listener, Response.ErrorListener errorListener, UpiBaseDataModel upiBaseDataModel, Map<String, String> map, String str2) {
        this(str, listener, errorListener, upiBaseDataModel, map, str2, (byte) 0);
        System.currentTimeMillis();
    }

    private a(final String str, Response.Listener<UpiBaseDataModel> listener, final Response.ErrorListener errorListener, UpiBaseDataModel upiBaseDataModel, Map<String, String> map, String str2, byte b2) {
        super(0, str, new Response.ErrorListener() {
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
                            bVar.a(volleyError.networkResponse.statusCode);
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
        this.f66943e = a.class.getName();
        this.f66947i = "";
        this.f66939a = listener;
        this.f66944f = errorListener;
        this.f66941c = upiBaseDataModel;
        this.f66940b = new f();
        this.f66942d = map;
        this.f66945g = str;
        this.f66946h = str2;
        PaytmLogs.d(this.f66943e, this.f66945g);
        Map<String, String> map2 = this.f66942d;
        if (map2 != null) {
            PaytmLogs.d(this.f66943e, map2.toString());
        }
        PaytmLogs.d(this.f66943e, str2);
    }

    public Response<UpiBaseDataModel> parseNetworkResponse(NetworkResponse networkResponse) {
        String str;
        String str2 = "";
        try {
            String str3 = networkResponse.headers.get("Content-Encoding");
            if (networkResponse.data != null) {
                str = (str3 == null || !str3.equals("gzip")) ? new String(networkResponse.data) : GzipUtils.convertString(GzipUtils.convertReader(networkResponse.data));
                str2 = new JSONObject(str).toString(4);
                PaytmLogs.d(this.f66943e, "=====response======".concat(String.valueOf(str2)));
                return Response.success(this.f66940b.a(str, this.f66941c.getClass()), HttpHeaderParser.parseCacheHeaders(networkResponse));
            }
        } catch (Exception unused) {
            this.f66944f.onErrorResponse(new UpiCustomVolleyError());
        }
        str = str2;
        try {
            str2 = new JSONObject(str).toString(4);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        PaytmLogs.d(this.f66943e, "=====response======".concat(String.valueOf(str2)));
        return Response.success(this.f66940b.a(str, this.f66941c.getClass()), HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    public void deliverError(VolleyError volleyError) {
        NetworkResponse networkResponse = volleyError.networkResponse;
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError(volleyError.networkResponse, (networkResponse == null || networkResponse.data == null) ? "" : new String(networkResponse.data));
        try {
            if (this.f66944f != null) {
                if (volleyError instanceof UpiCustomVolleyError) {
                    upiCustomVolleyError.setUrl(((UpiCustomVolleyError) volleyError).getUrl());
                }
                int i2 = volleyError.networkResponse != null ? volleyError.networkResponse.statusCode : -1;
                if (i2 == -1 && (volleyError instanceof NetworkError)) {
                    i2 = Integer.parseInt(UpiConstants.NETWORK_ERROR_CODE);
                }
                upiCustomVolleyError.setmErrorCode(String.valueOf(i2));
                this.f66944f.onErrorResponse(upiCustomVolleyError);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        return super.setRetryPolicy(new DefaultRetryPolicy(60000, 1, 1.0f));
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        if (this.f66942d == null) {
            this.f66942d = new HashMap();
        }
        this.f66942d.put("Accept-Encoding", "gzip");
        Map<String, String> map = this.f66942d;
        return map != null ? map : super.getHeaders();
    }

    public byte[] getBody() throws AuthFailureError {
        try {
            if (this.f66946h == null) {
                return null;
            }
            return this.f66946h.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
