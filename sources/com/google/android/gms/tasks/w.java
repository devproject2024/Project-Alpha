package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class w<TResult, TContinuationResult> implements OnFailureListener, OnSuccessListener<TContinuationResult>, b, y<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f12521a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final e<TResult, TContinuationResult> f12522b;

    /* renamed from: c  reason: collision with root package name */
    private final ab<TContinuationResult> f12523c;

    public w(Executor executor, e<TResult, TContinuationResult> eVar, ab<TContinuationResult> abVar) {
        this.f12521a = executor;
        this.f12522b = eVar;
        this.f12523c = abVar;
    }

    public final void a(Task<TResult> task) {
        this.f12521a.execute(new x(this, task));
    }

    public final void P_() {
        throw new UnsupportedOperationException();
    }

    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f12523c.a(tcontinuationresult);
    }

    public final void onFailure(Exception exc) {
        this.f12523c.a(exc);
    }

    public final void a() {
        this.f12523c.f();
    }
}
