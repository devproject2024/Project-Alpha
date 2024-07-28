package net.one97.paytm.h5.a;

import android.app.Activity;
import android.content.Context;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.b.a.a;
import net.one97.paytm.h5.a.e;
import net.one97.paytm.h5paytmsdk.b.ad;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.l;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;

public final class k extends ad {

    /* renamed from: a  reason: collision with root package name */
    private String f16869a = "loggedInType";

    /* renamed from: d  reason: collision with root package name */
    private String f16870d = "deviceBinded";

    /* renamed from: e  reason: collision with root package name */
    private String f16871e = "loggedInWithPassword";

    /* renamed from: f  reason: collision with root package name */
    private String f16872f = "loggedInWithOTP";

    /* renamed from: g  reason: collision with root package name */
    private H5BridgeContext f16873g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k() {
        super(e.o);
        e.a aVar = e.f16836a;
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String str;
        super.handleEvent(h5Event, h5BridgeContext);
        if (a(h5Event)) {
            this.f16873g = h5BridgeContext;
            if (!(h5Event == null || h5Event.getActivity() == null)) {
                String action = h5Event.getAction();
                e.a aVar = e.f16836a;
                if (kotlin.g.b.k.a((Object) action, (Object) e.o)) {
                    e.a aVar2 = e.f16836a;
                    Activity activity = h5Event.getActivity();
                    kotlin.g.b.k.a((Object) activity, "event.activity");
                    Activity activity2 = null;
                    if (!e.a.a(h5BridgeContext, activity, (String) null, 12)) {
                        com.alibaba.a.e eVar = new com.alibaba.a.e();
                        eVar.put("success", (Object) Boolean.TRUE);
                        String str2 = this.f16869a;
                        if (h5Event != null) {
                            activity2 = h5Event.getActivity();
                        }
                        kotlin.g.b.k.a((Object) activity2, "event?.activity");
                        ag.a aVar3 = ag.f69605a;
                        Context applicationContext = activity2.getApplicationContext();
                        kotlin.g.b.k.a((Object) applicationContext, "activity.applicationContext");
                        a a2 = ag.a.a(applicationContext);
                        if ("device_binding".equals(a2.b(WalletSharedPrefs.KEY_OAUTH_LOGIN_METHOD, "", true)) || "device_binding_otp".equals(a2.b(WalletSharedPrefs.KEY_OAUTH_LOGIN_METHOD, "", true))) {
                            str = this.f16870d;
                        } else if (l.g(activity2)) {
                            str = this.f16871e;
                        } else {
                            str = this.f16872f;
                        }
                        eVar.put(str2, (Object) str);
                        a((Object) eVar);
                    }
                }
            }
        }
        return true;
    }
}
