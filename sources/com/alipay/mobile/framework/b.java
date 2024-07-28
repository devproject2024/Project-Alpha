package com.alipay.mobile.framework;

import android.app.Application;
import com.alipay.mobile.c.a;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f14953b;

    /* renamed from: a  reason: collision with root package name */
    public c f14954a = new c();

    /* renamed from: c  reason: collision with root package name */
    private a f14955c;

    public static b a() {
        if (f14953b == null) {
            synchronized (b.class) {
                if (f14953b == null) {
                    f14953b = new b();
                }
            }
        }
        return f14953b;
    }

    public final a b() {
        if (this.f14955c == null) {
            new Object();
            this.f14955c = new a();
        }
        return this.f14955c;
    }

    public static Application c() {
        return a.f14950c;
    }
}
