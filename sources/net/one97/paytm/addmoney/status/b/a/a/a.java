package net.one97.paytm.addmoney.status.b.a.a;

import android.content.Context;

public final class a implements net.one97.paytm.addmoney.status.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static a f48637a;

    /* renamed from: b  reason: collision with root package name */
    private Context f48638b;

    private a(Context context) {
        this.f48638b = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f48637a == null) {
                f48637a = new a(context);
            }
            aVar = f48637a;
        }
        return aVar;
    }

    public final void a(String str) {
        f48637a = null;
    }
}
