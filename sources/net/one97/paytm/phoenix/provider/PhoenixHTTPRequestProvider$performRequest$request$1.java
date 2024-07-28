package net.one97.paytm.phoenix.provider;

import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.d;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.phoenix.model.PhoenixHTTPRequestProviderModel;
import net.one97.paytm.phoenix.provider.PhoenixHttpProvider;
import org.json.JSONObject;

public final class PhoenixHTTPRequestProvider$performRequest$request$1 implements b {
    final /* synthetic */ PhoenixHttpProvider.PhoenixHttpResponseListener $response;
    final /* synthetic */ PhoenixHTTPRequestProvider this$0;

    PhoenixHTTPRequestProvider$performRequest$request$1(PhoenixHTTPRequestProvider phoenixHTTPRequestProvider, PhoenixHttpProvider.PhoenixHttpResponseListener phoenixHttpResponseListener) {
        this.this$0 = phoenixHTTPRequestProvider;
        this.$response = phoenixHttpResponseListener;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        k.c(iJRPaytmDataModel, "dataModel");
        String unused = this.this$0.TAG;
        q.a("PhoenixHTTPRequestProvider:True");
        PhoenixHTTPRequestProviderModel phoenixHTTPRequestProviderModel = (PhoenixHTTPRequestProviderModel) iJRPaytmDataModel;
        HashMap hashMap = new HashMap();
        Map<String, String> map = phoenixHTTPRequestProviderModel.getNetworkResponse().headers;
        for (String next : map.keySet()) {
            Map map2 = hashMap;
            k.a((Object) next, "key");
            List a2 = kotlin.a.k.a(map.get(next));
            if (a2 != null) {
                map2.put(next, a2);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            }
        }
        this.$response.onResponse(phoenixHTTPRequestProviderModel.getNetworkResponse().statusCode, "Success", phoenixHTTPRequestProviderModel.getResponseRaw(), hashMap);
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
        k.c(networkCustomError, "networkCustomError");
        String unused = this.this$0.TAG;
        q.d("PhoenixHTTPRequestProvider:False");
        HashMap hashMap = new HashMap();
        NetworkResponse networkResponse = networkCustomError.networkResponse;
        byte[] bArr = null;
        Map<String, String> map = networkResponse != null ? networkResponse.headers : null;
        if (map != null) {
            for (String next : map.keySet()) {
                Map map2 = hashMap;
                k.a((Object) next, "key");
                List a2 = kotlin.a.k.a(map.get(next));
                if (a2 != null) {
                    map2.put(next, a2);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                }
            }
        }
        NetworkResponse networkResponse2 = networkCustomError.networkResponse;
        if (networkResponse2 != null) {
            bArr = networkResponse2.data;
        }
        JSONObject jSONObject = new JSONObject();
        if (bArr != null) {
            String str = new String(bArr, d.f47971a);
            String unused2 = this.this$0.TAG;
            q.d("byteArray string: ".concat(str));
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                try {
                    x xVar = x.f47997a;
                    jSONObject = jSONObject2;
                } catch (Exception e2) {
                    JSONObject jSONObject3 = jSONObject2;
                    e = e2;
                    jSONObject = jSONObject3;
                    String unused3 = this.this$0.TAG;
                    q.d("exception while parsing data: " + e.getMessage());
                    jSONObject.put("error", "wrong data format");
                    this.$response.onResponse(i2, networkCustomError.mErrorType.toString(), jSONObject.toString(), hashMap);
                }
            } catch (Exception e3) {
                e = e3;
                String unused4 = this.this$0.TAG;
                q.d("exception while parsing data: " + e.getMessage());
                jSONObject.put("error", "wrong data format");
                this.$response.onResponse(i2, networkCustomError.mErrorType.toString(), jSONObject.toString(), hashMap);
            }
        }
        this.$response.onResponse(i2, networkCustomError.mErrorType.toString(), jSONObject.toString(), hashMap);
    }
}
