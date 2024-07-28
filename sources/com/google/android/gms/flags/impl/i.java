package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class i implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ SharedPreferences f9045a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9046b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f9047c;

    i(SharedPreferences sharedPreferences, String str, String str2) {
        this.f9045a = sharedPreferences;
        this.f9046b = str;
        this.f9047c = str2;
    }

    public final /* synthetic */ Object call() throws Exception {
        return this.f9045a.getString(this.f9046b, this.f9047c);
    }
}
