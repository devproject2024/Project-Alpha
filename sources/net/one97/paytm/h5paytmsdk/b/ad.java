package net.one97.paytm.h5paytmsdk.b;

import android.app.Activity;
import android.content.Context;
import com.alibaba.a.e;
import com.alipay.iap.android.common.b.c;
import com.alipay.iap.android.webapp.sdk.app.SubAppConfig;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebulacore.Nebula;
import java.util.Map;
import kotlin.a.f;
import kotlin.g.b.k;
import net.one97.paytm.h5paytmsdk.a.b;
import net.one97.paytm.h5paytmsdk.c.m;
import net.one97.paytm.h5paytmsdk.d.a;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;

public abstract class ad extends H5SimplePlugin {

    /* renamed from: a  reason: collision with root package name */
    private H5BridgeContext f16976a;

    /* renamed from: b  reason: collision with root package name */
    e f16977b = new e();

    /* renamed from: c  reason: collision with root package name */
    public String f16978c;

    /* renamed from: d  reason: collision with root package name */
    private final String[] f16979d;

    public ad(String... strArr) {
        k.c(strArr, "actions");
        this.f16979d = strArr;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        for (String str : this.f16979d) {
            if (h5EventFilter != null) {
                h5EventFilter.addAction(str);
            }
        }
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Context activity;
        a aVar = a.f17097a;
        String str = null;
        if (!f.a((T[]) a.a(), h5Event != null ? h5Event.getAction() : null) && h5Event != null && (activity = h5Event.getActivity()) != null && (activity instanceof PaytmH5Activity)) {
            H5ProviderManager providerManager = Nebula.getProviderManager();
            m mVar = (m) (providerManager != null ? providerManager.getProvider(m.class.getName()) : null);
            if (mVar != null) {
                Context context = activity;
                String action = h5Event.getAction();
                e param = h5Event.getParam();
                if (param != null) {
                    str = param.toJSONString();
                }
                String str2 = str;
                PaytmH5Activity paytmH5Activity = (PaytmH5Activity) activity;
                String a2 = paytmH5Activity.a();
                b a3 = b.a();
                k.a((Object) a3, "IAPIntegrationHelper.getInstance()");
                Map<String, SubAppConfig> b2 = a3.b();
                if (b2 != null) {
                    b2.containsKey(paytmH5Activity.a());
                }
                mVar.a(context, action, str2, a2, (String) null);
            }
        }
        return super.interceptEvent(h5Event, h5BridgeContext);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Activity activity;
        this.f16976a = h5BridgeContext;
        this.f16977b = new e();
        this.f16978c = h5Event != null ? h5Event.getAction() : null;
        if (h5Event == null || (activity = h5Event.getActivity()) == null || !(activity instanceof PaytmH5Activity)) {
            return true;
        }
        k.c(this, "paytmH5SimplePlugin");
        ((PaytmH5Activity) activity).k = this;
        return true;
    }

    public final boolean a(H5Event h5Event) {
        if (h5Event != null) {
            return true;
        }
        c.e();
        a(H5Event.Error.FORBIDDEN, "forbidden");
        return false;
    }

    public final boolean b(H5Event h5Event) {
        if (h5Event != null && h5Event.getParam() != null) {
            return true;
        }
        c.e();
        a(H5Event.Error.INVALID_PARAM, "invalid params");
        return false;
    }

    public final void a(H5Event.Error error, String str) {
        k.c(error, "error");
        k.c(str, "msg");
        H5BridgeContext h5BridgeContext = this.f16976a;
        if (h5BridgeContext != null) {
            e eVar = new e();
            Map map = eVar;
            map.put("message", a(error));
            map.put("error", Integer.valueOf(error.ordinal()));
            h5BridgeContext.sendBridgeResult(eVar);
        }
    }

    private static String a(H5Event.Error error) {
        int i2 = ae.f16980a[error.ordinal()];
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

    public final void a(Object obj) {
        if (obj == null) {
            H5BridgeContext h5BridgeContext = this.f16976a;
            if (h5BridgeContext != null) {
                h5BridgeContext.sendBridgeResult("data", this.f16977b);
                return;
            }
            return;
        }
        H5BridgeContext h5BridgeContext2 = this.f16976a;
        if (h5BridgeContext2 != null) {
            h5BridgeContext2.sendBridgeResult("data", obj);
        }
    }

    public final void a(String str, Object obj) {
        k.c(str, "key");
        k.c(obj, "any");
        this.f16977b.put(str, obj);
    }

    public final void a(int i2, String str) {
        k.c(str, "msg");
        H5BridgeContext h5BridgeContext = this.f16976a;
        if (h5BridgeContext != null) {
            h5BridgeContext.sendError(i2, str);
        }
    }
}
