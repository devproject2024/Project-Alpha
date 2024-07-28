package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class c implements Callable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ SharedPreferences f9036a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9037b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Boolean f9038c;

    c(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.f9036a = sharedPreferences;
        this.f9037b = str;
        this.f9038c = bool;
    }

    public final /* synthetic */ Object call() throws Exception {
        return Boolean.valueOf(this.f9036a.getBoolean(this.f9037b, this.f9038c.booleanValue()));
    }
}
