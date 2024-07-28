package net.one97.paytm.addmoney.addmoneysource.b.c.b;

import android.content.Context;
import androidx.fragment.app.Fragment;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.addmoney.j;
import net.one97.paytm.upi.g.d;

public final class a implements net.one97.paytm.addmoney.addmoneysource.b.c.a {

    /* renamed from: c  reason: collision with root package name */
    private static a f48193c;

    /* renamed from: a  reason: collision with root package name */
    private Context f48194a;

    /* renamed from: b  reason: collision with root package name */
    private Fragment f48195b;

    private a(Context context, Fragment fragment) {
        this.f48194a = context;
        this.f48195b = fragment;
    }

    public static synchronized a a(Context context, Fragment fragment) {
        a aVar;
        synchronized (a.class) {
            if (f48193c == null) {
                f48193c = new a(context, fragment);
            }
            aVar = f48193c;
        }
        return aVar;
    }

    public final void a(String str) {
        d.b(this.f48194a).cancelAll((Object) str);
        f48193c = null;
    }

    public final void a(h hVar, String str) {
        j.a(this.f48194a, this.f48195b).b(hVar, str);
    }
}
