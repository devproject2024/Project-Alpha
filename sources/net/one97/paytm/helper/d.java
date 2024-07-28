package net.one97.paytm.helper;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.ContextThemeWrapper;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.AJREmbedWebView;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.j.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.NearbyOffersBannerModal;
import net.one97.paytm.wallet.newdesign.nearby.helper.d;
import net.one97.paytm.wallet.newdesign.nearby.helper.e;

public final class d implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final a f50549a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static d f50550b;

    public final void a(NearbyOffersBannerModal.Item item, Context context, int i2, String str) {
        k.c(item, "item");
        k.c(context, "context");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        net.one97.paytm.j.a.b(item, context, i2, str);
    }

    public final String a() {
        String name = AJREmbedWebView.class.getName();
        k.a((Object) name, "AJREmbedWebView ::class.java.name");
        return name;
    }

    public final void b(NearbyOffersBannerModal.Item item, Context context, int i2, String str) {
        k.c(item, "item");
        k.c(context, "context");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        net.one97.paytm.j.a.a(item, context, i2, str);
    }

    public final void a(String str, HashMap<String, Object> hashMap, Context context) {
        k.c(str, "eventName");
        k.c(hashMap, "eventMap");
        k.c(context, "context");
        net.one97.paytm.j.a.b(str, (Map<String, Object>) hashMap, context);
    }

    public final Context b() {
        Context appContext = CJRJarvisApplication.getAppContext();
        k.a((Object) appContext, "net.one97.paytm.app.CJRJ…plication.getAppContext()");
        return appContext;
    }

    public final ContextWrapper a(Context context) {
        k.c(context, "context");
        ContextThemeWrapper a2 = net.one97.paytm.locale.b.e.a(context);
        k.a((Object) a2, "Restring.wrapContext(context)");
        return a2;
    }

    public final void a(String str, String str2, Context context) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "vertical");
        k.c(context, "context");
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public final String a(String str) {
        k.c(str, "key");
        c.a();
        return c.a(str, (String) null);
    }

    public final boolean b(String str) {
        k.c(str, "key");
        c.a();
        return c.a(str, false);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a() {
            if (d.f50550b == null) {
                d.f50550b = new d();
                d.a aVar = net.one97.paytm.wallet.newdesign.nearby.helper.d.f71130b;
                d c2 = d.f50550b;
                if (c2 == null) {
                    k.a();
                }
                d.a.a(c2);
            }
        }
    }
}
