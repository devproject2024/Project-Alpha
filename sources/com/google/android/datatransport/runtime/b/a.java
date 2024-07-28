package com.google.android.datatransport.runtime.b;

import java.lang.Throwable;

public interface a<TInput, TResult, TException extends Throwable> {
    TResult a(TInput tinput) throws Throwable;
}
