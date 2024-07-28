package net.one97.paytm.recharge.widgets.a;

import android.content.DialogInterface;
import kotlin.g.b.k;

public final class b implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f64960a;

    /* renamed from: b  reason: collision with root package name */
    private final net.one97.paytm.recharge.widgets.b.b f64961b;

    public b(String str, net.one97.paytm.recharge.widgets.b.b bVar) {
        k.c(str, "tag");
        k.c(bVar, "listener");
        this.f64960a = str;
        this.f64961b = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f64961b.a(this.f64960a, dialogInterface, i2);
    }
}
