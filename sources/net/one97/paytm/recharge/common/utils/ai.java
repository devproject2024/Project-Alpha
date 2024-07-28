package net.one97.paytm.recharge.common.utils;

import android.view.View;
import androidx.lifecycle.LiveData;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.k.i;
import kotlin.x;

public final class ai {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f61507a = {y.a((p) new q(y.a(ai.class, "recharges_release"), "filterValue", "getFilterValue(Landroid/view/View;)Ljava/lang/String;"))};

    /* renamed from: b  reason: collision with root package name */
    private static final ah f61508b = new ah();

    public static final void a(View view) {
        k.c(view, "$this$visible");
        view.setVisibility(0);
    }

    public static final void b(View view) {
        k.c(view, "$this$gone");
        view.setVisibility(8);
    }

    public static final <T, L extends LiveData<T>> void a(androidx.lifecycle.q qVar, L l, b<? super T, x> bVar) {
        k.c(qVar, "$this$observe");
        k.c(l, "liveData");
        k.c(bVar, "body");
        l.observe(qVar, new aj(bVar));
    }

    public static final String a(String str, String str2) {
        CharSequence charSequence = str;
        if (charSequence == null || kotlin.m.p.a(charSequence)) {
            return str2 == null ? "" : str2;
        }
        return str;
    }

    public static final String c(View view) {
        k.c(view, "$this$filterValue");
        ah ahVar = f61508b;
        k.c(f61507a[0], "property");
        return (String) ahVar.f61506a.get(view);
    }

    public static final void a(View view, String str) {
        k.c(view, "$this$filterValue");
        ah ahVar = f61508b;
        k.c(f61507a[0], "property");
        if (str != null) {
            ahVar.f61506a.put(view, str);
        }
    }
}
