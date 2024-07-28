package net.one97.paytm.passbook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.a.a;
import java.lang.reflect.InvocationTargetException;
import net.one97.paytm.passbook.mapping.f;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static BroadcastReceiver f57232a = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            a.a(d.f57233b.f57234c.b()).a(d.f57232a);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static volatile d f57233b;

    /* renamed from: c  reason: collision with root package name */
    private f f57234c;

    private d() {
    }

    public static void a(f fVar) {
        if (f57233b == null) {
            d dVar = new d();
            f57233b = dVar;
            dVar.f57234c = fVar;
        }
        a.a(f57233b.f57234c.b()).a(f57232a, new IntentFilter("passbook_key_fresh_app_start"));
    }

    private static d d() {
        if (f57233b == null) {
            synchronized (d.class) {
                if (f57233b == null) {
                    e();
                }
            }
            if (f57233b == null) {
                throw new RuntimeException("getInstance() called before PassbookImplProvider's init()");
            }
        }
        return f57233b;
    }

    private static void e() {
        try {
            Class.forName("net.one97.paytm.dynamic.module.passbook.PassbookImplProvider").getDeclaredMethod("init", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
    }

    public static boolean a() {
        if (f57233b == null) {
            e();
        }
        return f57233b == null;
    }

    public static f b() {
        return d().f57234c;
    }
}
