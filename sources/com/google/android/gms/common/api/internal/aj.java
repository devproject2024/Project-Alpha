package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.c;

final class aj extends ax {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ c.C0130c f8417a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aj(av avVar, c.C0130c cVar) {
        super(avVar);
        this.f8417a = cVar;
    }

    public final void a() {
        this.f8417a.a(new ConnectionResult(16, (PendingIntent) null));
    }
}
