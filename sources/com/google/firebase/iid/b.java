package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.n;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.h;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f38854a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static aw f38855b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f38856c;

    /* renamed from: d  reason: collision with root package name */
    private final ExecutorService f38857d;

    public b(Context context, ExecutorService executorService) {
        this.f38856c = context;
        this.f38857d = executorService;
    }

    public final Task<Integer> a(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        boolean z = false;
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        Context context = this.f38856c;
        boolean z2 = n.f() && context.getApplicationInfo().targetSdkVersion >= 26;
        if ((intent.getFlags() & 268435456) != 0) {
            z = true;
        }
        if (!z2 || z) {
            return h.a((Executor) this.f38857d, new c(context, intent)).b(this.f38857d, new d(context, intent));
        }
        return b(context, intent);
    }

    private static Task<Integer> b(Context context, Intent intent) {
        Log.isLoggable("FirebaseInstanceId", 3);
        return a(context, "com.google.firebase.MESSAGING_EVENT").a(intent).a(g.a(), e.f38862a);
    }

    private static aw a(Context context, String str) {
        aw awVar;
        synchronized (f38854a) {
            if (f38855b == null) {
                f38855b = new aw(context, str);
            }
            awVar = f38855b;
        }
        return awVar;
    }

    static final /* synthetic */ Integer a() throws Exception {
        return -1;
    }

    static final /* synthetic */ Task a(Context context, Intent intent, Task task) throws Exception {
        return (!n.f() || ((Integer) task.d()).intValue() != 402) ? task : b(context, intent).a(g.a(), f.f38863a);
    }

    static final /* synthetic */ Integer b() throws Exception {
        return 403;
    }

    static final /* synthetic */ Integer a(Context context, Intent intent) throws Exception {
        aq a2 = aq.a();
        Log.isLoggable("FirebaseInstanceId", 3);
        a2.f38826c.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return Integer.valueOf(a2.a(context, intent2));
    }
}
