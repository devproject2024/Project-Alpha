package com.trello.rxlifecycle4;

import com.trello.rxlifecycle4.a.a;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.d.c;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.d.q;

public final class d {
    public static <T, R> b<T> a(p<R> pVar, R r) {
        a.a(pVar, "lifecycle == null");
        a.a(r, "event == null");
        return a(b(pVar, r));
    }

    private static <R> p<R> b(p<R> pVar, final R r) {
        return pVar.filter(new q<R>() {
            public final boolean test(R r) throws Exception {
                return r.equals(r);
            }
        });
    }

    private static <T, R> b<T> a(p<R> pVar) {
        return new b<>(pVar);
    }

    public static <T, R> b<T> a(p<R> pVar, h<R, R> hVar) {
        a.a(pVar, "lifecycle == null");
        a.a(hVar, "correspondingEvents == null");
        p<R> share = pVar.share();
        return a(p.combineLatest(share.take(1).map(hVar), share.skip(1), new c<R, R, Boolean>() {
            public final /* synthetic */ Object a(Object obj, Object obj2) throws Throwable {
                return Boolean.valueOf(obj2.equals(obj));
            }
        }).onErrorReturn(a.f33762a).filter(a.f33763b));
    }
}
