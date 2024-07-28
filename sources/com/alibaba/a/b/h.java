package com.alibaba.a.b;

import com.business.merchant_payments.common.utility.AppUtility;
import java.lang.reflect.Type;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public Object f6239a;

    /* renamed from: b  reason: collision with root package name */
    public final h f6240b;

    /* renamed from: c  reason: collision with root package name */
    public Type f6241c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f6242d;

    public h(h hVar, Object obj, Object obj2) {
        this.f6240b = hVar;
        this.f6239a = obj;
        this.f6242d = obj2;
    }

    public final String a() {
        if (this.f6240b == null) {
            return "$";
        }
        if (this.f6242d instanceof Integer) {
            return this.f6240b.a() + "[" + this.f6242d + "]";
        }
        return this.f6240b.a() + AppUtility.CENTER_DOT + this.f6242d;
    }

    public final String toString() {
        return a();
    }
}
