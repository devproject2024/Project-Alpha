package com.paytm.paymentsettings.common;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import com.paytm.paymentsettings.common.data.a;
import kotlin.g.b.k;

public final class b implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final a f43421a;

    /* renamed from: b  reason: collision with root package name */
    private final Application f43422b;

    /* renamed from: c  reason: collision with root package name */
    private final String f43423c;

    public b(a aVar, Application application, String str) {
        k.c(aVar, "repository");
        k.c(application, "application");
        this.f43421a = aVar;
        this.f43422b = application;
        this.f43423c = str;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(com.paytm.paymentsettings.merchantSubscriptions.a.a.class)) {
            return (ai) new com.paytm.paymentsettings.merchantSubscriptions.a.a(this.f43421a, this.f43422b, this.f43423c);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
