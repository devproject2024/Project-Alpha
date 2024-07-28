package net.one97.paytm.recharge.common.utils;

import android.view.ViewTreeObserver;
import kotlin.g.b.k;
import net.one97.paytm.recharge.common.e.ad;

public final class u implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f61764a;

    /* renamed from: b  reason: collision with root package name */
    private final ad f61765b;

    public u(String str, ad adVar) {
        k.c(str, "tag");
        k.c(adVar, "listener");
        this.f61764a = str;
        this.f61765b = adVar;
    }

    public final void onGlobalLayout() {
        this.f61765b.a(this.f61764a, this);
    }
}
