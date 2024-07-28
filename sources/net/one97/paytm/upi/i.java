package net.one97.paytm.upi;

import android.content.Context;
import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.f.a;
import net.one97.paytm.upi.g.d;
import net.one97.paytm.upi.util.CJRSendGTMTag;

public final class i {
    private static i n;

    /* renamed from: a  reason: collision with root package name */
    public String f66980a;

    /* renamed from: b  reason: collision with root package name */
    public String f66981b;

    /* renamed from: c  reason: collision with root package name */
    public String f66982c;

    /* renamed from: d  reason: collision with root package name */
    public String f66983d;

    /* renamed from: e  reason: collision with root package name */
    public String f66984e;

    /* renamed from: f  reason: collision with root package name */
    public String f66985f;

    /* renamed from: g  reason: collision with root package name */
    public String f66986g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66987h = false;

    /* renamed from: i  reason: collision with root package name */
    public String f66988i = "release";
    public String j = "paytm";
    public k k;
    public a l;
    public h m;

    public static i a() {
        i iVar = n;
        if (iVar != null) {
            return iVar;
        }
        throw new IllegalStateException("Paytm Upi SDK may not have been initialized.");
    }

    public static void a(Context context) {
        if (n == null) {
            n = new i();
            d.a(context.getApplicationContext());
            UpiGTMLoader.init();
            UpiGTMLoader.getInstance().setOnCustomNewGTMEvent(new CJRSendGTMTag.OnCustomNewGTMEvent() {
                public final void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
                }

                public final void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
                }

                public final void sendNewCustomGTMEventsWithMultipleLabel(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5) {
                }

                public final void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
                }
            });
        }
        b(context);
    }

    private static void b(Context context) {
        i a2 = a();
        a2.f66980a = com.paytm.utility.a.q(context);
        a2.f66981b = com.paytm.utility.a.b(context);
        a2.f66984e = com.paytm.utility.a.a(context);
    }

    public final k b() {
        return this.k;
    }

    public final h c() {
        return this.m;
    }

    public final String d() {
        return this.f66983d;
    }

    public final String e() {
        return this.f66984e;
    }

    public final String f() {
        return this.f66980a;
    }

    public final a g() {
        return this.l;
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        CJRSendGTMTag.sendNewCustomGTMEvents(context, str, str2, str3, str4, str5, str6, str7);
    }
}
