package net.one97.paytm.phoenix.core;

import android.app.Activity;
import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.Map;
import kotlin.a.f;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.api.c;
import net.one97.paytm.phoenix.api.d;
import net.one97.paytm.phoenix.provider.PhoenixBridgeInterceptorProvider;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.j;
import org.json.JSONObject;

public abstract class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f59397a;
    public JSONObject j = new JSONObject();
    public String k;
    public b l;

    public static boolean b(H5Event h5Event, b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        return true;
    }

    public a(String... strArr) {
        k.c(strArr, "actions");
        this.f59397a = strArr;
    }

    public final void a(c cVar) {
        k.c(cVar, "eventFilter");
        for (String str : this.f59397a) {
            k.c(str, "action");
            cVar.f59383a.add(str);
        }
    }

    public boolean a(H5Event h5Event, b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        this.j = new JSONObject();
        this.k = h5Event.getBridgeName();
        this.l = bVar;
        Activity activity = h5Event.getActivity();
        if (activity != null && (activity instanceof PhoenixActivity)) {
            k.c(this, "plugin");
            ((PhoenixActivity) activity).f59605c = this;
        }
        net.one97.paytm.phoenix.util.b bVar2 = net.one97.paytm.phoenix.util.b.f59636a;
        if (f.a((T[]) net.one97.paytm.phoenix.util.b.a(), h5Event.getAction$phoenix_debug())) {
            return false;
        }
        Activity activity2 = h5Event.getActivity();
        if (!(activity2 instanceof PhoenixActivity)) {
            return false;
        }
        net.one97.paytm.phoenix.api.f b2 = c.f59399a.b();
        String name = PhoenixBridgeInterceptorProvider.class.getName();
        k.a((Object) name, "PhoenixBridgeInterceptorProvider::class.java.name");
        PhoenixBridgeInterceptorProvider phoenixBridgeInterceptorProvider = (PhoenixBridgeInterceptorProvider) b2.a(name);
        if (phoenixBridgeInterceptorProvider == null) {
            return false;
        }
        Context context = activity2;
        String action$phoenix_debug = h5Event.getAction$phoenix_debug();
        JSONObject params = h5Event.getParams();
        phoenixBridgeInterceptorProvider.onBridgeCalled(context, action$phoenix_debug, params != null ? params.toString() : null, ((PhoenixActivity) activity2).f59606d, false, (String) null);
        return false;
    }

    public final boolean a(H5Event h5Event) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        if (h5Event.getParams() != null) {
            return true;
        }
        j jVar = j.f59646a;
        j.b("PaytmH5AlertPlugin", "none params");
        net.one97.paytm.phoenix.api.a aVar = net.one97.paytm.phoenix.api.a.INVALID_PARAM;
        String a2 = net.one97.paytm.phoenix.util.f.a(new String[0]);
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(aVar, "error");
        k.c(a2, "msg");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("customError", 2);
        jSONObject.put("customErrorMessage", a2);
        jSONObject.put("message", a(aVar));
        jSONObject.put("error", aVar.ordinal());
        a(h5Event, jSONObject);
        return false;
    }

    public final void a(H5Event h5Event, net.one97.paytm.phoenix.api.a aVar, String str) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(aVar, "error");
        k.c(str, "msg");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("message", a(aVar));
        jSONObject.put("error", aVar.ordinal());
        a(h5Event, jSONObject);
    }

    public final void b(H5Event h5Event, net.one97.paytm.phoenix.api.a aVar, String str) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(aVar, "error");
        k.c(str, "msg");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("message", str);
        jSONObject.put("error", aVar.ordinal());
        a(h5Event, jSONObject);
    }

    public final void a(H5Event h5Event, JSONObject jSONObject) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(jSONObject, "any");
        b bVar = this.l;
        if (bVar != null) {
            bVar.a(h5Event, jSONObject);
        }
    }

    private static String a(net.one97.paytm.phoenix.api.a aVar) {
        int i2 = b.f59398a[aVar.ordinal()];
        if (i2 == 1) {
            return "not implemented!";
        }
        if (i2 == 2) {
            return "invalid parameter!";
        }
        if (i2 != 3) {
            return i2 != 4 ? "none error!" : "forbidden!";
        }
        return "unknown error!";
    }

    public static /* synthetic */ void a(a aVar, H5Event h5Event, Object obj, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        aVar.a(h5Event, obj, z);
    }

    public final void a(H5Event h5Event, Object obj, boolean z) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        if (obj == null) {
            obj = this.j;
        }
        Object jSONObject = obj instanceof Map ? new JSONObject((Map) obj) : obj;
        if (!z || !(obj instanceof JSONObject)) {
            b bVar = this.l;
            if (bVar != null) {
                bVar.a(h5Event, "data", jSONObject);
                return;
            }
            return;
        }
        b bVar2 = this.l;
        if (bVar2 == null) {
            return;
        }
        if (jSONObject != null) {
            bVar2.a(h5Event, (JSONObject) jSONObject);
            return;
        }
        throw new u("null cannot be cast to non-null type org.json.JSONObject");
    }

    public final void a(String str, Object obj) {
        k.c(str, "key");
        k.c(obj, "any");
        this.j.put(str, obj);
    }
}
