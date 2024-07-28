package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.j;

final class z extends f {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Intent f8873a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ j f8874b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ int f8875c = 2;

    z(Intent intent, j jVar) {
        this.f8873a = intent;
        this.f8874b = jVar;
    }

    public final void a() {
        Intent intent = this.f8873a;
        if (intent != null) {
            this.f8874b.startActivityForResult(intent, this.f8875c);
        }
    }
}
