package net.one97.paytm.p2mNewDesign.nativeOTP;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;

public final class d implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final Application f56988a;

    public d(Application application) {
        k.c(application, "application");
        this.f56988a = application;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(c.class)) {
            return (ai) new c(this.f56988a);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
