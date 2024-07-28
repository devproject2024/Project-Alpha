package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.e;

final class an implements e.b, e.c {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ag f8423a;

    private an(ag agVar) {
        this.f8423a = agVar;
    }

    public final void onConnectionSuspended(int i2) {
    }

    public final void onConnected(Bundle bundle) {
        if (this.f8423a.k.f8823h) {
            this.f8423a.f8404b.lock();
            try {
                if (this.f8423a.f8407e != null) {
                    this.f8423a.f8407e.a(new al(this.f8423a));
                    this.f8423a.f8404b.unlock();
                }
            } finally {
                this.f8423a.f8404b.unlock();
            }
        } else {
            this.f8423a.f8407e.a(new al(this.f8423a));
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f8423a.f8404b.lock();
        try {
            if (this.f8423a.a(connectionResult)) {
                this.f8423a.f();
                this.f8423a.e();
            } else {
                this.f8423a.b(connectionResult);
            }
        } finally {
            this.f8423a.f8404b.unlock();
        }
    }

    /* synthetic */ an(ag agVar, byte b2) {
        this(agVar);
    }
}
