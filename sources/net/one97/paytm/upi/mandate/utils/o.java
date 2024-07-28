package net.one97.paytm.upi.mandate.utils;

import android.content.Context;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.mandate.confirmation.c;
import net.one97.paytm.upi.mandate.update.d;
import net.one97.paytm.upi.profile.b.b;

public final class o extends al.d {
    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        i a2 = i.a();
        k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        h c2 = a2.c();
        k.a((Object) c2, "PaytmUpiSdk.getInstance().onLoadActivityListener");
        Context c3 = c2.c();
        if (cls.isAssignableFrom(c.class)) {
            k.a((Object) c3, "applicationContext");
            b a3 = g.a();
            k.a((Object) a3, "Injection.provideUpiProf…itory(applicationContext)");
            net.one97.paytm.upi.mandate.data.b a4 = g.a(c3);
            k.a((Object) a4, "Injection.provideUpiMand…itory(applicationContext)");
            return (ai) new c(c3, a3, a4, new i(c3));
        } else if (cls.isAssignableFrom(d.class)) {
            k.a((Object) c3, "applicationContext");
            b a5 = g.a();
            k.a((Object) a5, "Injection.provideUpiProf…itory(applicationContext)");
            net.one97.paytm.upi.mandate.data.b a6 = g.a(c3);
            k.a((Object) a6, "Injection.provideUpiMand…itory(applicationContext)");
            return (ai) new d(c3, a5, a6, new i(c3));
        } else if (cls.isAssignableFrom(net.one97.paytm.upi.mandate.p2p.c.class)) {
            b a7 = g.a();
            k.a((Object) a7, "Injection.provideUpiProf…itory(applicationContext)");
            return (ai) new net.one97.paytm.upi.mandate.p2p.c(a7);
        } else {
            throw new IllegalStateException("no matching class found for this factory");
        }
    }
}
