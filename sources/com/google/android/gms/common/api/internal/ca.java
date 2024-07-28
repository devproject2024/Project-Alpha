package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.l;

final class ca implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ l f8501a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ bx f8502b;

    ca(bx bxVar, l lVar) {
        this.f8502b = bxVar;
        this.f8501a = lVar;
    }

    public final void run() {
        try {
            BasePendingResult.f8384c.set(Boolean.TRUE);
            this.f8502b.f8494i.sendMessage(this.f8502b.f8494i.obtainMessage(0, this.f8502b.f8486a.a()));
            BasePendingResult.f8384c.set(Boolean.FALSE);
            bx.b(this.f8501a);
            e eVar = (e) this.f8502b.f8491f.get();
            if (eVar != null) {
                eVar.b(this.f8502b);
            }
        } catch (RuntimeException e2) {
            this.f8502b.f8494i.sendMessage(this.f8502b.f8494i.obtainMessage(1, e2));
            BasePendingResult.f8384c.set(Boolean.FALSE);
            bx.b(this.f8501a);
            e eVar2 = (e) this.f8502b.f8491f.get();
            if (eVar2 != null) {
                eVar2.b(this.f8502b);
            }
        } catch (Throwable th) {
            BasePendingResult.f8384c.set(Boolean.FALSE);
            bx.b(this.f8501a);
            e eVar3 = (e) this.f8502b.f8491f.get();
            if (eVar3 != null) {
                eVar3.b(this.f8502b);
            }
            throw th;
        }
    }
}
