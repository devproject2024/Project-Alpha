package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class cv implements bl {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ cr f8551a;

    private cv(cr crVar) {
        this.f8551a = crVar;
    }

    public final void a(Bundle bundle) {
        this.f8551a.f8546g.lock();
        try {
            this.f8551a.f8544e = ConnectionResult.f8333a;
            cr.a(this.f8551a);
        } finally {
            this.f8551a.f8546g.unlock();
        }
    }

    public final void a(ConnectionResult connectionResult) {
        this.f8551a.f8546g.lock();
        try {
            this.f8551a.f8544e = connectionResult;
            cr.a(this.f8551a);
        } finally {
            this.f8551a.f8546g.unlock();
        }
    }

    public final void a(int i2, boolean z) {
        this.f8551a.f8546g.lock();
        try {
            if (this.f8551a.f8545f) {
                this.f8551a.f8545f = false;
                cr.a(this.f8551a, i2, z);
                return;
            }
            this.f8551a.f8545f = true;
            this.f8551a.f8540a.onConnectionSuspended(i2);
            this.f8551a.f8546g.unlock();
        } finally {
            this.f8551a.f8546g.unlock();
        }
    }

    /* synthetic */ cv(cr crVar, byte b2) {
        this(crVar);
    }
}
