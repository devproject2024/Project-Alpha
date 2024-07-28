package net.one97.paytm.feed.repository;

import android.app.Application;
import android.content.Context;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytm.utility.f;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f34608a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static a f34609b;

    private b() {
    }

    public static void a(Context context) {
        if (f34609b == null) {
            synchronized (b.class) {
                if (f34609b == null) {
                    if (context instanceof Application) {
                        a.C0708a aVar = a.f42641a;
                        f34609b = a.C0708a.a(context, a.c.CHAT, f.a.FEED);
                    } else if (context != null) {
                        a.C0708a aVar2 = com.paytm.b.a.a.f42641a;
                        Context applicationContext = context.getApplicationContext();
                        k.a((Object) applicationContext, "context.applicationContext");
                        f34609b = a.C0708a.a(applicationContext, a.c.CHAT, f.a.FEED);
                    }
                }
                x xVar = x.f47997a;
            }
        }
    }

    public static void a() {
        com.paytm.b.a.a aVar = f34609b;
        if (aVar != null) {
            aVar.a("FEED_LANGUAGE_STATUS", true, false);
        }
    }

    public static boolean b() {
        com.paytm.b.a.a aVar = f34609b;
        if (aVar != null) {
            return aVar.b("LANGUAGE_CARD_SHOWN", false, false);
        }
        return false;
    }

    public static void c() {
        com.paytm.b.a.a aVar = f34609b;
        if (aVar != null) {
            aVar.a("LANGUAGE_CARD_SHOWN", true, false);
        }
    }

    public static void a(int i2) {
        com.paytm.b.a.a aVar = f34609b;
        if (aVar != null) {
            aVar.a("FEED_TOP_RANK", i2, false);
        }
    }

    public static void b(int i2) {
        com.paytm.b.a.a aVar = f34609b;
        if (aVar != null) {
            aVar.a("FEED_BOTTOM_RANK", i2, false);
        }
    }

    public static int d() {
        com.paytm.b.a.a aVar = f34609b;
        if (aVar != null) {
            return aVar.b("FEED_TOP_RANK", -200, false);
        }
        return -200;
    }

    public static int e() {
        com.paytm.b.a.a aVar = f34609b;
        if (aVar != null) {
            return aVar.b("FEED_BOTTOM_RANK", 0, false);
        }
        return 0;
    }

    public static String f() {
        com.paytm.b.a.a aVar = f34609b;
        if (aVar != null) {
            return aVar.b("FEED_LANGUAGES", "EN,HI", false);
        }
        return null;
    }

    public static void a(boolean z) {
        com.paytm.b.a.a aVar = f34609b;
        if (aVar != null) {
            aVar.a("FEED_PROFILE_UPDATE", z, false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.b("FEED_BASE_URL", "", false);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String g() {
        /*
            com.paytm.b.a.a r0 = f34609b
            if (r0 == 0) goto L_0x000f
            r1 = 0
            java.lang.String r2 = "FEED_BASE_URL"
            java.lang.String r3 = ""
            java.lang.String r0 = r0.b((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            if (r0 != 0) goto L_0x0011
        L_0x000f:
            java.lang.String r0 = "https://cif.paytm.com"
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.b.g():java.lang.String");
    }

    public static int h() {
        com.paytm.b.a.a aVar = f34609b;
        if (aVar != null) {
            return aVar.b("FEED_SESSION_TIME", 0, false);
        }
        return 0;
    }

    public static void c(int i2) {
        com.paytm.b.a.a aVar = f34609b;
        if (aVar != null) {
            aVar.a("FEED_SESSION_TIME", i2, false);
        }
        "Sesion time in minutes is :: ".concat(String.valueOf(i2));
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
    }

    public static void d(int i2) {
        com.paytm.b.a.a aVar = f34609b;
        if (aVar != null) {
            aVar.a("FEED_REFRESH_COUNT", i2, false);
        }
    }

    public static int i() {
        com.paytm.b.a.a aVar = f34609b;
        if (aVar != null) {
            return aVar.b("FEED_REFRESH_COUNT", 0, false);
        }
        return 0;
    }

    public static void j() {
        com.paytm.b.a.a aVar = f34609b;
        if (aVar != null) {
            aVar.a("FEED_FIRST_REQUEST", true, false);
        }
    }

    public static boolean k() {
        com.paytm.b.a.a aVar = f34609b;
        if (aVar != null) {
            return aVar.b("FEED_FIRST_REQUEST", false, false);
        }
        return true;
    }

    public static void l() {
        com.paytm.b.a.a aVar = f34609b;
        if (aVar != null) {
            aVar.a("FEED_ONE_OFF", true, false);
        }
    }

    public static boolean m() {
        com.paytm.b.a.a aVar = f34609b;
        if (aVar != null) {
            return aVar.b("FEED_ONE_OFF", false, false);
        }
        return false;
    }

    public static void a(String str) {
        k.c(str, "languages");
        String a2 = p.a(p.a(p.a(str, "[", "", false), "]", "", false), " ", "", false);
        if (a2 != null) {
            String upperCase = a2.toUpperCase();
            k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            com.paytm.b.a.a aVar = f34609b;
            if (aVar != null) {
                aVar.a("FEED_LANGUAGES", upperCase, false);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }
}
