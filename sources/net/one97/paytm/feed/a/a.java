package net.one97.paytm.feed.a;

import android.app.Activity;
import android.app.PendingIntent;
import androidx.browser.customtabs.b;
import androidx.browser.customtabs.c;
import androidx.browser.customtabs.e;
import androidx.browser.customtabs.f;
import kotlin.g.b.k;

public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public static c f33783a;

    /* renamed from: b  reason: collision with root package name */
    public static e f33784b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f33785c = new a();

    /* renamed from: d  reason: collision with root package name */
    private static f f33786d;

    /* renamed from: e  reason: collision with root package name */
    private static C0555a f33787e;

    /* renamed from: net.one97.paytm.feed.a.a$a  reason: collision with other inner class name */
    public interface C0555a {
    }

    private a() {
    }

    public static f a() {
        c cVar = f33783a;
        if (cVar == null) {
            f33786d = null;
        } else if (f33786d == null) {
            if (cVar == null) {
                k.a();
            }
            f33786d = cVar.a((b) null, (PendingIntent) null);
        }
        return f33786d;
    }

    public static void a(Activity activity) {
        k.c(activity, "activity");
        try {
            if (f33784b != null) {
                e eVar = f33784b;
                if (eVar == null) {
                    k.a();
                }
                activity.unbindService(eVar);
                f33783a = null;
                f33786d = null;
                f33784b = null;
            }
        } catch (Exception unused) {
        }
    }

    public static void a(C0555a aVar) {
        f33787e = aVar;
    }

    public final void a(c cVar) {
        k.c(cVar, "client");
        f33783a = cVar;
        if (cVar == null) {
            k.a();
        }
        cVar.a();
        C0555a aVar = f33787e;
        if (aVar != null && aVar == null) {
            k.a();
        }
    }

    public final void b() {
        f33783a = null;
        f33786d = null;
        C0555a aVar = f33787e;
        if (aVar != null && aVar == null) {
            k.a();
        }
    }
}
