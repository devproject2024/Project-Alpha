package net.one97.paytm.upi.a;

import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import net.one97.paytm.upi.registration.b.a.b;

public final class d implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final b f66530a;

    public d(b bVar) {
        k.c(bVar, "upiRegistrationRepository");
        this.f66530a = bVar;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        return (ai) new c(this.f66530a);
    }
}
