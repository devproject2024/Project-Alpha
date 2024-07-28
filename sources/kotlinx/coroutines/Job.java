package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineExceptionHandler;

public interface Job extends f.b {
    public static final Key Key = Key.$$INSTANCE;

    ChildHandle attachChild(ChildJob childJob);

    void cancel(CancellationException cancellationException);

    CancellationException getCancellationException();

    DisposableHandle invokeOnCompletion(b<? super Throwable, x> bVar);

    DisposableHandle invokeOnCompletion(boolean z, boolean z2, b<? super Throwable, x> bVar);

    boolean isActive();

    Object join(d<? super x> dVar);

    boolean start();

    public static final class Key implements f.c<Job> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        static {
            CoroutineExceptionHandler.Key key = CoroutineExceptionHandler.Key;
        }

        private Key() {
        }
    }

    public static final class DefaultImpls {
        public static <R> R fold(Job job, R r, m<? super R, ? super f.b, ? extends R> mVar) {
            return f.b.a.a(job, r, mVar);
        }

        public static <E extends f.b> E get(Job job, f.c<E> cVar) {
            return f.b.a.a((f.b) job, cVar);
        }

        public static f minusKey(Job job, f.c<?> cVar) {
            return f.b.a.b(job, cVar);
        }

        public static f plus(Job job, f fVar) {
            return f.b.a.a((f.b) job, fVar);
        }

        public static /* synthetic */ void cancel$default(Job job, CancellationException cancellationException, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    cancellationException = null;
                }
                job.cancel(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean z, boolean z2, b bVar, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    z = false;
                }
                if ((i2 & 2) != 0) {
                    z2 = true;
                }
                return job.invokeOnCompletion(z, z2, bVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }
    }
}
