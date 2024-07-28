package net.one97.paytm.addmoney.common.d.a;

import android.content.Context;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.addmoney.i;

public final class a implements net.one97.paytm.addmoney.common.d.a {

    /* renamed from: a  reason: collision with root package name */
    private static a f48461a;

    /* renamed from: b  reason: collision with root package name */
    private Context f48462b;

    public final void a(String str, String str2, String str3, h hVar) {
    }

    public final void a(String str, String str2, String str3, h hVar, String str4) {
    }

    public final void a(String str, String str2, h hVar) {
    }

    public final void a(String str, h hVar) {
    }

    public final void a(h hVar, String str) {
    }

    public final void a(h hVar, String str, String str2, int i2, String str3) {
    }

    public final void a(i iVar, String str) {
    }

    public final void b(h hVar, String str) {
    }

    public final void b(h hVar, String str, String str2, int i2, String str3) {
    }

    public final void b(i iVar, String str) {
    }

    public final void c(h hVar, String str) {
    }

    private a(Context context) {
        this.f48462b = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f48461a == null) {
                f48461a = new a(context);
            }
            aVar = f48461a;
        }
        return aVar;
    }

    public final void a(String str) {
        f48461a = null;
    }
}
