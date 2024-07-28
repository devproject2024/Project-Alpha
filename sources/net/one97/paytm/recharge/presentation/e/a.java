package net.one97.paytm.recharge.presentation.e;

import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;

public final class a extends al.d {
    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(net.one97.paytm.recharge.presentation.g.a.class)) {
            return (ai) new net.one97.paytm.recharge.presentation.g.a(new net.one97.paytm.recharge.a.a.a());
        }
        throw new Exception("No class found");
    }
}
