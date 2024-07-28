package net.one97.paytm.paymentsBank.chequebook.utils;

import android.content.Context;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gsonhtcfix.f;
import com.paytm.network.b.i;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomVolleyError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class j extends Request<IJRPaytmDataModel> {

    /* renamed from: b  reason: collision with root package name */
    private static final String f17983b = j.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    DataOutputStream f17984a;

    /* renamed from: c  reason: collision with root package name */
    private final Response.Listener<IJRPaytmDataModel> f17985c;

    /* renamed from: d  reason: collision with root package name */
    private final Response.ErrorListener f17986d;

    /* renamed from: e  reason: collision with root package name */
    private final String f17987e = "WebKitFormBoundarynrHfHHBqL64QHPve";

    /* renamed from: f  reason: collision with root package name */
    private final String f17988f = "multipart/form-data; boundary=WebKitFormBoundarynrHfHHBqL64QHPve";

    /* renamed from: g  reason: collision with root package name */
    private Map<String, String> f17989g;

    /* renamed from: h  reason: collision with root package name */
    private Context f17990h;

    /* renamed from: i  reason: collision with root package name */
    private f f17991i;
    private final int j = AppConstants.NOT_TIME;
    private Map<String, File> k;
    private Map<String, String> l;
    private final String m = "--";
    private final String n = "\r\n";
    private final String o = "WebKitFormBoundarynrHfHHBqL64QHPve";
    private IJRPaytmDataModel p;

    public String getBodyContentType() {
        return "multipart/form-data; boundary=WebKitFormBoundarynrHfHHBqL64QHPve";
    }

    public /* synthetic */ void deliverResponse(Object obj) {
        this.f17985c.onResponse((IJRPaytmDataModel) obj);
    }

    public j(Context context, String str, Response.ErrorListener errorListener, Response.Listener<IJRPaytmDataModel> listener, IJRPaytmDataModel iJRPaytmDataModel, Map<String, File> map, Map<String, String> map2) {
        super(1, str, errorListener);
        this.f17985c = listener;
        this.f17986d = errorListener;
        this.f17990h = context;
        this.k = map;
        this.l = null;
        this.f17989g = map2;
        this.p = iJRPaytmDataModel;
        this.f17991i = new f();
        setRetryPolicy(new DefaultRetryPolicy(AppConstants.NOT_TIME, 1, 1.0f));
    }

    public j(Context context, String str, Response.ErrorListener errorListener, Response.Listener<IJRPaytmDataModel> listener, IJRPaytmDataModel iJRPaytmDataModel, Map<String, File> map, Map<String, String> map2, byte b2) {
        super(2, str, errorListener);
        this.f17985c = listener;
        this.f17986d = errorListener;
        this.f17990h = context;
        this.k = map;
        this.l = null;
        this.f17989g = map2;
        this.p = iJRPaytmDataModel;
        this.f17991i = new f();
        setRetryPolicy(new DefaultRetryPolicy(AppConstants.NOT_TIME, 1, 1.0f));
    }

    public byte[] getBody() throws AuthFailureError {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f17984a = new DataOutputStream(byteArrayOutputStream);
        try {
            for (Map.Entry next : this.k.entrySet()) {
                a((String) next.getKey(), (File) next.getValue());
            }
            this.f17984a.writeBytes("--WebKitFormBoundarynrHfHHBqL64QHPve--\r\n");
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void a(String str, File file) throws IOException {
        PrintWriter printWriter = new PrintWriter(this.f17984a, true);
        String name = file != null ? file.getName() : "";
        printWriter.append("--WebKitFormBoundarynrHfHHBqL64QHPve").append("\r\n");
        printWriter.append("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + name + "\"").append("\r\n");
        StringBuilder sb = new StringBuilder("Content-Type: ");
        sb.append(URLConnection.guessContentTypeFromName(name));
        printWriter.append(sb.toString()).append("\r\n");
        printWriter.append("Content-Transfer-Encoding: binary").append("\r\n");
        printWriter.append("\r\n");
        printWriter.flush();
        if (file != null) {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                this.f17984a.write(bArr, 0, read);
            }
            this.f17984a.flush();
            fileInputStream.close();
        }
        printWriter.append("\r\n");
        printWriter.flush();
    }

    public Response<IJRPaytmDataModel> parseNetworkResponse(NetworkResponse networkResponse) {
        if (networkResponse != null) {
            try {
                if (networkResponse.statusCode == 410) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(networkResponse.statusCode);
                    return Response.error(new NetworkCustomVolleyError(networkResponse, sb.toString()));
                }
            } catch (UnsupportedEncodingException e2) {
                return Response.error(new ParseError((Throwable) e2));
            } catch (Exception e3) {
                e3.printStackTrace();
                return Response.error(new NetworkCustomVolleyError(networkResponse));
            }
        }
        if (networkResponse != null) {
            this.p = (IJRPaytmDataModel) this.f17991i.a(new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers)), this.p.getClass());
            this.p.setNetworkResponse(i.a(networkResponse));
        }
        return Response.success(this.p, getCacheEntry());
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> map = this.f17989g;
        if (map == null || map.equals(Collections.emptyMap())) {
            map = new HashMap<>();
        }
        map.put("Connection", "keep-alive");
        map.put("Content-Type", "multipart/form-data; boundary=WebKitFormBoundarynrHfHHBqL64QHPve");
        return map;
    }

    public void deliverError(VolleyError volleyError) {
        this.f17986d.onErrorResponse(volleyError);
    }
}
