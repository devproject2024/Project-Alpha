package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.a;

final /* synthetic */ class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f38860a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f38861b;

    d(Context context, Intent intent) {
        this.f38860a = context;
        this.f38861b = intent;
    }

    public final Object a(Task task) {
        return b.a(this.f38860a, this.f38861b, task);
    }
}
