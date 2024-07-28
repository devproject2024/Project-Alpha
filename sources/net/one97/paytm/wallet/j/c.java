package net.one97.paytm.wallet.j;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;

public final class c implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final Application f70425a;

    public c(Application application) {
        k.c(application, "application");
        this.f70425a = application;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(d.class)) {
            return (ai) new d(this.f70425a);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
