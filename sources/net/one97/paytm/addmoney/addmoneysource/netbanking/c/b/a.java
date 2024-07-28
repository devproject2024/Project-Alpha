package net.one97.paytm.addmoney.addmoneysource.netbanking.c.b;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.paytm.network.f;
import net.one97.paytm.addmoney.h;

public final class a implements net.one97.paytm.addmoney.addmoneysource.netbanking.c.a {

    /* renamed from: c  reason: collision with root package name */
    private static a f48331c;

    /* renamed from: a  reason: collision with root package name */
    private Context f48332a;

    /* renamed from: b  reason: collision with root package name */
    private Fragment f48333b;

    private a(Context context, Fragment fragment) {
        this.f48332a = context;
        this.f48333b = fragment;
    }

    public static synchronized a a(Context context, Fragment fragment) {
        a aVar;
        synchronized (a.class) {
            if (f48331c == null) {
                f48331c = new a(context, fragment);
            }
            aVar = f48331c;
        }
        return aVar;
    }

    public final void a(String str) {
        f.b(this.f48332a).cancelAll((Object) str);
        f48331c = null;
    }

    public final void a(h hVar, String str) {
        new net.one97.paytm.addmoney.utils.a(this.f48332a, this.f48333b).a(hVar);
    }

    public final void a(h hVar, String str, String str2, int i2, String str3) {
        new net.one97.paytm.addmoney.utils.a(this.f48332a, this.f48333b).a(hVar, str, str2, i2, str3);
    }
}
