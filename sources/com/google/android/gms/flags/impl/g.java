package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class g implements Callable<Long> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ SharedPreferences f9042a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9043b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Long f9044c;

    g(SharedPreferences sharedPreferences, String str, Long l) {
        this.f9042a = sharedPreferences;
        this.f9043b = str;
        this.f9044c = l;
    }

    public final /* synthetic */ Object call() throws Exception {
        return Long.valueOf(this.f9042a.getLong(this.f9043b, this.f9044c.longValue()));
    }
}
