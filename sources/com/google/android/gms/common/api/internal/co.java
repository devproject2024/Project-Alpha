package com.google.android.gms.common.api.internal;

import android.app.Dialog;

final class co extends bj {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Dialog f8535a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ cm f8536b;

    co(cm cmVar, Dialog dialog) {
        this.f8536b = cmVar;
        this.f8535a = dialog;
    }

    public final void a() {
        this.f8536b.f8531a.f();
        if (this.f8535a.isShowing()) {
            this.f8535a.dismiss();
        }
    }
}
