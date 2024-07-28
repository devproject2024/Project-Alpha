package com.google.android.play.core.e;

import java.util.concurrent.Executor;

public abstract class e<ResultT> {
    public abstract e<ResultT> a(a<ResultT> aVar);

    public abstract e<ResultT> a(b bVar);

    public abstract e<ResultT> a(c<? super ResultT> cVar);

    public abstract e<ResultT> a(Executor executor, b bVar);

    public abstract e<ResultT> a(Executor executor, c<? super ResultT> cVar);

    public abstract boolean a();

    public abstract boolean b();

    public abstract ResultT c();

    public abstract Exception d();
}
