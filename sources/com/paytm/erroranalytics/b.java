package com.paytm.erroranalytics;

import android.content.Context;
import com.paytm.erroranalytics.a.a.a;
import com.paytm.erroranalytics.a.f;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class b implements a {

    /* renamed from: c  reason: collision with root package name */
    private static b f42703c;

    /* renamed from: a  reason: collision with root package name */
    private ThreadPoolExecutor f42704a = new ThreadPoolExecutor(3, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    /* renamed from: b  reason: collision with root package name */
    private Context f42705b;

    public static void a(Context context) {
        synchronized (b.class) {
            if (f42703c == null) {
                f42703c = new b(context);
            }
        }
    }

    public static a a() throws a {
        b bVar = f42703c;
        if (bVar != null) {
            return bVar;
        }
        throw new a("You need to call init() at least once to create the singleton");
    }

    private b(Context context) {
        this.f42705b = context;
    }

    public final void a(com.paytm.erroranalytics.c.a.b bVar) {
        try {
            this.f42704a.execute(new com.paytm.erroranalytics.d.a(bVar, f.d().a(), f.d().c()));
        } catch (a e2) {
            if (e2.getMessage() != null) {
                e2.getMessage();
            }
            String str = e.f42808a;
            e2.getMessage();
        } catch (Exception e3) {
            String str2 = e.f42808a;
            e3.getMessage();
        }
    }
}
