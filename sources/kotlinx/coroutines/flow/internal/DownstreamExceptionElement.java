package kotlinx.coroutines.flow.internal;

import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.g;

public final class DownstreamExceptionElement implements f.b {
    public static final Key Key = new Key((g) null);

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f47998e;
    private final f.c<?> key = Key;

    public static final class Key implements f.c<DownstreamExceptionElement> {
        private Key() {
        }

        public /* synthetic */ Key(g gVar) {
            this();
        }
    }

    public DownstreamExceptionElement(Throwable th) {
        this.f47998e = th;
    }

    public final <R> R fold(R r, m<? super R, ? super f.b, ? extends R> mVar) {
        return f.b.a.a(this, r, mVar);
    }

    public final <E extends f.b> E get(f.c<E> cVar) {
        return f.b.a.a((f.b) this, cVar);
    }

    public final f minusKey(f.c<?> cVar) {
        return f.b.a.b(this, cVar);
    }

    public final f plus(f fVar) {
        return f.b.a.a((f.b) this, fVar);
    }

    public final f.c<?> getKey() {
        return this.key;
    }
}
