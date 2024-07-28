package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class k implements Callable<SharedPreferences> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Context f9049a;

    k(Context context) {
        this.f9049a = context;
    }

    public final /* synthetic */ Object call() throws Exception {
        return this.f9049a.getSharedPreferences("google_sdk_flags", 0);
    }
}
