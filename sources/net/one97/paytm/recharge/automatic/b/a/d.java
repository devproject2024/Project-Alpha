package net.one97.paytm.recharge.automatic.b.a;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.x;

public final class d {
    public static final <T> void a(q qVar, LiveData<T> liveData, b<? super T, x> bVar) {
        k.c(qVar, "$this$observe");
        k.c(bVar, "block");
        if (liveData != null) {
            liveData.observe(qVar, new e(bVar));
        }
    }
}
