package net.one97.paytm.h5paytmsdk.b;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebulacore.Nebula;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.h5paytmsdk.c.ae;
import net.one97.paytm.h5paytmsdk.c.k;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;

public final class f extends ad {
    public f() {
        super("paytmLogin", "paytmLogout", "paytmSessionExpired", "paytmFetchAuthToken");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Intent a2;
        Activity activity;
        boolean z;
        H5BridgeContext h5BridgeContext2 = h5BridgeContext;
        super.handleEvent(h5Event, h5BridgeContext);
        if (!b(h5Event)) {
            return true;
        }
        if (h5Event == null) {
            k.a();
        }
        e param = h5Event.getParam();
        String action = h5Event.getAction();
        Integer integer = param.getInteger("requestCode");
        int intValue = integer != null ? integer.intValue() : 567;
        x.a aVar = new x.a();
        boolean z2 = false;
        try {
            Boolean bool = param.getBoolean("logoutAllDevices");
            aVar.element = bool != null ? bool.booleanValue() : false;
        } catch (Exception unused) {
            aVar.element = false;
        }
        H5ProviderManager providerManager = Nebula.getProviderManager();
        net.one97.paytm.h5paytmsdk.c.k kVar = (net.one97.paytm.h5paytmsdk.c.k) (providerManager != null ? providerManager.getProvider(net.one97.paytm.h5paytmsdk.c.k.class.getName()) : null);
        H5ProviderManager providerManager2 = Nebula.getProviderManager();
        ae aeVar = (ae) (providerManager2 != null ? providerManager2.getProvider(ae.class.getName()) : null);
        if (kVar == null) {
            a(H5Event.Error.FORBIDDEN, "No implementation found for 'PaytmH5AuthProvider'");
            return false;
        }
        HashMap hashMap = new HashMap(1);
        if (param != null) {
            Iterable<Map.Entry> entrySet = param.entrySet();
            k.a((Object) entrySet, "it.entries");
            for (Map.Entry entry : entrySet) {
                Object key = entry.getKey();
                k.a(key, "entry.key");
                hashMap.put(key, entry.getValue());
            }
        }
        if (action == null) {
            return true;
        }
        switch (action.hashCode()) {
            case -567028024:
                if (!action.equals("paytmLogin") || (a2 = kVar.a(h5Event.getActivity())) == null || (activity = h5Event.getActivity()) == null || !(activity instanceof PaytmH5Activity)) {
                    return true;
                }
                PaytmH5Activity paytmH5Activity = (PaytmH5Activity) activity;
                paytmH5Activity.f17107e.addObserver(new a(activity, a2, this, action, h5Event, hashMap, intValue, aVar, aeVar, h5BridgeContext));
                paytmH5Activity.a(a2, intValue, action);
                return true;
            case -397993461:
                if (!action.equals("paytmLogout")) {
                    return true;
                }
                if (aVar.element) {
                    z = kVar.e(h5Event.getActivity());
                } else {
                    z = kVar.b(h5Event.getActivity());
                }
                if (z) {
                    a("success", (Object) Boolean.TRUE);
                    a((Object) null);
                    return true;
                }
                a(H5Event.Error.UNKNOWN_ERROR, "cannot logout");
                return true;
            case -293618896:
                if (!action.equals("paytmSessionExpired")) {
                    return true;
                }
                if (kVar.c(h5Event.getActivity())) {
                    a("success", (Object) Boolean.TRUE);
                    a((Object) null);
                    return true;
                }
                a(H5Event.Error.UNKNOWN_ERROR, "cannot expire session");
                return true;
            case 128267032:
                if (!action.equals("paytmFetchAuthToken")) {
                    return true;
                }
                k.a d2 = kVar.d(h5Event.getActivity());
                if (d2 == null || aeVar == null) {
                    a(H5Event.Error.NOT_FOUND, "Not found");
                    return true;
                }
                Activity activity2 = h5Event.getActivity();
                if (activity2 == null || !(activity2 instanceof PaytmH5Activity)) {
                    return true;
                }
                e eVar = new e();
                boolean b2 = aeVar.b(((PaytmH5Activity) activity2).a());
                if (d2.f17092a == null || TextUtils.isEmpty(d2.f17092a)) {
                    z2 = true;
                }
                if (!b2) {
                    Map map = eVar;
                    map.put("success", Boolean.FALSE);
                    map.put("error", Integer.valueOf(H5Event.Error.INVALID_PARAM.ordinal()));
                    map.put("message", "Not authorized!");
                    if (h5BridgeContext2 == null) {
                        return true;
                    }
                    h5BridgeContext2.sendBridgeResult(eVar);
                    return true;
                } else if (z2) {
                    Map map2 = eVar;
                    map2.put("success", Boolean.FALSE);
                    map2.put("error", Integer.valueOf(H5Event.Error.INVALID_PARAM.ordinal()));
                    map2.put("message", "No sso token!");
                    if (h5BridgeContext2 == null) {
                        return true;
                    }
                    h5BridgeContext2.sendBridgeResult(eVar);
                    return true;
                } else {
                    Map map3 = eVar;
                    map3.put("success", Boolean.TRUE);
                    map3.put("data", d2.f17092a);
                    map3.put("authorization", d2.f17093b);
                    if (h5BridgeContext2 == null) {
                        return true;
                    }
                    h5BridgeContext2.sendBridgeResult(eVar);
                    return true;
                }
            default:
                return true;
        }
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f16990a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Intent f16991b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f f16992c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f16993d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ H5Event f16994e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ HashMap f16995f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f16996g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ x.a f16997h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ ae f16998i;
        final /* synthetic */ H5BridgeContext j;

        a(Activity activity, Intent intent, f fVar, String str, H5Event h5Event, HashMap hashMap, int i2, x.a aVar, ae aeVar, H5BridgeContext h5BridgeContext) {
            this.f16990a = activity;
            this.f16991b = intent;
            this.f16992c = fVar;
            this.f16993d = str;
            this.f16994e = h5Event;
            this.f16995f = hashMap;
            this.f16996g = i2;
            this.f16997h = aVar;
            this.f16998i = aeVar;
            this.j = h5BridgeContext;
        }

        public final void update(Observable observable, Object obj) {
            f fVar = this.f16992c;
            if (kotlin.g.b.k.a(obj, (Object) Boolean.FALSE)) {
                fVar.a("success", (Object) Boolean.FALSE);
            } else if (obj != null) {
                fVar.a("success", obj);
            } else {
                fVar.a("success", (Object) Boolean.TRUE);
            }
            fVar.a((Object) null);
            ((PaytmH5Activity) this.f16990a).f17107e.deleteObservers();
        }
    }
}
