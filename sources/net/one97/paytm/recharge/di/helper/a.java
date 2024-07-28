package net.one97.paytm.recharge.di.helper;

import android.app.Activity;
import kotlin.g.b.k;
import net.one97.paytm.recharge.di.a;
import net.one97.paytm.recharge.di.f;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f62650a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static net.one97.paytm.recharge.di.a f62651b = f.f62644a.b();

    private a() {
    }

    public static Class<? extends Activity> a() {
        Class<? extends Activity> cls = f62651b.getActivityMap().get(a.C1212a.ORDER_SUMMARY);
        if (cls == null) {
            k.a();
        }
        return cls;
    }

    public static Class<? extends Activity> b() {
        Class<? extends Activity> cls = f62651b.getActivityMap().get(a.C1212a.AuthActivity);
        if (cls == null) {
            k.a();
        }
        return cls;
    }

    public static Class<? extends Activity> c() {
        Class<? extends Activity> cls = f62651b.getActivityMap().get(a.C1212a.WebViewActivity);
        if (cls == null) {
            k.a();
        }
        return cls;
    }

    public static Class<? extends Activity> d() {
        Class<? extends Activity> cls = f62651b.getActivityMap().get(a.C1212a.AJRUpdateMessage);
        if (cls == null) {
            k.a();
        }
        return cls;
    }

    public static Class<? extends Activity> e() {
        Class<? extends Activity> cls = f62651b.getActivityMap().get(a.C1212a.AJRRechargePaymentActivity);
        if (cls == null) {
            k.a();
        }
        return cls;
    }

    public static Class<? extends Activity> f() {
        Class<? extends Activity> cls = f62651b.getActivityMap().get(a.C1212a.AJRYoutubeVideoPlay);
        if (cls == null) {
            k.a();
        }
        return cls;
    }

    public static Class<? extends Activity> g() {
        Class<? extends Activity> cls = f62651b.getActivityMap().get(a.C1212a.AJRMainActivity);
        if (cls == null) {
            k.a();
        }
        return cls;
    }

    public static Class<? extends Activity> h() {
        Class<? extends Activity> cls = f62651b.getActivityMap().get(a.C1212a.ActiveSubscriptionActivity);
        if (cls == null) {
            k.a();
        }
        return cls;
    }
}
