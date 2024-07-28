package io.reactivex.rxjava3.g;

import io.reactivex.rxjava3.e.k.r;
import io.reactivex.rxjava3.g.a;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public abstract class a<T, U extends a<T, U>> {

    /* renamed from: a  reason: collision with root package name */
    protected final CountDownLatch f47744a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    protected final List<T> f47745b = new r();

    /* renamed from: c  reason: collision with root package name */
    protected final List<Throwable> f47746c = new r();

    /* renamed from: d  reason: collision with root package name */
    protected long f47747d;

    /* renamed from: e  reason: collision with root package name */
    protected Thread f47748e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f47749f;
}
