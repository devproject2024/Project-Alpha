package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.common.api.internal.j;

public abstract class f implements DialogInterface.OnClickListener {
    /* access modifiers changed from: protected */
    public abstract void a();

    public static f a(Activity activity, Intent intent, int i2) {
        return new y(intent, activity, i2);
    }

    public static f a(j jVar, Intent intent) {
        return new z(intent, jVar);
    }

    public void onClick(DialogInterface dialogInterface, int i2) {
        try {
            a();
        } catch (ActivityNotFoundException unused) {
        } finally {
            dialogInterface.dismiss();
        }
    }
}
