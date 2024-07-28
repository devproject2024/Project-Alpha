package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p001firebaseperf.ar;
import com.google.firebase.perf.internal.a;
import java.lang.ref.WeakReference;

public class f implements a.C0658a {
    private a zzci;
    private ar zzcj;
    private boolean zzck;
    private WeakReference<a.C0658a> zzcl;

    protected f() {
        this(a.a());
    }

    protected f(a aVar) {
        this.zzcj = ar.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.zzck = false;
        this.zzci = aVar;
        this.zzcl = new WeakReference<>(this);
    }

    /* access modifiers changed from: protected */
    public final void zzay() {
        if (!this.zzck) {
            this.zzcj = this.zzci.f39187c;
            a aVar = this.zzci;
            WeakReference<a.C0658a> weakReference = this.zzcl;
            synchronized (aVar.f39188d) {
                aVar.f39188d.add(weakReference);
            }
            this.zzck = true;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzaz() {
        if (this.zzck) {
            a aVar = this.zzci;
            WeakReference<a.C0658a> weakReference = this.zzcl;
            synchronized (aVar.f39188d) {
                aVar.f39188d.remove(weakReference);
            }
            this.zzck = false;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzc(int i2) {
        this.zzci.f39186b.addAndGet(1);
    }

    public void zza(ar arVar) {
        if (this.zzcj == ar.APPLICATION_PROCESS_STATE_UNKNOWN) {
            this.zzcj = arVar;
        } else if (this.zzcj != arVar && arVar != ar.APPLICATION_PROCESS_STATE_UNKNOWN) {
            this.zzcj = ar.FOREGROUND_BACKGROUND;
        }
    }

    public final ar zzal() {
        return this.zzcj;
    }
}
