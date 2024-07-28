package com.google.android.gms.common.api.internal;

import android.content.DialogInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.c;

final class cm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cl f8531a;

    /* renamed from: b  reason: collision with root package name */
    private final cn f8532b;

    cm(cl clVar, cn cnVar) {
        this.f8531a = clVar;
        this.f8532b = cnVar;
    }

    public final void run() {
        if (this.f8531a.f8528c) {
            ConnectionResult connectionResult = this.f8532b.f8534b;
            if (connectionResult.a()) {
                this.f8531a.f8394a.startActivityForResult(GoogleApiActivity.a(this.f8531a.a(), connectionResult.f8335c, this.f8532b.f8533a, false), 1);
            } else if (this.f8531a.f8530e.a(connectionResult.f8334b)) {
                this.f8531a.f8530e.a(this.f8531a.a(), this.f8531a.f8394a, connectionResult.f8334b, (DialogInterface.OnCancelListener) this.f8531a);
            } else if (connectionResult.f8334b == 18) {
                c.a(this.f8531a.a().getApplicationContext(), (bj) new co(this, c.a(this.f8531a.a(), (DialogInterface.OnCancelListener) this.f8531a)));
            } else {
                this.f8531a.a(connectionResult, this.f8532b.f8533a);
            }
        }
    }
}
