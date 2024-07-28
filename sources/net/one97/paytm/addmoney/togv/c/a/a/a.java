package net.one97.paytm.addmoney.togv.c.a.a;

import android.app.Activity;
import android.content.Context;
import net.one97.paytm.addmoney.h;

public final class a implements net.one97.paytm.addmoney.togv.c.a.a {

    /* renamed from: c  reason: collision with root package name */
    private static a f48675c;

    /* renamed from: a  reason: collision with root package name */
    private Context f48676a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f48677b;

    public final void a(h hVar, String str) {
    }

    public final void a(h hVar, String str, double d2, String str2, boolean z) {
    }

    public final void a(h hVar, String str, String str2) {
    }

    public final void a(h hVar, String str, String str2, double d2, String str3, String str4, String str5, boolean z) {
    }

    public final void a(h hVar, String str, String str2, boolean z) {
    }

    private a(Context context, Activity activity) {
        this.f48676a = context;
        this.f48677b = activity;
    }

    public static synchronized a a(Context context, Activity activity) {
        a aVar;
        synchronized (a.class) {
            if (f48675c == null) {
                f48675c = new a(context, activity);
            }
            aVar = f48675c;
        }
        return aVar;
    }

    public final void a(String str) {
        f48675c = null;
    }
}
