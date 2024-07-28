package net.one97.paytm.h5paytmsdk.b;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebulacore.Nebula;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.h5paytmsdk.c.s;
import net.one97.paytm.h5paytmsdk.c.t;

public final class n extends ad {
    public n() {
        super("paytmGenerateShortlink");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        super.handleEvent(h5Event, h5BridgeContext);
        if (!a(h5Event)) {
            return true;
        }
        H5ProviderManager providerManager = Nebula.getProviderManager();
        e eVar = null;
        s sVar = (s) (providerManager != null ? providerManager.getProvider(s.class.getName()) : null);
        if (sVar == null) {
            a(H5Event.Error.FORBIDDEN, "No implementation found for PaytmH5GenerateShortLinkProvider");
            return true;
        }
        e param = h5Event != null ? h5Event.getParam() : null;
        if (param != null) {
            eVar = param.getJSONObject("parameters");
        }
        HashMap hashMap = new HashMap();
        if (eVar == null || eVar.size() == 0) {
            a(H5Event.Error.INVALID_PARAM, "");
            return true;
        }
        for (String next : eVar.keySet()) {
            k.a((Object) next, "key");
            String string = eVar.getString(next);
            k.a((Object) string, "parameters.getString(key)");
            hashMap.put(next, string);
        }
        Activity activity = h5Event.getActivity();
        k.a((Object) activity, "event.activity");
        sVar.a(activity, hashMap, new a(this));
        return true;
    }

    public static final class a implements t {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f17033a;

        a(n nVar) {
            this.f17033a = nVar;
        }

        public final void a(Object obj) {
            k.c(obj, "shortLinkObject");
            if (!(obj instanceof String) || !TextUtils.isEmpty((CharSequence) obj)) {
                this.f17033a.a("success", (Object) Boolean.TRUE);
                this.f17033a.a("shortlink", obj);
                this.f17033a.a((Object) null);
                return;
            }
            this.f17033a.a(H5Event.Error.UNKNOWN_ERROR, "");
        }
    }
}
