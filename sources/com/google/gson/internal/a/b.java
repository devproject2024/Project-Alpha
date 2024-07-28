package com.google.gson.internal.a;

import com.google.gson.internal.d;
import java.lang.reflect.AccessibleObject;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final b f39486a = (d.a() < 9 ? new a() : new c());

    public abstract void a(AccessibleObject accessibleObject);

    public static b a() {
        return f39486a;
    }
}
