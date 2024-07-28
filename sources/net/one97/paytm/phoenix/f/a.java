package net.one97.paytm.phoenix.f;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f59576a = Runtime.getRuntime().availableProcessors();

    /* renamed from: e  reason: collision with root package name */
    private static a f59577e;

    /* renamed from: b  reason: collision with root package name */
    public final ThreadPoolExecutor f59578b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f59579c = new b();

    /* renamed from: d  reason: collision with root package name */
    private final ThreadPoolExecutor f59580d;

    public static a a() {
        if (f59577e == null) {
            synchronized (a.class) {
                f59577e = new a();
            }
        }
        return f59577e;
    }

    private a() {
        c cVar = new c();
        int i2 = f59576a;
        c cVar2 = cVar;
        this.f59578b = new ThreadPoolExecutor(i2 * 2, i2 * 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), cVar2);
        int i3 = f59576a;
        this.f59580d = new ThreadPoolExecutor(i3 * 2, i3 * 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), cVar2);
    }
}
