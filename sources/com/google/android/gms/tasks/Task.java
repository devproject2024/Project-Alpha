package com.google.android.gms.tasks;

import android.app.Activity;
import java.util.concurrent.Executor;

public abstract class Task<TResult> {
    public abstract Task<TResult> a(Activity activity, OnFailureListener onFailureListener);

    public abstract Task<TResult> a(Activity activity, OnSuccessListener<? super TResult> onSuccessListener);

    public abstract Task<TResult> a(OnFailureListener onFailureListener);

    public abstract Task<TResult> a(OnSuccessListener<? super TResult> onSuccessListener);

    public abstract Task<TResult> a(Executor executor, OnFailureListener onFailureListener);

    public abstract Task<TResult> a(Executor executor, OnSuccessListener<? super TResult> onSuccessListener);

    public abstract <X extends Throwable> TResult a(Class<X> cls) throws Throwable;

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c();

    public abstract TResult d();

    public abstract Exception e();

    public Task<TResult> a(c<TResult> cVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public Task<TResult> a(Executor executor, c<TResult> cVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public Task<TResult> a(b bVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public Task<TResult> a(Executor executor, b bVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> a(a<TResult, TContinuationResult> aVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> a(Executor executor, a<TResult, TContinuationResult> aVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> b(a<TResult, Task<TContinuationResult>> aVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> b(Executor executor, a<TResult, Task<TContinuationResult>> aVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> a(e<TResult, TContinuationResult> eVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> a(Executor executor, e<TResult, TContinuationResult> eVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
