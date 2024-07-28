package kotlinx.coroutines;

import kotlin.d.f;
import kotlin.g.a.m;

public interface ThreadContextElement<S> extends f.b {

    public static final class DefaultImpls {
        public static <S, R> R fold(ThreadContextElement<S> threadContextElement, R r, m<? super R, ? super f.b, ? extends R> mVar) {
            return f.b.a.a(threadContextElement, r, mVar);
        }

        public static <S, E extends f.b> E get(ThreadContextElement<S> threadContextElement, f.c<E> cVar) {
            return f.b.a.a((f.b) threadContextElement, cVar);
        }

        public static <S> f minusKey(ThreadContextElement<S> threadContextElement, f.c<?> cVar) {
            return f.b.a.b(threadContextElement, cVar);
        }

        public static <S> f plus(ThreadContextElement<S> threadContextElement, f fVar) {
            return f.b.a.a((f.b) threadContextElement, fVar);
        }
    }

    void restoreThreadContext(f fVar, S s);

    S updateThreadContext(f fVar);
}
