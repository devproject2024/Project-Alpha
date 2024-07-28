package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.e.e.b;

public final class cn extends p<Long> {

    /* renamed from: a  reason: collision with root package name */
    private final long f47183a;

    /* renamed from: b  reason: collision with root package name */
    private final long f47184b;

    public cn(long j, long j2) {
        this.f47183a = j;
        this.f47184b = j2;
    }

    public final void subscribeActual(w<? super Long> wVar) {
        long j = this.f47183a;
        a aVar = new a(wVar, j, j + this.f47184b);
        wVar.onSubscribe(aVar);
        aVar.run();
    }

    static final class a extends b<Long> {
        private static final long serialVersionUID = 396518478098735504L;
        final w<? super Long> downstream;
        final long end;
        boolean fused;
        long index;

        a(w<? super Long> wVar, long j, long j2) {
            this.downstream = wVar;
            this.index = j;
            this.end = j2;
        }

        /* access modifiers changed from: package-private */
        public final void run() {
            if (!this.fused) {
                w<? super Long> wVar = this.downstream;
                long j = this.end;
                for (long j2 = this.index; j2 != j && get() == 0; j2++) {
                    wVar.onNext(Long.valueOf(j2));
                }
                if (get() == 0) {
                    lazySet(1);
                    wVar.onComplete();
                }
            }
        }

        public final Long poll() {
            long j = this.index;
            if (j != this.end) {
                this.index = 1 + j;
                return Long.valueOf(j);
            }
            lazySet(1);
            return null;
        }

        public final boolean isEmpty() {
            return this.index == this.end;
        }

        public final void clear() {
            this.index = this.end;
            lazySet(1);
        }

        public final void dispose() {
            set(1);
        }

        public final boolean isDisposed() {
            return get() != 0;
        }

        public final int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.fused = true;
            return 1;
        }
    }
}
