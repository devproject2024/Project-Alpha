package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class y extends f {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Intent f8870a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Activity f8871b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ int f8872c;

    y(Intent intent, Activity activity, int i2) {
        this.f8870a = intent;
        this.f8871b = activity;
        this.f8872c = i2;
    }

    public final void a() {
        Intent intent = this.f8870a;
        if (intent != null) {
            this.f8871b.startActivityForResult(intent, this.f8872c);
        }
    }
}
