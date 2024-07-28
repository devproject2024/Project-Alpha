package net.one97.paytm.upi.registration.c.a;

import android.content.Context;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import net.one97.paytm.upi.registration.c.e;

public final class b implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final net.one97.paytm.upi.profile.b.b f68530a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f68531b;

    public b(net.one97.paytm.upi.profile.b.b bVar, Context context) {
        k.c(bVar, "upiProfileRepository");
        k.c(context, "context");
        this.f68530a = bVar;
        this.f68531b = context;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        return (ai) new e(this.f68530a, this.f68531b);
    }
}
