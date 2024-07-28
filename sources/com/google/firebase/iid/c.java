package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Callable;

final /* synthetic */ class c implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final Context f38858a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f38859b;

    c(Context context, Intent intent) {
        this.f38858a = context;
        this.f38859b = intent;
    }

    public final Object call() {
        return b.a(this.f38858a, this.f38859b);
    }
}
