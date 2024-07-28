package net.one97.paytm.locale.b;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;

final class b extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private Resources f53097a;

    public b(Context context, Resources resources) {
        super(context);
        this.f53097a = resources;
    }

    public final Resources getResources() {
        return this.f53097a;
    }
}
