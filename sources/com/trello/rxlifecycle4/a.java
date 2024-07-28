package com.trello.rxlifecycle4;

import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.d.q;
import java.util.concurrent.CancellationException;

final class a {

    /* renamed from: a  reason: collision with root package name */
    static final h<Throwable, Boolean> f33762a = new h<Throwable, Boolean>() {
        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            Throwable th = (Throwable) obj;
            if (th instanceof c) {
                return Boolean.TRUE;
            }
            b.a(th);
            return Boolean.FALSE;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    static final q<Boolean> f33763b = new q<Boolean>() {
        public final /* synthetic */ boolean test(Object obj) throws Throwable {
            return ((Boolean) obj).booleanValue();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    static final h<Object, io.reactivex.rxjava3.a.b> f33764c = new h<Object, io.reactivex.rxjava3.a.b>() {
        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            return io.reactivex.rxjava3.a.b.a((Throwable) new CancellationException());
        }
    };
}
