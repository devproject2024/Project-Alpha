package net.one97.paytm.locale.b;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;

final class g extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private h f53108a;

    /* renamed from: b  reason: collision with root package name */
    private n f53109b;

    /* renamed from: c  reason: collision with root package name */
    private i f53110c;

    g(Context context, i iVar, n nVar) {
        super(new b(context, iVar));
        this.f53109b = nVar;
        this.f53110c = iVar;
    }

    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return super.getSystemService(str);
        }
        if (this.f53108a == null) {
            this.f53108a = new h(LayoutInflater.from(getBaseContext()), this, this.f53109b);
        }
        return this.f53108a;
    }
}
