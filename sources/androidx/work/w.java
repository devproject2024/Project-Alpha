package androidx.work;

import androidx.work.impl.b.p;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public abstract class w {

    /* renamed from: a  reason: collision with root package name */
    public UUID f5516a;

    /* renamed from: b  reason: collision with root package name */
    public p f5517b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f5518c;

    protected w(UUID uuid, p pVar, Set<String> set) {
        this.f5516a = uuid;
        this.f5517b = pVar;
        this.f5518c = set;
    }

    public final UUID a() {
        return this.f5516a;
    }

    public static abstract class a<B extends a<?, ?>, W extends w> {

        /* renamed from: a  reason: collision with root package name */
        boolean f5519a = false;

        /* renamed from: b  reason: collision with root package name */
        UUID f5520b = UUID.randomUUID();

        /* renamed from: c  reason: collision with root package name */
        p f5521c;

        /* renamed from: d  reason: collision with root package name */
        Set<String> f5522d = new HashSet();

        /* renamed from: e  reason: collision with root package name */
        Class<? extends ListenableWorker> f5523e;

        /* access modifiers changed from: package-private */
        public abstract B a();

        /* access modifiers changed from: package-private */
        public abstract W b();

        a(Class<? extends ListenableWorker> cls) {
            this.f5523e = cls;
            this.f5521c = new p(this.f5520b.toString(), cls.getName());
            a(cls.getName());
        }

        public final B a(a aVar, long j, TimeUnit timeUnit) {
            this.f5519a = true;
            p pVar = this.f5521c;
            pVar.l = aVar;
            long millis = timeUnit.toMillis(j);
            if (millis > 18000000) {
                l.a();
                millis = 18000000;
            }
            if (millis < 10000) {
                l.a();
                millis = 10000;
            }
            pVar.m = millis;
            return a();
        }

        public final B a(c cVar) {
            this.f5521c.j = cVar;
            return a();
        }

        public final B a(String str) {
            this.f5522d.add(str);
            return a();
        }

        public final B a(long j, TimeUnit timeUnit) {
            this.f5521c.f5186g = timeUnit.toMillis(j);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.f5521c.f5186g) {
                return a();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        public final W c() {
            W b2 = b();
            this.f5520b = UUID.randomUUID();
            this.f5521c = new p(this.f5521c);
            this.f5521c.f5180a = this.f5520b.toString();
            return b2;
        }
    }
}
