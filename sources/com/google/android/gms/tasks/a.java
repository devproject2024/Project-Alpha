package com.google.android.gms.tasks;

public interface a<TResult, TContinuationResult> {
    TContinuationResult a(Task<TResult> task) throws Exception;
}
