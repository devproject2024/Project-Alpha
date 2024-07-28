package net.one97.paytm.locale.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import net.one97.paytm.landingpage.R;

public final class f extends ContextThemeWrapper {

    /* renamed from: a  reason: collision with root package name */
    private g f53107a;

    public static f a(Context context, c cVar, n nVar) {
        return new f(new g(context, new i(context.getResources(), cVar), nVar));
    }

    private f(g gVar) {
        super(gVar, R.style.Theme_AppCompat_Empty);
        this.f53107a = gVar;
    }

    public final Resources getResources() {
        return this.f53107a.getResources();
    }
}
