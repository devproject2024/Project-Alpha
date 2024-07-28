package com.google.zxing.client.android;

import android.app.Activity;
import android.content.DialogInterface;

public final class i implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f40247a;

    public i(Activity activity) {
        this.f40247a = activity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f40247a.finish();
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f40247a.finish();
    }
}
