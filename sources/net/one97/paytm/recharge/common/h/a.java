package net.one97.paytm.recharge.common.h;

import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import net.one97.paytm.recharge.common.b.c;
import net.one97.paytm.recharge.common.utils.w;

public final class a implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final c f61406a;

    /* renamed from: b  reason: collision with root package name */
    private final w f61407b;

    public a(c cVar, w wVar) {
        k.c(cVar, "rechargeRepo");
        k.c(wVar, "rechargeProceedHelper");
        this.f61406a = cVar;
        this.f61407b = wVar;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        return (ai) new f(this.f61406a, this.f61407b);
    }
}
