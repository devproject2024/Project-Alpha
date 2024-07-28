package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.internal.l;

final class bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ConnectionResult f8464a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ f.b f8465b;

    bi(f.b bVar, ConnectionResult connectionResult) {
        this.f8465b = bVar;
        this.f8464a = connectionResult;
    }

    public final void run() {
        f.a aVar = (f.a) f.this.p.get(this.f8465b.f8603b);
        if (aVar != null) {
            if (this.f8464a.b()) {
                f.b bVar = this.f8465b;
                bVar.f8604c = true;
                if (bVar.f8602a.i()) {
                    this.f8465b.a();
                    return;
                }
                try {
                    this.f8465b.f8602a.a((l) null, this.f8465b.f8602a.l());
                } catch (SecurityException unused) {
                    aVar.onConnectionFailed(new ConnectionResult(10));
                }
            } else {
                aVar.onConnectionFailed(this.f8464a);
            }
        }
    }
}
