package net.one97.paytm.recharge.common.b.a.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static net.one97.paytm.recharge.common.b.a.b.a f60882a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final a f60883b = new a();

    /* renamed from: c  reason: collision with root package name */
    private static final String f60884c = f60884c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f60885d = 1;

    private a() {
    }

    public static void a(Context context) {
        k.c(context, "context");
        if (f60882a == null) {
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context.applicationContext");
            f60882a = new net.one97.paytm.recharge.common.b.a.b.a(applicationContext, f60884c, f60885d);
        }
    }

    public static SQLiteDatabase b(Context context) {
        k.c(context, "context");
        if (f60882a == null) {
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context.applicationContext");
            a(applicationContext);
        }
        net.one97.paytm.recharge.common.b.a.b.a aVar = f60882a;
        if (aVar != null) {
            return aVar.getWritableDatabase();
        }
        return null;
    }
}
