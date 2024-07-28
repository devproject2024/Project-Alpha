package com.travel.f;

import kotlin.x;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f23450a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static c f23451b;

    private b() {
    }

    public static c a() {
        if (f23451b == null) {
            synchronized (c.class) {
                if (f23451b == null) {
                    f23451b = new c();
                }
                x xVar = x.f47997a;
            }
        }
        return f23451b;
    }
}
