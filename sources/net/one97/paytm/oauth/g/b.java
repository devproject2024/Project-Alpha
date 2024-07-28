package net.one97.paytm.oauth.g;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;

public final class b implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final Application f56685a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f56686b;

    public b(Application application, String... strArr) {
        k.c(application, "application");
        k.c(strArr, "params");
        this.f56685a = application;
        this.f56686b = strArr;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(i.class)) {
            return (ai) new i(this.f56685a);
        }
        if (cls.isAssignableFrom(f.class)) {
            return (ai) new f(this.f56685a);
        }
        if (cls.isAssignableFrom(g.class)) {
            return (ai) new g(this.f56685a);
        }
        return (ai) cls;
    }
}
