package net.one97.paytm.passbook.c;

import android.app.Activity;
import kotlin.g.b.k;
import net.one97.paytm.passbook.d;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private Activity f57094a;

    /* renamed from: b  reason: collision with root package name */
    private a f57095b;

    public b(Activity activity, a aVar) {
        k.c(activity, "activity");
        k.c(aVar, "listener");
        this.f57094a = activity;
        this.f57095b = aVar;
    }

    public final void a(String str) {
        k.c(str, "passcodeEnabledGTMKey");
        d.b().a(this.f57094a, this.f57095b, str);
    }
}
