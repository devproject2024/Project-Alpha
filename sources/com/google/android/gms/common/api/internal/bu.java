package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zak;

final class bu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zak f8483a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ bs f8484b;

    bu(bs bsVar, zak zak) {
        this.f8484b = bsVar;
        this.f8483a = zak;
    }

    public final void run() {
        bs.a(this.f8484b, this.f8483a);
    }
}
