package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class ct implements bl {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ cr f8549a;

    private ct(cr crVar) {
        this.f8549a = crVar;
    }

    public final void a(Bundle bundle) {
        this.f8549a.f8546g.lock();
        try {
            cr crVar = this.f8549a;
            if (crVar.f8542c == null) {
                crVar.f8542c = bundle;
            } else if (bundle != null) {
                crVar.f8542c.putAll(bundle);
            }
            this.f8549a.f8543d = ConnectionResult.f8333a;
            cr.a(this.f8549a);
        } finally {
            this.f8549a.f8546g.unlock();
        }
    }

    public final void a(ConnectionResult connectionResult) {
        this.f8549a.f8546g.lock();
        try {
            this.f8549a.f8543d = connectionResult;
            cr.a(this.f8549a);
        } finally {
            this.f8549a.f8546g.unlock();
        }
    }

    public final void a(int i2, boolean z) {
        this.f8549a.f8546g.lock();
        try {
            if (!this.f8549a.f8545f && this.f8549a.f8544e != null) {
                if (this.f8549a.f8544e.b()) {
                    this.f8549a.f8545f = true;
                    this.f8549a.f8541b.onConnectionSuspended(i2);
                    this.f8549a.f8546g.unlock();
                    return;
                }
            }
            this.f8549a.f8545f = false;
            cr.a(this.f8549a, i2, z);
        } finally {
            this.f8549a.f8546g.unlock();
        }
    }

    /* synthetic */ ct(cr crVar, byte b2) {
        this(crVar);
    }
}
