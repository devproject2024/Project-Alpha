package com.google.android.gms.common.api;

import com.google.android.gms.common.api.l;
import java.util.concurrent.TimeUnit;

public abstract class g<R extends l> {

    public interface a {
        void a(Status status);
    }

    public abstract R a(long j, TimeUnit timeUnit);

    public abstract void a();

    public abstract void a(m<? super R> mVar);

    public abstract boolean b();

    public void a(a aVar) {
        throw new UnsupportedOperationException();
    }

    public Integer c() {
        throw new UnsupportedOperationException();
    }
}
