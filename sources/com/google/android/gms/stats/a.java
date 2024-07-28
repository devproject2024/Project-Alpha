package com.google.android.gms.stats;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.p;
import com.google.android.gms.common.util.r;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    public static ScheduledExecutorService k;
    private static volatile C0162a o = new b();

    /* renamed from: a  reason: collision with root package name */
    public final Object f12456a;

    /* renamed from: b  reason: collision with root package name */
    public final PowerManager.WakeLock f12457b;

    /* renamed from: c  reason: collision with root package name */
    public WorkSource f12458c;

    /* renamed from: d  reason: collision with root package name */
    public final int f12459d;

    /* renamed from: e  reason: collision with root package name */
    public final String f12460e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f12461f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12462g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, Integer[]> f12463h;

    /* renamed from: i  reason: collision with root package name */
    public int f12464i;
    public AtomicInteger j;
    private final String l;
    private final String m;
    private final Set<Future<?>> n;

    /* renamed from: com.google.android.gms.stats.a$a  reason: collision with other inner class name */
    public interface C0162a {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(Context context, String str) {
        this(context, str, context == null ? null : context.getPackageName());
    }

    private a(Context context, String str, String str2) {
        this(context, str, str2, (byte) 0);
    }

    private a(Context context, String str, String str2, byte b2) {
        this.f12456a = this;
        this.f12462g = true;
        this.f12463h = new HashMap();
        this.n = Collections.synchronizedSet(new HashSet());
        this.j = new AtomicInteger(0);
        s.a(context, (Object) "WakeLock: context must not be null");
        s.a(str, (Object) "WakeLock: wakeLockName must not be empty");
        this.f12459d = 1;
        this.l = null;
        this.m = null;
        this.f12461f = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            this.f12460e = valueOf.length() != 0 ? "*gcore*:".concat(valueOf) : new String("*gcore*:");
        } else {
            this.f12460e = str;
        }
        this.f12457b = ((PowerManager) context.getSystemService("power")).newWakeLock(1, str);
        if (r.a(context)) {
            this.f12458c = r.a(context, p.a(str2) ? context.getPackageName() : str2);
            WorkSource workSource = this.f12458c;
            if (workSource != null && r.a(this.f12461f)) {
                WorkSource workSource2 = this.f12458c;
                if (workSource2 != null) {
                    workSource2.add(workSource);
                } else {
                    this.f12458c = workSource;
                }
                try {
                    this.f12457b.setWorkSource(this.f12458c);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
                    Log.wtf("WakeLock", e2.toString());
                }
            }
        }
        if (k == null) {
            k = com.google.android.gms.common.b.a.a().a();
        }
    }

    public final void a() {
        if (this.f12457b.isHeld()) {
            try {
                this.f12457b.release();
            } catch (RuntimeException e2) {
                if (e2.getClass().equals(RuntimeException.class)) {
                    String.valueOf(this.f12460e).concat(" was already released!");
                } else {
                    throw e2;
                }
            }
            this.f12457b.isHeld();
        }
    }

    public final String b() {
        if (!this.f12462g) {
            return this.l;
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            return null;
        }
        return this.l;
    }
}
