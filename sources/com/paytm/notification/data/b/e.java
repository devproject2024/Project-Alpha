package com.paytm.notification.data.b;

import com.google.gson.f;
import java.lang.reflect.Type;
import kotlin.g.b.k;

public final class e<T> {

    /* renamed from: a  reason: collision with root package name */
    private f f43060a;

    public e(f fVar) {
        k.c(fVar, "gson");
        this.f43060a = fVar;
    }

    public final T a(String str, Class<?> cls) {
        if (!(str == null || cls == null)) {
            try {
                return this.f43060a.a(str, (Type) cls);
            } catch (Exception e2) {
                com.paytm.notification.b.e.f43014a.a((Throwable) e2);
            }
        }
        return null;
    }
}
