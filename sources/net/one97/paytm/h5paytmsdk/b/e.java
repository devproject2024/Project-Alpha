package net.one97.paytm.h5paytmsdk.b;

import android.app.Activity;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebulacore.Nebula;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.h5paytmsdk.c.j;

public final class e extends ad {
    public e() {
        super("paytmAppsFlyerSendEvent");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        super.handleEvent(h5Event, h5BridgeContext);
        if (!a(h5Event)) {
            return true;
        }
        H5ProviderManager providerManager = Nebula.getProviderManager();
        j jVar = (j) (providerManager != null ? providerManager.getProvider(j.class.getName()) : null);
        if (jVar == null) {
            a(H5Event.Error.FORBIDDEN, "No implementation found for PaytmH5AppsFlyerSendEventProvider");
            return true;
        }
        com.alibaba.a.e param = h5Event != null ? h5Event.getParam() : null;
        com.alibaba.a.e jSONObject = param != null ? param.getJSONObject("params") : null;
        String string = jSONObject != null ? jSONObject.getString("mEventName") : null;
        com.alibaba.a.e jSONObject2 = jSONObject != null ? jSONObject.getJSONObject(Item.CTA_URL_TYPE_MAP) : null;
        HashMap hashMap = new HashMap();
        if (jSONObject == null || jSONObject.size() == 0 || TextUtils.isEmpty(string)) {
            a(H5Event.Error.INVALID_PARAM, "");
            return true;
        }
        if (jSONObject2 != null) {
            for (String next : jSONObject2.keySet()) {
                k.a((Object) next, "key");
                String string2 = jSONObject2.getString(next);
                k.a((Object) string2, "it.getString(key)");
                hashMap.put(next, string2);
            }
        }
        Activity activity = h5Event.getActivity();
        k.a((Object) activity, "event.activity");
        jVar.a(activity, string, hashMap);
        a("success", (Object) Boolean.TRUE);
        a((Object) null);
        return true;
    }
}
