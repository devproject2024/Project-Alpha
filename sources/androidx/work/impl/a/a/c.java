package androidx.work.impl.a.a;

import androidx.work.impl.a.b.d;
import androidx.work.impl.b.p;
import java.util.ArrayList;
import java.util.List;

public abstract class c<T> implements androidx.work.impl.a.a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f5110a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public T f5111b;

    /* renamed from: c  reason: collision with root package name */
    private d<T> f5112c;

    /* renamed from: d  reason: collision with root package name */
    private a f5113d;

    public interface a {
        void a(List<String> list);

        void b(List<String> list);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean a(p pVar);

    public abstract boolean b(T t);

    c(d<T> dVar) {
        this.f5112c = dVar;
    }

    public final void a(a aVar) {
        if (this.f5113d != aVar) {
            this.f5113d = aVar;
            a(this.f5113d, this.f5111b);
        }
    }

    public final void a(Iterable<p> iterable) {
        this.f5110a.clear();
        for (p next : iterable) {
            if (a(next)) {
                this.f5110a.add(next.f5180a);
            }
        }
        if (this.f5110a.isEmpty()) {
            this.f5112c.b(this);
        } else {
            this.f5112c.a(this);
        }
        a(this.f5113d, this.f5111b);
    }

    public final void a() {
        if (!this.f5110a.isEmpty()) {
            this.f5110a.clear();
            this.f5112c.b(this);
        }
    }

    private void a(a aVar, T t) {
        if (!this.f5110a.isEmpty() && aVar != null) {
            if (t == null || b(t)) {
                aVar.b(this.f5110a);
            } else {
                aVar.a(this.f5110a);
            }
        }
    }

    public final void a(T t) {
        this.f5111b = t;
        a(this.f5113d, this.f5111b);
    }
}
