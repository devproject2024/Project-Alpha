package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.internal.c;

final class aa implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ e f8761a;

    aa(e eVar) {
        this.f8761a = eVar;
    }

    public final void a() {
        this.f8761a.onConnected((Bundle) null);
    }

    public final void a(int i2) {
        this.f8761a.onConnectionSuspended(i2);
    }
}
