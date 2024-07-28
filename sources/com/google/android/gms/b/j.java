package com.google.android.gms.b;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;

final class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Context f8288a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Intent f8289b;

    j(Context context, Intent intent) {
        this.f8288a = context;
        this.f8289b = intent;
    }

    public final void onClick(View view) {
        try {
            this.f8288a.startActivity(this.f8289b);
        } catch (ActivityNotFoundException unused) {
        }
    }
}
