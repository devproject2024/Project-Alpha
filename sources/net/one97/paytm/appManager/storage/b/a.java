package net.one97.paytm.appManager.storage.b;

import android.content.Context;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytm.utility.f;
import kotlin.g.b.k;
import net.one97.paytm.appManager.d.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f49051a = f49051a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f49052b = f49052b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f49053c = new a();

    /* renamed from: d  reason: collision with root package name */
    private static final String f49054d = f49054d;

    private a() {
    }

    public static long a(Context context) {
        k.c(context, "context");
        return c(context).b(f49054d, -1, false);
    }

    public static void a(Context context, long j) {
        k.c(context, "context");
        c(context).a(f49054d, j, false);
    }

    public static boolean b(Context context) {
        k.c(context, "context");
        c cVar = c.f49045a;
        return c.a();
    }

    public static void a(boolean z) {
        c cVar = c.f49045a;
        c.a(z);
    }

    public static com.paytm.b.a.a c(Context context) {
        a.C0708a aVar = com.paytm.b.a.a.f42641a;
        return a.C0708a.a(context, a.c.APP_MANAGER, f.a.PREF_APP_MANAGER);
    }
}
