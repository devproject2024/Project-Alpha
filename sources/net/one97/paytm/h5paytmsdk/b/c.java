package net.one97.paytm.h5paytmsdk.b;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.iap.android.webapp.sdk.app.SubAppConfig;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebulacore.Nebula;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.h5paytmsdk.a.b;
import net.one97.paytm.h5paytmsdk.c.f;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class c extends ad {
    public c() {
        super("paytmAnalyticsTracking");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Iterable<Map.Entry> entrySet;
        super.handleEvent(h5Event, h5BridgeContext);
        if (!b(h5Event)) {
            return true;
        }
        if (h5Event == null) {
            k.a();
        }
        e param = h5Event.getParam();
        String string = param.getString(SDKConstants.EVENT_KEY_SCREEN_NAME);
        String string2 = param.getString("eventName");
        e jSONObject = param.getJSONObject("data");
        if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
            Context activity = h5Event.getActivity();
            if (activity == null || !(activity instanceof PaytmH5Activity)) {
                return true;
            }
            H5ProviderManager providerManager = Nebula.getProviderManager();
            f fVar = (f) (providerManager != null ? providerManager.getProvider(f.class.getName()) : null);
            if (fVar == null) {
                a(H5Event.Error.FORBIDDEN, "No implementation found for 'PaytmH5AnalyticsProvider'");
                return true;
            }
            Map hashMap = new HashMap();
            if (!(jSONObject == null || (entrySet = jSONObject.entrySet()) == null)) {
                for (Map.Entry entry : entrySet) {
                    Object key = entry.getKey();
                    k.a(key, "it.key");
                    Object value = entry.getValue();
                    k.a(value, "it.value");
                    hashMap.put(key, value);
                }
            }
            Context context = activity;
            Map map = hashMap;
            PaytmH5Activity paytmH5Activity = (PaytmH5Activity) activity;
            String a2 = paytmH5Activity.a();
            b a3 = b.a();
            k.a((Object) a3, "IAPIntegrationHelper.getInstance()");
            Map<String, SubAppConfig> b2 = a3.b();
            if (b2 != null) {
                b2.containsKey(paytmH5Activity.a());
            }
            fVar.a(context, string, string2, map, a2);
            a("success", (Object) Boolean.TRUE);
            a((Object) null);
            return true;
        }
        a(H5Event.Error.INVALID_PARAM, "screenName and eventName is empty!");
        return true;
    }
}
