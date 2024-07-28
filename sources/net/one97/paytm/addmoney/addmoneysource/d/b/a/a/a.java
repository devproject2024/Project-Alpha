package net.one97.paytm.addmoney.addmoneysource.d.b.a.a;

import android.content.Context;
import net.one97.paytm.addmoney.i;
import net.one97.paytm.addmoney.utils.h;

public final class a implements net.one97.paytm.addmoney.addmoneysource.d.b.a.a {

    /* renamed from: b  reason: collision with root package name */
    private static a f48238b;

    /* renamed from: a  reason: collision with root package name */
    private Context f48239a;

    public final void a(i iVar, String str) {
    }

    private a(Context context) {
        this.f48239a = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f48238b == null) {
                f48238b = new a(context);
            }
            aVar = f48238b;
        }
        return aVar;
    }

    public final void a(String str) {
        f48238b = null;
    }

    public final boolean b(String str) {
        return h.a(this.f48239a.getApplicationContext()).b("is_upi_user", false, true);
    }
}
