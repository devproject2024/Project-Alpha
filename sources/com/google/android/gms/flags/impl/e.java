package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class e implements Callable<Integer> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ SharedPreferences f9039a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9040b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Integer f9041c;

    e(SharedPreferences sharedPreferences, String str, Integer num) {
        this.f9039a = sharedPreferences;
        this.f9040b = str;
        this.f9041c = num;
    }

    public final /* synthetic */ Object call() throws Exception {
        return Integer.valueOf(this.f9039a.getInt(this.f9040b, this.f9041c.intValue()));
    }
}
