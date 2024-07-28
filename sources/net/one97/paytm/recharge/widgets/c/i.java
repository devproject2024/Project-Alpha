package net.one97.paytm.recharge.widgets.c;

import android.os.AsyncTask;
import kotlin.g.a.a;
import kotlin.g.b.k;
import kotlin.x;

public final class i extends AsyncTask<Void, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    private final a<x> f64976a;

    public i(a<x> aVar) {
        k.c(aVar, "handler");
        this.f64976a = aVar;
    }

    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        k.c((Void[]) objArr, "params");
        this.f64976a.invoke();
        return null;
    }
}
