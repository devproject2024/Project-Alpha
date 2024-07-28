package net.one97.paytm.addmoney.addmoneysource.a.c.a;

import android.content.Context;
import net.one97.paytm.addmoney.h;

public final class a implements net.one97.paytm.addmoney.addmoneysource.a.c.a {

    /* renamed from: a  reason: collision with root package name */
    private static a f48131a;

    /* renamed from: b  reason: collision with root package name */
    private Context f48132b;

    public final void a(String str, String str2, h hVar, String str3) {
    }

    public final void a(h hVar, String str) {
    }

    public final void a(h hVar, String str, String str2, int i2, String str3) {
    }

    private a(Context context) {
        this.f48132b = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f48131a == null) {
                f48131a = new a(context);
            }
            aVar = f48131a;
        }
        return aVar;
    }

    public final void a(String str) {
        f48131a = null;
    }
}
