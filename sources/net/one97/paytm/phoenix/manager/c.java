package net.one97.paytm.phoenix.manager;

import android.app.Activity;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.a;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.api.d;
import net.one97.paytm.phoenix.api.e;
import net.one97.paytm.phoenix.api.f;
import net.one97.paytm.phoenix.provider.PhoenixAppPermissionProvider;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import org.json.JSONObject;

public final class c implements e {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, d> f59600a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap<String, d> f59601b = new ConcurrentHashMap<>();

    public final void a(net.one97.paytm.phoenix.api.c cVar) {
        k.c(cVar, "eventFilter");
    }

    public c() {
        this.f59601b.put(H5Plugin.CommonEvents.CHECK_JS_API, this);
        this.f59601b.put("checkJSBridge", this);
    }

    public final boolean a(d dVar) {
        k.c(dVar, "plugin");
        net.one97.paytm.phoenix.api.c cVar = new net.one97.paytm.phoenix.api.c();
        dVar.a(cVar);
        Iterator<String> a2 = cVar.a();
        while (a2.hasNext()) {
            this.f59600a.put(a2.next(), dVar);
        }
        return true;
    }

    public final boolean b(d dVar) {
        k.c(dVar, "plugin");
        net.one97.paytm.phoenix.api.c cVar = new net.one97.paytm.phoenix.api.c();
        dVar.a(cVar);
        Iterator<String> a2 = cVar.a();
        while (a2.hasNext()) {
            this.f59600a.remove(a2.next());
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r0 = ((net.one97.paytm.phoenix.ui.PhoenixActivity) r3).f59608f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.app.Activity r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "activity"
            kotlin.g.b.k.c(r3, r0)
            java.lang.String r0 = "actionName"
            kotlin.g.b.k.c(r4, r0)
            boolean r0 = r3 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            r1 = 0
            if (r0 == 0) goto L_0x001b
            r0 = r3
            net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0
            net.one97.paytm.phoenix.manager.SessionPluginManager r0 = r0.f59608f
            if (r0 == 0) goto L_0x001b
            boolean r3 = r0.a((android.app.Activity) r3, (java.lang.String) r4)
            goto L_0x001c
        L_0x001b:
            r3 = 0
        L_0x001c:
            if (r3 != 0) goto L_0x0030
            java.util.concurrent.ConcurrentHashMap<java.lang.String, net.one97.paytm.phoenix.api.d> r3 = r2.f59601b
            java.lang.Object r3 = r3.get(r4)
            if (r3 != 0) goto L_0x0030
            java.util.concurrent.ConcurrentHashMap<java.lang.String, net.one97.paytm.phoenix.api.d> r3 = r2.f59600a
            java.lang.Object r3 = r3.get(r4)
            if (r3 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            return r1
        L_0x0030:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.manager.c.a(android.app.Activity, java.lang.String):boolean");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        boolean z;
        JSONObject params;
        boolean z2;
        SessionPluginManager sessionPluginManager;
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        f b2 = net.one97.paytm.phoenix.core.c.f59399a.b();
        String name = PhoenixAppPermissionProvider.class.getName();
        k.a((Object) name, "PhoenixAppPermissionProvider::class.java.name");
        PhoenixAppPermissionProvider phoenixAppPermissionProvider = (PhoenixAppPermissionProvider) b2.a(name);
        String bridgeName = h5Event.getBridgeName();
        if (bridgeName != null) {
            Activity activity = h5Event.getActivity();
            if (activity instanceof PhoenixActivity) {
                if (!(phoenixAppPermissionProvider != null ? phoenixAppPermissionProvider.doesAppHasPermissionToAccessThisBridge(((PhoenixActivity) activity).f59606d, bridgeName) : true)) {
                    bVar.a(h5Event, a.FORBIDDEN.ordinal(), "forbidden!");
                    return true;
                }
                if ((k.a((Object) bridgeName, (Object) H5Plugin.CommonEvents.CHECK_JS_API) || k.a((Object) bridgeName, (Object) "checkJSBridge")) && (params = h5Event.getParams()) != null && params.has(SDKConstants.KEY_API)) {
                    JSONObject params2 = h5Event.getParams();
                    String string = params2 != null ? params2.getString(SDKConstants.KEY_API) : null;
                    if (string != null) {
                        Activity activity2 = h5Event.getActivity();
                        if (!(!((!(activity2 instanceof PhoenixActivity) || (sessionPluginManager = ((PhoenixActivity) activity2).f59608f) == null) ? false : sessionPluginManager.a(activity2, bridgeName)) && this.f59601b.get(string) == null && this.f59600a.get(string) == null)) {
                            z2 = true;
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("available", z2);
                            bVar.a(h5Event, jSONObject);
                            z = true;
                        }
                    }
                    z2 = false;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("available", z2);
                    bVar.a(h5Event, jSONObject2);
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return true;
                }
                d dVar = this.f59600a.get(bridgeName);
                if (dVar == null || !dVar.a(h5Event, bVar)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
