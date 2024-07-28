package com.google.firebase.components;

import com.google.firebase.c.a;

public final class t<T> implements a<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f38123a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f38124b = f38123a;

    /* renamed from: c  reason: collision with root package name */
    private volatile a<T> f38125c;

    public t(a<T> aVar) {
        this.f38125c = aVar;
    }

    public final T a() {
        T t = this.f38124b;
        if (t == f38123a) {
            synchronized (this) {
                t = this.f38124b;
                if (t == f38123a) {
                    t = this.f38125c.a();
                    this.f38124b = t;
                    this.f38125c = null;
                }
            }
        }
        return t;
    }
}
