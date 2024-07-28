package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.f;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    private static final b f8865a = new ad();

    public interface a<R extends l, T> {
        T a(R r);
    }

    public interface b {
        ApiException a(Status status);
    }

    private static <R extends l, T> Task<T> a(g<R> gVar, a<R, T> aVar) {
        b bVar = f8865a;
        f fVar = new f();
        gVar.a((g.a) new af(gVar, fVar, aVar, bVar));
        return fVar.f12478a;
    }

    public static <R extends l, T extends k<R>> Task<T> a(g<R> gVar, T t) {
        return a(gVar, new ae(t));
    }

    public static <R extends l> Task<Void> a(g<R> gVar) {
        return a(gVar, new ag());
    }
}
