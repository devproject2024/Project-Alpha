package net.one97.paytm.p2mNewDesign.i;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;

public final class b implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final Application f51297a;

    public b(Application application) {
        k.c(application, "application");
        this.f51297a = application;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(a.class)) {
            return (ai) new a(this.f51297a);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
