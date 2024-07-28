package net.one97.paytm.phoenix.provider;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.android.volley.toolbox.HttpClientStack;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.phoenix.model.PhoenixHTTPRequestProviderModel;
import net.one97.paytm.phoenix.provider.PhoenixHttpProvider;
import net.one97.paytm.phoenix.util.m;

public final class PhoenixHTTPRequestProvider implements PhoenixHttpProvider {
    /* access modifiers changed from: private */
    public final String TAG;

    public PhoenixHTTPRequestProvider() {
        String name = PhoenixHTTPRequestProvider.class.getName();
        k.a((Object) name, "PhoenixHTTPRequestProvider::class.java.name");
        this.TAG = name;
    }

    public final void performRequest(String str, String str2, Map<String, String> map, String str3, Integer num, Context context, PhoenixHttpProvider.PhoenixHttpResponseListener phoenixHttpResponseListener, Boolean bool) {
        Class<?> cls;
        Class<?> cls2;
        k.c(phoenixHttpResponseListener, Payload.RESPONSE);
        a.C0715a requestType = getRequestType(str3);
        m mVar = new m();
        b phoenixHTTPRequestProvider$performRequest$request$1 = new PhoenixHTTPRequestProvider$performRequest$request$1(this, phoenixHttpResponseListener);
        IJRPaytmDataModel phoenixHTTPRequestProviderModel = new PhoenixHTTPRequestProviderModel();
        a.c cVar = a.c.H5;
        a.b bVar = a.b.USER_FACING;
        if (bool == null) {
            k.a();
        }
        String str4 = null;
        if (!bool.booleanValue()) {
            com.paytm.network.b a2 = new com.paytm.network.b().a(context).a(cVar).a(requestType).a(bVar);
            if (!(context == null || (cls2 = context.getClass()) == null)) {
                str4 = cls2.getSimpleName();
            }
            com.paytm.network.b a3 = a2.c(str4).a(str).a(false).a(phoenixHTTPRequestProviderModel).a(phoenixHTTPRequestProvider$performRequest$request$1);
            k.a((Object) a3, "CJRCommonNetworkCallBuil…mmonApiListener(listener)");
            mVar.f19891a = a3;
        } else {
            com.paytm.network.b a4 = new com.paytm.network.b().a(context).a(cVar).a(requestType).a(bVar);
            if (!(context == null || (cls = context.getClass()) == null)) {
                str4 = cls.getSimpleName();
            }
            com.paytm.network.b a5 = a4.c(str4).a(str).a(phoenixHTTPRequestProviderModel).a(phoenixHTTPRequestProvider$performRequest$request$1);
            k.a((Object) a5, "CJRCommonNetworkCallBuil…mmonApiListener(listener)");
            mVar.f19891a = a5;
        }
        if (map != null) {
            com.paytm.network.b bVar2 = mVar.f19891a;
            if (bVar2 == null) {
                k.a("networkCallBuilder");
            }
            bVar2.a(map);
        }
        if (!TextUtils.isEmpty(str2)) {
            com.paytm.network.b bVar3 = mVar.f19891a;
            if (bVar3 == null) {
                k.a("networkCallBuilder");
            }
            bVar3.b(str2);
        }
        com.paytm.network.b bVar4 = mVar.f19891a;
        if (bVar4 == null) {
            k.a("networkCallBuilder");
        }
        a l = bVar4.l();
        if (l != null) {
            l.a();
        }
    }

    private final a.C0715a getRequestType(String str) {
        if (p.a(str, H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD, true)) {
            return a.C0715a.GET;
        }
        if (p.a(str, "POST", true)) {
            return a.C0715a.POST;
        }
        if (p.a(str, "PUT", true)) {
            return a.C0715a.PUT;
        }
        if (p.a(str, "DELETE", true)) {
            return a.C0715a.DELETE;
        }
        if (p.a(str, "HEAD", true)) {
            return a.C0715a.HEAD;
        }
        if (p.a(str, "OPTIONS", true)) {
            return a.C0715a.OPTIONS;
        }
        if (p.a(str, "TRACE", true)) {
            return a.C0715a.TRACE;
        }
        if (p.a(str, HttpClientStack.HttpPatch.METHOD_NAME, true)) {
            return a.C0715a.PATCH;
        }
        return null;
    }
}
