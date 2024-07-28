package com.google.android.gms.common.api.internal;

final class cb implements cd {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ cc f8503a;

    cb(cc ccVar) {
        this.f8503a = ccVar;
    }

    public final void a(BasePendingResult<?> basePendingResult) {
        this.f8503a.f8506c.remove(basePendingResult);
        basePendingResult.c();
    }
}
