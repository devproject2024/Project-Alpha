package net.one97.paytm.paymentsBank.si.f.a;

import android.content.Context;
import net.one97.paytm.paymentsBank.si.f.a;

public final class a implements net.one97.paytm.paymentsBank.si.f.a {

    /* renamed from: a  reason: collision with root package name */
    private static a f18897a;

    /* renamed from: b  reason: collision with root package name */
    private Context f18898b;

    public final void a(a.C0325a aVar, String str, String str2, boolean z) {
    }

    public final void a(a.C0325a aVar, a.b bVar, int i2, int i3) {
    }

    private a(Context context) {
        this.f18898b = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f18897a == null) {
                f18897a = new a(context);
            }
            aVar = f18897a;
        }
        return aVar;
    }
}
