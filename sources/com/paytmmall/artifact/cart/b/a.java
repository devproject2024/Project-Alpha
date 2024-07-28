package com.paytmmall.artifact.cart.b;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.appsflyer.share.Constants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.artifact.cart.c.b;
import com.paytmmall.artifact.cart.entity.StringModel;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.d.g;
import com.paytmmall.artifact.d.l;
import com.paytmmall.artifact.d.v;
import com.paytmmall.b.a;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    b f15510a;

    /* renamed from: b  reason: collision with root package name */
    Context f15511b;

    public a(Context context) {
        this.f15511b = context;
    }

    public final void a(b bVar, String str, String str2, String str3) {
        this.f15510a = bVar;
        JSONObject a2 = a(str, str3);
        if (URLUtil.isValidUrl(str2)) {
            com.paytmmall.b.a.a(this.f15511b, a.C0216a.POST, str2, a2.toString(), b(), new StringModel(), new com.paytmmall.b.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    String data = ((StringModel) iJRPaytmDataModel).getData();
                    if (!TextUtils.isEmpty(data)) {
                        v.a().a(a.this.f15511b, data);
                        a.this.f15510a.b();
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    a.this.f15510a.a(networkCustomError);
                }
            });
        }
    }

    private HashMap<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        return d.a((HashMap<String, String>) hashMap, this.f15511b);
    }

    private static JSONObject a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str2) && !str2.endsWith(Constants.URL_MEDIA_SOURCE)) {
            str2 = str2 + Constants.URL_MEDIA_SOURCE;
        }
        try {
            jSONObject.put("action", "cancelpromo");
            new JSONObject().put(str2, str);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str2);
            jSONObject.put("removed_item", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final String a() {
        String b2 = l.b();
        if (b2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        com.paytmmall.artifact.common.a.a.a();
        sb.append(com.paytmmall.artifact.common.a.a.a("cartv2", (String) null));
        sb.append("/");
        sb.append(b2);
        String sb2 = sb.toString();
        String a2 = g.a(this.f15511b);
        return sb2 + a2;
    }

    public final void a(String str, final b bVar, String str2, String str3) {
        b(str, str3);
        String str4 = str2;
        com.paytmmall.b.a.a(this.f15511b, a.C0216a.POST, str4, b(str, str3).toString(), b(), new StringModel(), new com.paytmmall.b.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                String data = ((StringModel) iJRPaytmDataModel).getData();
                if (!TextUtils.isEmpty(data)) {
                    v a2 = v.a();
                    a2.a(a.this.f15511b, data);
                    bVar.a((IJRPaytmDataModel) a2.f15746a);
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                bVar.b(networkCustomError);
            }
        });
    }

    private static JSONObject b(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str2) && !str2.endsWith(Constants.URL_MEDIA_SOURCE)) {
            str2 = str2 + Constants.URL_MEDIA_SOURCE;
        }
        try {
            jSONObject.put("action", "applypromo");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put(str2, str);
            }
            if (str2 == null && !TextUtils.isEmpty(str)) {
                jSONObject.put("globalcode", str.toUpperCase());
            }
            jSONObject.put("item_map", jSONObject2);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
