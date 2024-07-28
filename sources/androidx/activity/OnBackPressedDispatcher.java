package androidx.activity;

import androidx.lifecycle.k;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    final ArrayDeque<b> f976a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f977b;

    public OnBackPressedDispatcher() {
        this((Runnable) null);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f976a = new ArrayDeque<>();
        this.f977b = runnable;
    }

    public final void a(q qVar, b bVar) {
        k lifecycle = qVar.getLifecycle();
        if (lifecycle.a() != k.b.DESTROYED) {
            bVar.a(new LifecycleOnBackPressedCancellable(lifecycle, bVar));
        }
    }

    public final void a() {
        Iterator<b> descendingIterator = this.f976a.descendingIterator();
        while (descendingIterator.hasNext()) {
            b next = descendingIterator.next();
            if (next.f984a) {
                next.b();
                return;
            }
        }
        Runnable runnable = this.f977b;
        if (runnable != null) {
            runnable.run();
        }
    }

    class a implements a {

        /* renamed from: b  reason: collision with root package name */
        private final b f983b;

        a(b bVar) {
            this.f983b = bVar;
        }

        public final void a() {
            OnBackPressedDispatcher.this.f976a.remove(this.f983b);
            this.f983b.b(this);
        }
    }

    class LifecycleOnBackPressedCancellable implements a, o {

        /* renamed from: b  reason: collision with root package name */
        private final k f979b;

        /* renamed from: c  reason: collision with root package name */
        private final b f980c;

        /* renamed from: d  reason: collision with root package name */
        private a f981d;

        LifecycleOnBackPressedCancellable(k kVar, b bVar) {
            this.f979b = kVar;
            this.f980c = bVar;
            kVar.a(this);
        }

        public final void a(q qVar, k.a aVar) {
            if (aVar == k.a.ON_START) {
                OnBackPressedDispatcher onBackPressedDispatcher = OnBackPressedDispatcher.this;
                b bVar = this.f980c;
                onBackPressedDispatcher.f976a.add(bVar);
                a aVar2 = new a(bVar);
                bVar.a(aVar2);
                this.f981d = aVar2;
            } else if (aVar == k.a.ON_STOP) {
                a aVar3 = this.f981d;
                if (aVar3 != null) {
                    aVar3.a();
                }
            } else if (aVar == k.a.ON_DESTROY) {
                a();
            }
        }

        public final void a() {
            this.f979b.b(this);
            this.f980c.b(this);
            a aVar = this.f981d;
            if (aVar != null) {
                aVar.a();
                this.f981d = null;
            }
        }
    }
}
