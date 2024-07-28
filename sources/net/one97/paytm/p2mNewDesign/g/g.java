package net.one97.paytm.p2mNewDesign.g;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;

public final class g implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final Application f51294a;

    public g(Application application) {
        k.c(application, "application");
        this.f51294a = application;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(f.class)) {
            return (ai) new f(this.f51294a);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
