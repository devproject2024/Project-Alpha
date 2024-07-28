package net.one97.paytm.addmoney.status.b.a.b;

import android.content.Context;
import net.one97.paytm.upi.g.d;

public final class a implements net.one97.paytm.addmoney.status.b.a.a {

    /* renamed from: b  reason: collision with root package name */
    private static a f48642b;

    /* renamed from: a  reason: collision with root package name */
    public Context f48643a;

    private a(Context context) {
        this.f48643a = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f48642b == null) {
                f48642b = new a(context);
            }
            aVar = f48642b;
        }
        return aVar;
    }

    public final void a(String str) {
        d.b(this.f48643a).cancelAll((Object) str);
        f48642b = null;
    }
}
