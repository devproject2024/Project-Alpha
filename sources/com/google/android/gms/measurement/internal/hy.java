package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

final class hy implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f12155a = true;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ boolean f12156b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ zzan f12157c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ zzm f12158d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f12159e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ hm f12160f;

    hy(hm hmVar, boolean z, zzan zzan, zzm zzm, String str) {
        this.f12160f = hmVar;
        this.f12156b = z;
        this.f12157c = zzan;
        this.f12158d = zzm;
        this.f12159e = str;
    }

    public final void run() {
        dq dqVar = this.f12160f.f12120b;
        if (dqVar == null) {
            this.f12160f.J_().f11828c.a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f12155a) {
            this.f12160f.a(dqVar, (AbstractSafeParcelable) this.f12156b ? null : this.f12157c, this.f12158d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f12159e)) {
                    dqVar.a(this.f12157c, this.f12158d);
                } else {
                    dqVar.a(this.f12157c, this.f12159e, this.f12160f.J_().O_());
                }
            } catch (RemoteException e2) {
                this.f12160f.J_().f11828c.a("Failed to send event to the service", e2);
            }
        }
        this.f12160f.D();
    }
}
