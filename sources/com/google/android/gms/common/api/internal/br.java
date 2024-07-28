package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

final class br implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ bs f8474a;

    br(bs bsVar) {
        this.f8474a = bsVar;
    }

    public final void run() {
        this.f8474a.f8482h.b(new ConnectionResult(4));
    }
}
