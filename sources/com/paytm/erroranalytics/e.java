package com.paytm.erroranalytics;

import android.content.Context;
import com.paytm.erroranalytics.a.a.a;
import com.paytm.erroranalytics.a.f;
import com.paytm.erroranalytics.data.datasource.g;
import com.paytm.erroranalytics.schedulers.b;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f42808a = "ERROR_SDK_TAG";

    /* renamed from: b  reason: collision with root package name */
    private static e f42809b;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f42810d;

    /* renamed from: c  reason: collision with root package name */
    private Context f42811c;

    private e() {
    }

    public static void a(Context context) throws a {
        Class<e> cls = e.class;
        try {
            synchronized (cls) {
                if (f42809b == null) {
                    e eVar = new e();
                    f42809b = eVar;
                    eVar.f42811c = context;
                    g.a(context);
                    b.a(context);
                    d.a(context);
                    synchronized (g.class) {
                        if (f.f42701b == null) {
                            f fVar = new f(context);
                            f.f42701b = fVar;
                            fVar.f42702a = context;
                        }
                    }
                    b.a(context);
                    cls.getName();
                }
            }
        } catch (a e2) {
            if (f42809b != null) {
                try {
                    b.a().b();
                } catch (a e3) {
                    if (e3.getMessage() != null) {
                        e3.getMessage();
                    }
                    e3.getMessage();
                } catch (Exception e4) {
                    if (e4.getMessage() != null) {
                        e4.getMessage();
                    }
                }
            }
            f42809b = null;
            throw e2;
        }
    }

    public static e a() throws a {
        e eVar = f42809b;
        if (eVar != null) {
            return eVar;
        }
        throw new IllegalStateException("You need to call init() at least once to create the singleton");
    }

    public static a b() throws a {
        return b.a();
    }

    public static boolean c() {
        return f42809b == null || f42810d;
    }

    public final synchronized void a(com.paytm.erroranalytics.c.a aVar) throws a {
        d.a().a(aVar);
    }
}
