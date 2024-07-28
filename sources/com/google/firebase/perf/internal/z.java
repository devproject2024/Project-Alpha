package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p001firebaseperf.v;
import com.google.android.gms.internal.p001firebaseperf.zzbg;
import java.util.concurrent.TimeUnit;

final class z {

    /* renamed from: a  reason: collision with root package name */
    private static final long f39245a = TimeUnit.MINUTES.toMicros(1);

    /* renamed from: b  reason: collision with root package name */
    private long f39246b = 500;

    /* renamed from: c  reason: collision with root package name */
    private long f39247c = 100;

    /* renamed from: d  reason: collision with root package name */
    private zzbg f39248d = new zzbg();

    /* renamed from: e  reason: collision with root package name */
    private long f39249e = 500;

    /* renamed from: f  reason: collision with root package name */
    private final v f39250f;

    /* renamed from: g  reason: collision with root package name */
    private long f39251g;

    /* renamed from: h  reason: collision with root package name */
    private long f39252h;

    /* renamed from: i  reason: collision with root package name */
    private long f39253i;
    private long j;
    private final boolean k;

    z(v vVar, RemoteConfigManager remoteConfigManager, aa aaVar, boolean z) {
        this.f39250f = vVar;
        long zzc = remoteConfigManager.zzc(aaVar.zzbv(), 0);
        zzc = zzc == 0 ? (long) aaVar.zzbr() : zzc;
        long zzc2 = remoteConfigManager.zzc(aaVar.zzbw(), (long) aaVar.zzbs());
        this.f39251g = zzc2 / zzc;
        this.f39252h = zzc2;
        if (!(this.f39252h == ((long) aaVar.zzbs()) && this.f39251g == ((long) (aaVar.zzbs() / aaVar.zzbr())))) {
            String.format("Foreground %s logging rate:%d, burst capacity:%d", new Object[]{aaVar.toString(), Long.valueOf(this.f39251g), Long.valueOf(this.f39252h)});
        }
        long zzc3 = remoteConfigManager.zzc(aaVar.zzbx(), 0);
        zzc3 = zzc3 == 0 ? (long) aaVar.zzbt() : zzc3;
        long zzc4 = remoteConfigManager.zzc(aaVar.zzby(), (long) aaVar.zzbu());
        this.f39253i = zzc4 / zzc3;
        this.j = zzc4;
        if (!(this.j == ((long) aaVar.zzbu()) && this.f39253i == ((long) (aaVar.zzbu() / aaVar.zzbt())))) {
            String.format("Background %s logging rate:%d, capacity:%d", new Object[]{aaVar.toString(), Long.valueOf(this.f39253i), Long.valueOf(this.j)});
        }
        this.k = z;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean a() {
        zzbg zzbg = new zzbg();
        this.f39249e = Math.min(this.f39249e + Math.max(0, (this.f39248d.a(zzbg) * this.f39247c) / f39245a), this.f39246b);
        if (this.f39249e <= 0) {
            return false;
        }
        this.f39249e--;
        this.f39248d = zzbg;
        return true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(boolean z) {
        this.f39247c = z ? this.f39251g : this.f39253i;
        this.f39246b = z ? this.f39252h : this.j;
    }
}
