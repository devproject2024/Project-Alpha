package net.one97.paytm.dynamic.module.bank;

import android.content.Intent;
import android.os.Bundle;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.deeplink.ae;
import net.one97.paytm.paymentsBank.customView.a;
import net.one97.paytm.paymentsBank.customView.c;
import net.one97.paytm.paymentsBank.utils.l;

public final class ModuleManager implements ae.a {
    public static final Companion Companion = new Companion((g) null);
    public static final String TAG = "ModuleManager";

    public final void init() {
    }

    public final void setDeepLink(String str) {
        k.c(str, "deepLink");
        l a2 = l.a();
        k.a((Object) a2, "PDCSingletonHolder.getInstance()");
        a2.e(str);
    }

    public final void setFDId(String str) {
        k.c(str, "fdId");
        l a2 = l.a();
        k.a((Object) a2, "PDCSingletonHolder.getInstance()");
        a2.d(str);
    }

    public final void setQrCodeId(String str) {
        k.c(str, "qrCodeId");
        l a2 = l.a();
        k.a((Object) a2, "PDCSingletonHolder.getInstance()");
        a2.c(str);
    }

    public final void setGoToScreen(String str) {
        k.c(str, "str");
        l a2 = l.a();
        k.a((Object) a2, "PDCSingletonHolder.getInstance()");
        a2.a(str);
    }

    public final void setOrderId(String str) {
        k.c(str, "orderId");
        l a2 = l.a();
        k.a((Object) a2, "PDCSingletonHolder.getInstance()");
        a2.b(str);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    static {
        ae aeVar = ae.f50307a;
        ae.a((ae.a) new ModuleManager());
    }

    public final void getBundleValues(Bundle bundle) {
        k.c(bundle, "bundle");
        if (bundle.containsKey("fd_id")) {
            String string = bundle.getString("fd_id");
            if (string == null) {
                k.a();
            }
            k.a((Object) string, "bundle.getString(\"fd_id\")!!");
            setFDId(string);
        }
        if (bundle.containsKey("goto")) {
            String string2 = bundle.getString("goto");
            if (string2 == null) {
                k.a();
            }
            k.a((Object) string2, "bundle.getString(\"goto\")!!");
            setGoToScreen(string2);
        }
        if (bundle.containsKey("deeplink")) {
            String string3 = bundle.getString("deeplink");
            if (string3 == null) {
                k.a();
            }
            k.a((Object) string3, "bundle.getString(\"deeplink\")!!");
            setDeepLink(string3);
        }
        if (bundle.containsKey("qrCodeId")) {
            String string4 = bundle.getString("qrCodeId");
            if (string4 == null) {
                k.a();
            }
            k.a((Object) string4, "bundle.getString(\"qrCodeId\")!!");
            setQrCodeId(string4);
        }
        if (bundle.containsKey("orderId")) {
            String string5 = bundle.getString("orderId");
            if (string5 == null) {
                k.a();
            }
            k.a((Object) string5, "bundle.getString(\"orderId\")!!");
            setOrderId(string5);
        }
    }

    public final void logoutBank() {
        a.a(c.MASKED_CARD);
        a.c();
        androidx.localbroadcastmanager.a.a.a(CJRJarvisApplication.getAppContext()).a(new Intent("templogout"));
    }
}
