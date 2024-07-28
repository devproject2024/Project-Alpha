package net.one97.paytm.h5paytmsdk.b;

import android.app.Activity;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebulacore.Nebula;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.h5paytmsdk.c.v;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;

public final class o extends ad {
    public o() {
        super("getCurrentLang");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        super.handleEvent(h5Event, h5BridgeContext);
        if (a(h5Event)) {
            if (h5Event == null) {
                k.a();
            }
            Activity activity = h5Event.getActivity();
            if (activity != null) {
                if (activity instanceof PaytmH5Activity) {
                    H5ProviderManager providerManager = Nebula.getProviderManager();
                    v vVar = (v) (providerManager != null ? providerManager.getProvider(v.class.getName()) : null);
                    if (vVar == null) {
                        a(H5Event.Error.FORBIDDEN, "No implementation found for 'PaytmH5LanguageSelectedProvider'");
                    } else {
                        String[] a2 = vVar.a(activity);
                        if (a2.length == 2) {
                            String str = a2[0];
                            HashMap hashMap = new HashMap();
                            Map map = hashMap;
                            map.put("en", "English");
                            map.put("hi", "Hindi");
                            map.put("bn", "Bangla");
                            map.put("or", "Oriya");
                            map.put("mr", "Marathi");
                            map.put("ml", "Malyalam");
                            map.put("kn", "Kannada");
                            map.put("ta", "Tamil");
                            map.put("te", "Telugu");
                            map.put("gu", "Gujarati");
                            map.put("pa", "Punjabi");
                            String valueOf = hashMap.containsKey(str) ? String.valueOf(hashMap.get(str)) : "";
                            if (!TextUtils.isEmpty(valueOf)) {
                                a("name", (Object) valueOf);
                                a("languageCode", (Object) a2[0]);
                                a("countryCode", (Object) "IN");
                                a("languageID", (Object) a2[1]);
                                a((Object) null);
                            } else {
                                a(-1, "No locale found");
                            }
                        }
                    }
                } else {
                    a(-1, "No locale found");
                }
            }
        }
        return true;
    }
}
