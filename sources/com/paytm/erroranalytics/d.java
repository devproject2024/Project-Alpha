package com.paytm.erroranalytics;

import android.content.Context;
import com.paytm.erroranalytics.a.a.a;
import com.paytm.erroranalytics.a.f;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class d implements c {

    /* renamed from: c  reason: collision with root package name */
    private static d f42771c;

    /* renamed from: a  reason: collision with root package name */
    private Executor f42772a = Executors.newCachedThreadPool();

    /* renamed from: b  reason: collision with root package name */
    private Context f42773b;

    public static void a(Context context) {
        synchronized (d.class) {
            if (f42771c == null) {
                f42771c = new d(context);
            }
        }
    }

    private d(Context context) {
        this.f42773b = context;
    }

    public static d a() throws a {
        d dVar = f42771c;
        if (dVar != null) {
            return dVar;
        }
        throw new a("You need to call init() at least once to create the singleton");
    }

    public final void a(final com.paytm.erroranalytics.c.a aVar) {
        this.f42772a.execute(new Runnable() {
            public final void run() {
                try {
                    com.paytm.erroranalytics.a.a c2 = f.d().c();
                    c2.f42698a.a(aVar);
                } catch (a unused) {
                    String str = e.f42808a;
                }
            }
        });
    }
}
