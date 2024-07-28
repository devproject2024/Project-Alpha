package androidx.room.rxjava3;

import androidx.room.g;
import androidx.room.j;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.i;
import io.reactivex.rxjava3.a.l;
import io.reactivex.rxjava3.a.n;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.a.z;
import io.reactivex.rxjava3.d.a;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f4502a = new Object();

    /* access modifiers changed from: private */
    public static /* synthetic */ n a(l lVar, Object obj) throws Throwable {
        return lVar;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(String[] strArr, j jVar, final i iVar) throws Throwable {
        AnonymousClass1 r0 = new g.b(strArr) {
            public final void a(Set<String> set) {
                if (!iVar.isCancelled()) {
                    iVar.onNext(b.f4502a);
                }
            }
        };
        if (!iVar.isCancelled()) {
            jVar.getInvalidationTracker().a((g.b) r0);
            $$Lambda$b$MxDYED3IoNgx3GKM916NNkszu0k r1 = new a(r0) {
                private final /* synthetic */ g.b f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    j.this.getInvalidationTracker().c(this.f$1);
                }
            };
            Objects.requireNonNull(r1, "action is null");
            iVar.setDisposable(new io.reactivex.rxjava3.b.a(r1));
        }
        if (!iVar.isCancelled()) {
            iVar.onNext(f4502a);
        }
    }

    public static <T> y<T> a(Callable<T> callable) {
        return y.a(new ab(callable) {
            private final /* synthetic */ Callable f$0;

            {
                this.f$0 = r1;
            }

            public final void subscribe(z zVar) {
                b.a(this.f$0, zVar);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Callable callable, z zVar) throws Throwable {
        try {
            zVar.onSuccess(callable.call());
        } catch (a e2) {
            zVar.tryOnError(e2);
        }
    }

    public static <T> h<T> a(j jVar, String[] strArr, Callable<T> callable) {
        x a2 = io.reactivex.rxjava3.i.a.a(jVar.getQueryExecutor());
        l<T> a3 = l.a(callable);
        h b2 = h.a(new io.reactivex.rxjava3.a.j(strArr, jVar) {
            private final /* synthetic */ String[] f$0;
            private final /* synthetic */ j f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void subscribe(i iVar) {
                b.a(this.f$0, this.f$1, iVar);
            }
        }, io.reactivex.rxjava3.a.a.LATEST).b(a2);
        Objects.requireNonNull(a2, "scheduler is null");
        h a4 = io.reactivex.rxjava3.h.a.a(new io.reactivex.rxjava3.e.f.b.y(b2, a2)).a(a2);
        $$Lambda$b$Mb30lY6UhCq9WI5duc1rdLUEaTg r3 = new io.reactivex.rxjava3.d.h() {
            public final Object apply(Object obj) {
                return b.a(l.this, obj);
            }
        };
        Objects.requireNonNull(r3, "mapper is null");
        io.reactivex.rxjava3.e.b.b.a(Integer.MAX_VALUE, "maxConcurrency");
        return io.reactivex.rxjava3.h.a.a(new io.reactivex.rxjava3.e.f.b.h(a4, r3));
    }
}
