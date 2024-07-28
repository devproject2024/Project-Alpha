package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.s;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class ez<V> extends FutureTask<V> implements Comparable<ez> {

    /* renamed from: a  reason: collision with root package name */
    final boolean f11927a;

    /* renamed from: b  reason: collision with root package name */
    private final long f11928b = eu.j.getAndIncrement();

    /* renamed from: c  reason: collision with root package name */
    private final String f11929c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ eu f11930d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ez(eu euVar, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.f11930d = euVar;
        s.a(str);
        this.f11929c = str;
        this.f11927a = z;
        if (this.f11928b == Long.MAX_VALUE) {
            euVar.J_().f11828c.a("Tasks index overflow");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ez(eu euVar, Runnable runnable, String str) {
        super(runnable, (Object) null);
        this.f11930d = euVar;
        s.a(str);
        this.f11929c = str;
        this.f11927a = false;
        if (this.f11928b == Long.MAX_VALUE) {
            euVar.J_().f11828c.a("Tasks index overflow");
        }
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.f11930d.J_().f11828c.a(this.f11929c, th);
        if (th instanceof ex) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        ez ezVar = (ez) obj;
        boolean z = this.f11927a;
        if (z != ezVar.f11927a) {
            return z ? -1 : 1;
        }
        long j = this.f11928b;
        long j2 = ezVar.f11928b;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.f11930d.J_().f11829d.a("Two tasks share the same index. index", Long.valueOf(this.f11928b));
        return 0;
    }
}
