package com.google.android.play.core.e;

import java.util.concurrent.ExecutionException;

public final class g {
    public static <ResultT> e<ResultT> a(Exception exc) {
        t tVar = new t();
        tVar.a(exc);
        return tVar;
    }

    public static <ResultT> e<ResultT> a(ResultT resultt) {
        t tVar = new t();
        tVar.a(resultt);
        return tVar;
    }

    public static <ResultT> ResultT a(e<ResultT> eVar) throws ExecutionException {
        if (eVar.b()) {
            return eVar.c();
        }
        throw new ExecutionException(eVar.d());
    }
}
