package net.one97.paytm.phoenix.d;

import android.text.TextUtils;
import android.util.Base64;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.business.merchant_payments.common.utility.AppConstants;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.data.H5EventHttpRequest;
import net.one97.paytm.phoenix.util.j;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class a extends net.one97.paytm.phoenix.core.a {
    public abstract void a(net.one97.paytm.phoenix.c.a.a aVar, boolean z, net.one97.paytm.phoenix.b.a aVar2) throws Exception;

    public a() {
        super("httpRequest", "paytmHttpRequest");
    }

    public boolean a(H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
        H5Event h5Event2 = h5Event;
        k.c(h5Event2, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        j jVar = j.f59646a;
        j.b("HttpRequestPlugin", "handleEvent");
        JSONObject params = h5Event.getParams();
        JSONObject jSONObject = null;
        String optString = params != null ? params.optString("url") : null;
        String optString2 = params != null ? params.optString("method") : null;
        Object opt = params != null ? params.opt("data") : null;
        Integer valueOf = params != null ? Integer.valueOf(params.optInt(H5RpcPlugin.RpcRequest.RpcParam.TIMEOUT)) : null;
        String optString3 = params != null ? params.optString("responseType") : null;
        String optString4 = params != null ? params.optString("responseCharset") : null;
        if (params != null) {
            jSONObject = params.optJSONObject("headers");
        }
        H5EventHttpRequest h5EventHttpRequest = new H5EventHttpRequest(optString, optString2, opt, valueOf, optString3, optString4, jSONObject);
        if (TextUtils.isEmpty(h5EventHttpRequest.getUrl())) {
            j jVar2 = j.f59646a;
            j.b("HttpRequestPlugin", "handleEvent fail");
            a(h5Event2, 2);
            return true;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        if (h5EventHttpRequest.getHeaders() != null && (jSONObject2 = h5EventHttpRequest.getHeaders()) == null) {
            k.a();
        }
        JSONObject jSONObject3 = jSONObject2;
        Map hashMap = new HashMap();
        hashMap.put("Accept-Charset", TextUtils.isEmpty(h5EventHttpRequest.getResponseCharset()) ? com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8 : h5EventHttpRequest.getResponseCharset());
        if (h5EventHttpRequest.getData() == null) {
            h5EventHttpRequest.setData(new JSONObject());
        }
        net.one97.paytm.phoenix.f.a.a().f59578b.execute(new C1150a(this, new net.one97.paytm.phoenix.c.a.a(h5EventHttpRequest.getUrl(), h5EventHttpRequest.getTimeout(), jSONArray, jSONObject3, hashMap, h5EventHttpRequest.getMethod(), String.valueOf(h5EventHttpRequest.getData())), h5EventHttpRequest, h5Event, bVar));
        return true;
    }

    /* renamed from: net.one97.paytm.phoenix.d.a$a  reason: collision with other inner class name */
    static final class C1150a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59425a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.c.a.a f59426b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5EventHttpRequest f59427c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ H5Event f59428d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.api.b f59429e;

        C1150a(a aVar, net.one97.paytm.phoenix.c.a.a aVar2, H5EventHttpRequest h5EventHttpRequest, H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
            this.f59425a = aVar;
            this.f59426b = aVar2;
            this.f59427c = h5EventHttpRequest;
            this.f59428d = h5Event;
            this.f59429e = bVar;
        }

        public final void run() {
            a aVar = this.f59425a;
            net.one97.paytm.phoenix.c.a.a aVar2 = this.f59426b;
            H5EventHttpRequest h5EventHttpRequest = this.f59427c;
            H5Event h5Event = this.f59428d;
            net.one97.paytm.phoenix.api.b bVar = this.f59429e;
            boolean z = true;
            try {
                JSONObject params = h5Event.getParams();
                Boolean bool = null;
                Boolean valueOf = params != null ? Boolean.valueOf(params.has("setDefaultParamsNeeded")) : null;
                if (valueOf == null) {
                    k.a();
                }
                if (valueOf.booleanValue()) {
                    JSONObject params2 = h5Event.getParams();
                    if (params2 != null) {
                        bool = Boolean.valueOf(params2.optBoolean("setDefaultParamsNeeded"));
                    }
                    if (bool == null) {
                        k.a();
                    }
                    z = bool.booleanValue();
                }
                aVar.a(aVar2, z, new b(aVar, h5EventHttpRequest, h5Event, bVar));
            } catch (Exception e2) {
                j jVar = j.f59646a;
                j.a("HttpRequestPlugin", "decode response", e2);
                aVar.a(h5Event, 12);
            }
        }
    }

    static final class b implements net.one97.paytm.phoenix.b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59430a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5EventHttpRequest f59431b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f59432c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.api.b f59433d;

        b(a aVar, H5EventHttpRequest h5EventHttpRequest, H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
            this.f59430a = aVar;
            this.f59431b = h5EventHttpRequest;
            this.f59432c = h5Event;
            this.f59433d = bVar;
        }

        public final void a(net.one97.paytm.phoenix.c.a.b bVar) {
            x.e eVar = new x.e();
            JSONObject jSONObject = new JSONObject();
            j jVar = j.f59646a;
            j.b("HttpRequestPlugin", "response=".concat(String.valueOf(bVar)));
            Integer num = bVar.f59393a;
            if (num != null) {
                jSONObject.put("status", num.intValue());
            }
            byte[] bArr = bVar.f59394b;
            if (bArr != null) {
                if (k.a((Object) ImagePickerUtils.IMAGE_PICKER_KEY_BASE_64, (Object) this.f59431b.getResponseType())) {
                    T encodeToString = Base64.encodeToString(bArr, 2);
                    k.a((Object) encodeToString, "Base64.encodeToString(it, 2)");
                    eVar.element = encodeToString;
                } else if (!TextUtils.isEmpty(this.f59431b.getResponseCharset())) {
                    Charset forName = Charset.forName(this.f59431b.getResponseCharset());
                    k.a((Object) forName, "Charset.forName(requestModel.responseCharset)");
                    eVar.element = new String(bArr, forName);
                } else {
                    eVar.element = new String(bArr, kotlin.m.d.f47971a);
                }
                jSONObject.put("data", (String) eVar.element);
            }
            Map<String, List<String>> map = bVar.f59395c;
            if (map != null && (!map.isEmpty())) {
                Map a2 = a.a(map);
                jSONObject.put("headersStr", a.b(a2));
                jSONObject.put("headers", new JSONObject(a2));
            }
            a aVar = this.f59430a;
            H5Event h5Event = this.f59432c;
            net.one97.paytm.phoenix.api.b bVar2 = this.f59433d;
            j jVar2 = j.f59646a;
            j.b("HttpRequestPlugin", "sendBridgeResult");
            net.one97.paytm.phoenix.f.a.a().f59579c.execute(new d(aVar, h5Event, jSONObject, bVar2));
        }
    }

    private final void b(H5Event h5Event) {
        j jVar = j.f59646a;
        j.b("HttpRequestPlugin", "sendBridgeResult");
        net.one97.paytm.phoenix.f.a.a().f59579c.execute(new c(this, h5Event));
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59434a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f59435b;

        c(a aVar, H5Event h5Event) {
            this.f59434a = aVar;
            this.f59435b = h5Event;
        }

        public final void run() {
            a aVar = this.f59434a;
            H5Event h5Event = this.f59435b;
            if (h5Event == null) {
                k.a();
            }
            aVar.a(h5Event, (Object) null, true);
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59436a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f59437b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ JSONObject f59438c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.api.b f59439d;

        d(a aVar, H5Event h5Event, JSONObject jSONObject, net.one97.paytm.phoenix.api.b bVar) {
            this.f59436a = aVar;
            this.f59437b = h5Event;
            this.f59438c = jSONObject;
            this.f59439d = bVar;
        }

        public final void run() {
            a aVar = this.f59436a;
            H5Event h5Event = this.f59437b;
            if (h5Event == null) {
                k.a();
            }
            JSONObject jSONObject = this.f59438c;
            net.one97.paytm.phoenix.api.b bVar = this.f59439d;
            k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
            if (jSONObject == null) {
                jSONObject = aVar.j;
            }
            JSONObject jSONObject2 = jSONObject instanceof Map ? new JSONObject((Map) jSONObject) : jSONObject;
            j jVar = j.f59646a;
            j.a("sendSuccessResult test", String.valueOf(bVar) + "response " + jSONObject2.toString());
            j jVar2 = j.f59646a;
            j.a("sendSuccessResult test1", String.valueOf(aVar.l) + "response1 " + aVar.j.toString());
            if (jSONObject instanceof JSONObject) {
                if (bVar == null) {
                    return;
                }
                if (jSONObject2 != null) {
                    bVar.a(h5Event, jSONObject2);
                    return;
                }
                throw new u("null cannot be cast to non-null type org.json.JSONObject");
            } else if (bVar != null) {
                bVar.a(h5Event, "data", (Object) jSONObject2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(H5Event h5Event, int i2) {
        j jVar = j.f59646a;
        j.b("HttpRequestPlugin", "sendFailed");
        a("error", (Object) Integer.valueOf(i2));
        b(h5Event);
    }

    public static final /* synthetic */ Map a(Map map) {
        HashMap hashMap = new HashMap();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                Object obj = map.get(str);
                if (obj == null) {
                    k.a();
                }
                hashMap.put(str, obj);
            }
        }
        return hashMap;
    }

    public static final /* synthetic */ String b(Map map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            List list = (List) map.get(str);
            if (list != null && !list.isEmpty()) {
                int i2 = 0;
                int size = list.size();
                while (i2 < size) {
                    Object obj = list.get(i2);
                    if (obj != null) {
                        if (!TextUtils.isEmpty((CharSequence) obj) && !TextUtils.isEmpty(str)) {
                            sb.append(str);
                            sb.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COLON);
                            Object obj2 = list.get(i2);
                            if (obj2 != null) {
                                sb.append((String) obj2);
                                sb.append("\\r\\n");
                            } else {
                                throw new u("null cannot be cast to non-null type kotlin.String");
                            }
                        }
                        i2++;
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
                continue;
            }
        }
        String sb2 = sb.toString();
        k.a((Object) sb2, "stringBuilder.toString()");
        return sb2;
    }
}
