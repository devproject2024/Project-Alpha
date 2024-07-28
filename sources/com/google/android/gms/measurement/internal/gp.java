package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class gp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f12058a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ge f12059b;

    gp(ge geVar, AtomicReference atomicReference) {
        this.f12059b = geVar;
        this.f12058a = atomicReference;
    }

    public final void run() {
        String str;
        synchronized (this.f12058a) {
            try {
                AtomicReference atomicReference = this.f12058a;
                ke H_ = this.f12059b.H_();
                String z = this.f12059b.c().z();
                dn<String> dnVar = o.I;
                if (z == null) {
                    str = dnVar.a(null);
                } else {
                    str = dnVar.a(H_.f12335a.a(z, dnVar.f11797a));
                }
                atomicReference.set(str);
                this.f12058a.notify();
            } catch (Throwable th) {
                this.f12058a.notify();
                throw th;
            }
        }
    }
}
