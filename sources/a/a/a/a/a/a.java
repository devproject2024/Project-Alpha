package a.a.a.a.a;

import a.a.a.a.a.a.d;
import a.a.a.a.a.c.b;
import a.a.a.a.a.c.e;
import a.a.a.a.a.e.c;
import android.content.Context;
import android.os.Handler;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static b f670a = new b();

    public static String a() {
        return "1.2.17-Paytm";
    }

    public static boolean b() {
        return f670a.f676a;
    }

    public static boolean a(Context context) {
        b bVar = f670a;
        Context applicationContext = context.getApplicationContext();
        c.a((Object) applicationContext, "Application Context cannot be null");
        if (!bVar.f676a) {
            bVar.f676a = true;
            e a2 = e.a();
            a2.f727b = new d(new Handler(), applicationContext, new a.a.a.a.a.a.a(), a2);
            b.a().f714a = applicationContext.getApplicationContext();
            a.a.a.a.a.e.b.a(applicationContext);
            a.a.a.a.a.c.c.a().f721a = applicationContext != null ? applicationContext.getApplicationContext() : null;
        }
        return true;
    }
}
