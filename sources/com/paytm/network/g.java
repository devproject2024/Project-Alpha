package com.paytm.network;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.a.a.a.o;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.p;
import com.paytm.network.a;
import com.paytm.network.b.i;
import com.paytm.network.model.ConnectionMatrices;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkCustomVolleyError;
import com.paytm.networkmodule.R;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public final class g extends Request<IJRPaytmDataModel> {

    /* renamed from: a  reason: collision with root package name */
    DataOutputStream f42939a;

    /* renamed from: b  reason: collision with root package name */
    Response.ErrorListener f42940b;

    /* renamed from: c  reason: collision with root package name */
    private final f f42941c;

    /* renamed from: d  reason: collision with root package name */
    private final String f42942d;

    /* renamed from: e  reason: collision with root package name */
    private Response.Listener<IJRPaytmDataModel> f42943e;

    /* renamed from: f  reason: collision with root package name */
    private final String f42944f = "WebKitFormBoundarynrHfHHBqL64QHPve";

    /* renamed from: g  reason: collision with root package name */
    private final String f42945g = "multipart/form-data; boundary=WebKitFormBoundarynrHfHHBqL64QHPve";

    /* renamed from: h  reason: collision with root package name */
    private Map<String, String> f42946h;

    /* renamed from: i  reason: collision with root package name */
    private Context f42947i;
    private final int j = AppConstants.NOT_TIME;
    private Map<String, File> k;
    private Map<String, String> l;
    private final String m = "--";
    private final String n = "\r\n";
    private final String o = "WebKitFormBoundarynrHfHHBqL64QHPve";
    private IJRPaytmDataModel p;
    private boolean q;
    private a.c r;

    public final String getBodyContentType() {
        return "multipart/form-data; boundary=WebKitFormBoundarynrHfHHBqL64QHPve";
    }

    public final /* synthetic */ void deliverResponse(Object obj) {
        this.f42943e.onResponse((IJRPaytmDataModel) obj);
    }

    public g(Context context, int i2, String str, Response.Listener<IJRPaytmDataModel> listener, Response.ErrorListener errorListener, Map<String, File> map, Map<String, String> map2, Map<String, String> map3, IJRPaytmDataModel iJRPaytmDataModel, a.c cVar, boolean z) {
        super(i2, str, errorListener);
        this.f42943e = listener;
        this.f42947i = context;
        this.k = map;
        this.l = map2;
        this.f42946h = map3;
        this.f42940b = errorListener;
        this.p = iJRPaytmDataModel;
        this.r = cVar;
        this.q = z;
        this.f42941c = new f();
        this.f42942d = str;
        setRetryPolicy(new DefaultRetryPolicy(AppConstants.NOT_TIME, 1, 1.0f));
    }

    public final byte[] getBody() throws AuthFailureError {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f42939a = new DataOutputStream(byteArrayOutputStream);
        try {
            for (Map.Entry next : this.l.entrySet()) {
                this.f42939a.writeBytes("--WebKitFormBoundarynrHfHHBqL64QHPve\r\n");
                DataOutputStream dataOutputStream = this.f42939a;
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + ((String) next.getKey()) + "\"\r\n");
                this.f42939a.writeBytes("Content-Type: text/plain; charset=UTF-8\r\n");
                this.f42939a.writeBytes("\r\n");
                DataOutputStream dataOutputStream2 = this.f42939a;
                dataOutputStream2.writeBytes(((String) next.getValue()) + "\r\n");
            }
            for (Map.Entry next2 : this.k.entrySet()) {
                a((String) next2.getKey(), (File) next2.getValue());
            }
            this.f42939a.writeBytes("--WebKitFormBoundarynrHfHHBqL64QHPve--\r\n");
        } catch (IOException e2) {
            q.b(e2.getMessage());
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void a(String str, File file) throws IOException {
        PrintWriter printWriter = new PrintWriter(this.f42939a, true);
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
                this.f42939a.write(bArr, 0, read);
            }
            this.f42939a.flush();
            fileInputStream.close();
        }
        printWriter.append("\r\n");
        printWriter.flush();
    }

    public final Response<IJRPaytmDataModel> parseNetworkResponse(NetworkResponse networkResponse) {
        String str;
        String str2;
        String str3;
        NetworkResponse networkResponse2 = networkResponse;
        networkResponse2.headers.get("Content-Encoding");
        if (!(networkResponse2 == null || networkResponse2.data == null)) {
            new String(networkResponse2.data);
        }
        int i2 = networkResponse2.statusCode;
        q.d("GET URL " + getUrl());
        NetworkCustomVolleyError networkCustomVolleyError = new NetworkCustomVolleyError("parsing_error", networkResponse2);
        String string = this.f42947i.getResources().getString(R.string.message_error_data_display);
        try {
            if (!TextUtils.isEmpty(this.f42942d)) {
                string = string + "(" + Uri.parse(this.f42942d).buildUpon().clearQuery().toString() + ")";
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        String string2 = this.f42947i.getResources().getString(R.string.parse_error_title);
        String string3 = this.f42947i.getResources().getString(R.string.parse_error_body);
        networkCustomVolleyError.setmAlertTitle(this.f42947i.getResources().getString(R.string.error_data_display));
        networkCustomVolleyError.setAlertMessage(string);
        networkCustomVolleyError.setUrl(this.f42942d);
        try {
            String str4 = networkResponse2.headers.get("Content-Encoding");
            if (networkResponse2.data != null) {
                try {
                    if (TextUtils.isEmpty(str4) || !str4.equals("gzip")) {
                        str3 = new String(networkResponse2.data);
                    } else {
                        str3 = com.paytm.network.b.g.a(com.paytm.network.b.g.a(networkResponse2.data));
                    }
                    if (!o.a(i2)) {
                        if (i2 != 304) {
                            q.d("Fail - statusCode: ".concat(String.valueOf(i2)));
                            return Response.error(networkCustomVolleyError);
                        }
                    }
                    com.paytm.network.model.NetworkResponse a2 = i.a(networkResponse);
                    this.p.setNetworkResponse(a2);
                    this.p = this.p.parseResponse(str3, this.f42941c);
                    this.p.setNetworkResponse(a2);
                    if (!this.q) {
                        this.f42943e.onResponse(this.p);
                    }
                    return Response.success(this.p, HttpHeaderParser.parseCacheHeaders(networkResponse));
                } catch (OutOfMemoryError e3) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(c.EXCEPTION_NAME, c.OUT_OF_MEMORY_EXCEPTION);
                    if (i.f() != null) {
                        j f2 = i.f();
                        Context context = this.f42947i;
                        String str5 = this.f42942d;
                        String message = networkCustomVolleyError.getMessage();
                        long networkTimeMs = networkCustomVolleyError.getNetworkTimeMs();
                        a.b bVar = a.b.SILENT;
                        a.c cVar = this.r;
                        getHeaders();
                        str2 = string3;
                        HashMap hashMap2 = hashMap;
                        str = string2;
                        f2.a(context, i2, str5, "", message, networkTimeMs, bVar, (HashMap<String, String>) hashMap2, cVar, (ConnectionMatrices) null);
                    } else {
                        String str6 = string3;
                        String str7 = string2;
                    }
                    throw e3;
                } catch (Exception e4) {
                    e = e4;
                    q.b(e.getMessage());
                    if ((e instanceof p) || (e instanceof JSONException)) {
                        networkCustomVolleyError.setmAlertTitle(str);
                        networkCustomVolleyError.setAlertMessage(str2);
                        networkCustomVolleyError.setErrorType(NetworkCustomError.ErrorType.ParsingError);
                    }
                    return Response.error(networkCustomVolleyError);
                }
            } else {
                String str8 = string3;
                String str9 = string2;
                throw new IllegalArgumentException("");
            }
        } catch (Exception e5) {
            e = e5;
            str2 = string3;
            str = string2;
            q.b(e.getMessage());
            networkCustomVolleyError.setmAlertTitle(str);
            networkCustomVolleyError.setAlertMessage(str2);
            networkCustomVolleyError.setErrorType(NetworkCustomError.ErrorType.ParsingError);
            return Response.error(networkCustomVolleyError);
        }
    }

    public final Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> map = this.f42946h;
        if (map == null || map.equals(Collections.emptyMap())) {
            map = new HashMap<>();
        }
        map.put("Connection", "keep-alive");
        map.put("Content-Type", "multipart/form-data; boundary=WebKitFormBoundarynrHfHHBqL64QHPve");
        return map;
    }

    public final void deliverError(VolleyError volleyError) {
        this.f42940b.onErrorResponse(volleyError);
    }
}
