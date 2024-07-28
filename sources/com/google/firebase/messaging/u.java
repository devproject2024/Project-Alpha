package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

final class u {

    /* renamed from: a  reason: collision with root package name */
    private static WeakReference<u> f39032a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f39033b;

    /* renamed from: c  reason: collision with root package name */
    private q f39034c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f39035d;

    private u(SharedPreferences sharedPreferences, Executor executor) {
        this.f39035d = executor;
        this.f39033b = sharedPreferences;
    }

    private final synchronized void b() {
        this.f39034c = q.a(this.f39033b, "topic_operation_queue", AppConstants.COMMA, this.f39035d);
    }

    public static synchronized u a(Context context, Executor executor) {
        u uVar;
        synchronized (u.class) {
            uVar = null;
            if (f39032a != null) {
                uVar = (u) f39032a.get();
            }
            if (uVar == null) {
                uVar = new u(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                uVar.b();
                f39032a = new WeakReference<>(uVar);
            }
        }
        return uVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized t a() {
        return t.a(this.f39034c.a());
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean a(t tVar) {
        return this.f39034c.a(tVar.f39031c);
    }
}
