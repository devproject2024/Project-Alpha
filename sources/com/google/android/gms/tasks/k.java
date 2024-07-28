package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class k<TResult, TContinuationResult> implements OnFailureListener, OnSuccessListener<TContinuationResult>, b, y<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f12495a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a<TResult, Task<TContinuationResult>> f12496b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final ab<TContinuationResult> f12497c;

    public k(Executor executor, a<TResult, Task<TContinuationResult>> aVar, ab<TContinuationResult> abVar) {
        this.f12495a = executor;
        this.f12496b = aVar;
        this.f12497c = abVar;
    }

    public final void a(Task<TResult> task) {
        this.f12495a.execute(new n(this, task));
    }

    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f12497c.a(tcontinuationresult);
    }

    public final void onFailure(Exception exc) {
        this.f12497c.a(exc);
    }

    public final void a() {
        this.f12497c.f();
    }

    public final void P_() {
        throw new UnsupportedOperationException();
    }
}
