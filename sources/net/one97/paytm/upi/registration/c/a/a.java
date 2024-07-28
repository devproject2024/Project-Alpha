package net.one97.paytm.upi.registration.c.a;

import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import net.one97.paytm.upi.profile.b.b;

public final class a implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final b f68527a;

    public a(b bVar) {
        k.c(bVar, "upiProfileRepository");
        this.f68527a = bVar;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        return (ai) new net.one97.paytm.upi.registration.c.a(this.f68527a);
    }
}
