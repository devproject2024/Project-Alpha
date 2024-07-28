package com.google.android.gms.vision.clearcut;

import com.google.android.gms.internal.vision.bt;

final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ int f12619a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ bt.o f12620b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ DynamiteClearcutLogger f12621c;

    a(DynamiteClearcutLogger dynamiteClearcutLogger, int i2, bt.o oVar) {
        this.f12621c = dynamiteClearcutLogger;
        this.f12619a = i2;
        this.f12620b = oVar;
    }

    public final void run() {
        this.f12621c.zzbq.zzb(this.f12619a, this.f12620b);
    }
}
