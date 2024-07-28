package com.paytm.erroranalytics.a;

import android.content.Context;
import com.paytm.erroranalytics.a.a.a;

public final class f implements e {

    /* renamed from: b  reason: collision with root package name */
    public static f f42701b;

    /* renamed from: a  reason: collision with root package name */
    public Context f42702a;

    public f(Context context) {
        this.f42702a = context;
    }

    public static e d() throws a {
        f fVar = f42701b;
        if (fVar != null) {
            return fVar;
        }
        throw new a("You need to call init() at least once to create the singleton");
    }

    public final b a() {
        return new b(new com.paytm.erroranalytics.data.a(this.f42702a));
    }

    public final d b() {
        return new d(new com.paytm.erroranalytics.data.a(this.f42702a));
    }

    public final a c() {
        return new a(new com.paytm.erroranalytics.data.a(this.f42702a));
    }
}
