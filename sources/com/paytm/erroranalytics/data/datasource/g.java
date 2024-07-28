package com.paytm.erroranalytics.data.datasource;

import android.content.Context;
import com.paytm.erroranalytics.a.a.a;
import com.paytm.erroranalytics.data.b.d;
import com.paytm.erroranalytics.data.datasource.dao.sqlite.AppDataBase;

public class g implements c {

    /* renamed from: c  reason: collision with root package name */
    private static g f42805c;

    /* renamed from: a  reason: collision with root package name */
    private Context f42806a;

    /* renamed from: b  reason: collision with root package name */
    private AppDataBase f42807b;

    private g() {
    }

    public static void a(Context context) {
        synchronized (g.class) {
            if (f42805c == null) {
                g gVar = new g(context);
                f42805c = gVar;
                gVar.f42806a = context;
                gVar.f42807b = AppDataBase.a(context);
            }
        }
    }

    public static c d() throws a {
        g gVar = f42805c;
        if (gVar != null) {
            return gVar;
        }
        throw new a("You need to call initStoreFactory() at least once to create the singleton");
    }

    private g(Context context) {
        this.f42806a = context;
        this.f42807b = AppDataBase.a(context);
    }

    public final d a() {
        return new e(this.f42807b.a());
    }

    public final f b() {
        return new a(new d(this.f42806a));
    }

    public final Class<b> c() {
        return b.class;
    }
}
