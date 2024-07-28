package net.one97.paytm.addmoney.addmoneysource.netbanking.c.a;

import android.content.Context;
import net.one97.paytm.addmoney.h;

public final class a implements net.one97.paytm.addmoney.addmoneysource.netbanking.c.a {

    /* renamed from: b  reason: collision with root package name */
    private static a f48326b;

    /* renamed from: a  reason: collision with root package name */
    private Context f48327a;

    public final void a(h hVar, String str) {
    }

    public final void a(h hVar, String str, String str2, int i2, String str3) {
    }

    private a(Context context) {
        this.f48327a = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f48326b == null) {
                f48326b = new a(context);
            }
            aVar = f48326b;
        }
        return aVar;
    }

    public final void a(String str) {
        f48326b = null;
    }
}
