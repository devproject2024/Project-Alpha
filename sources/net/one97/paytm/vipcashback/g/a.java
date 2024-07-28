package net.one97.paytm.vipcashback.g;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;

public final class a implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final Application f21009a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f21010b;

    public a(Application application, String... strArr) {
        k.c(application, "application");
        k.c(strArr, "params");
        this.f21009a = application;
        this.f21010b = strArr;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(d.class)) {
            Application application = this.f21009a;
            String str = this.f21010b[0];
            if (str == null) {
                k.a();
            }
            String str2 = this.f21010b[1];
            if (str2 == null) {
                k.a();
            }
            String[] strArr = this.f21010b;
            return (ai) new d(application, str, str2, strArr[2], strArr[3]);
        } else if (cls.isAssignableFrom(b.class)) {
            return (ai) new b(this.f21009a);
        } else {
            return (ai) cls;
        }
    }
}
