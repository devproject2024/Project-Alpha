package net.one97.paytm.upgradeKyc.kycV3;

import android.content.Context;
import kotlin.g.b.k;
import net.one97.paytm.upgradeKyc.kycV3.b.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66033a = new a();

    private a() {
    }

    public static c a(Context context) {
        k.c(context, "context");
        c.a aVar = c.f66172c;
        k.c(context, "appContext");
        if (c.f66173d == null) {
            c.f66173d = new c(context);
        }
        c d2 = c.f66173d;
        if (d2 == null) {
            k.a();
        }
        return d2;
    }
}
