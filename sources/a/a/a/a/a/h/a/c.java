package a.a.a.a.a.h.a;

import a.a.a.a.a.h.a.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class c implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue<Runnable> f767a = new LinkedBlockingQueue();

    /* renamed from: b  reason: collision with root package name */
    private final ThreadPoolExecutor f768b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.f767a);

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque<b> f769c = new ArrayDeque<>();

    /* renamed from: d  reason: collision with root package name */
    private b f770d = null;

    public final void a() {
        this.f770d = null;
        b();
    }

    private void b() {
        b poll = this.f769c.poll();
        this.f770d = poll;
        if (poll != null) {
            poll.executeOnExecutor(this.f768b, new Object[0]);
        }
    }

    public final void a(b bVar) {
        bVar.f765d = this;
        this.f769c.add(bVar);
        if (this.f770d == null) {
            b();
        }
    }
}
