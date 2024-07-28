package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;

final class y implements g.a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ BasePendingResult f8637a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ cz f8638b;

    y(cz czVar, BasePendingResult basePendingResult) {
        this.f8638b = czVar;
        this.f8637a = basePendingResult;
    }

    public final void a(Status status) {
        this.f8638b.f8566a.remove(this.f8637a);
    }
}
