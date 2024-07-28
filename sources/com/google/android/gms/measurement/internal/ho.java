package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

final class ho implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f12128a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzkl f12129b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ zzm f12130c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ hm f12131d;

    ho(hm hmVar, boolean z, zzkl zzkl, zzm zzm) {
        this.f12131d = hmVar;
        this.f12128a = z;
        this.f12129b = zzkl;
        this.f12130c = zzm;
    }

    public final void run() {
        dq dqVar = this.f12131d.f12120b;
        if (dqVar == null) {
            this.f12131d.J_().f11828c.a("Discarding data. Failed to set user attribute");
            return;
        }
        this.f12131d.a(dqVar, (AbstractSafeParcelable) this.f12128a ? null : this.f12129b, this.f12130c);
        this.f12131d.D();
    }
}
