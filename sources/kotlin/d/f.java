package kotlin.d;

import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.l;

public interface f {

    public interface c<E extends b> {
    }

    <R> R fold(R r, m<? super R, ? super b, ? extends R> mVar);

    <E extends b> E get(c<E> cVar);

    f minusKey(c<?> cVar);

    f plus(f fVar);

    public static final class a {
        public static f a(f fVar, f fVar2) {
            k.d(fVar2, "context");
            if (fVar2 == g.INSTANCE) {
                return fVar;
            }
            return (f) fVar2.fold(fVar, C0836a.INSTANCE);
        }

        /* renamed from: kotlin.d.f$a$a  reason: collision with other inner class name */
        static final class C0836a extends l implements m<f, b, f> {
            public static final C0836a INSTANCE = new C0836a();

            C0836a() {
                super(2);
            }

            public final f invoke(f fVar, b bVar) {
                c cVar;
                k.d(fVar, "acc");
                k.d(bVar, "element");
                f minusKey = fVar.minusKey(bVar.getKey());
                if (minusKey == g.INSTANCE) {
                    cVar = bVar;
                } else {
                    e eVar = (e) minusKey.get(e.f47904a);
                    if (eVar == null) {
                        cVar = new c(minusKey, bVar);
                    } else {
                        f minusKey2 = minusKey.minusKey(e.f47904a);
                        if (minusKey2 == g.INSTANCE) {
                            cVar = new c(bVar, eVar);
                        } else {
                            cVar = new c(new c(minusKey2, bVar), eVar);
                        }
                    }
                }
                return cVar;
            }
        }
    }

    public interface b extends f {
        <E extends b> E get(c<E> cVar);

        c<?> getKey();

        public static final class a {
            public static f a(b bVar, f fVar) {
                k.d(fVar, "context");
                return a.a(bVar, fVar);
            }

            public static <E extends b> E a(b bVar, c<E> cVar) {
                k.d(cVar, "key");
                if (!k.a((Object) bVar.getKey(), (Object) cVar)) {
                    return null;
                }
                if (bVar != null) {
                    return bVar;
                }
                throw new NullPointerException("null cannot be cast to non-null type E");
            }

            public static <R> R a(b bVar, R r, m<? super R, ? super b, ? extends R> mVar) {
                k.d(mVar, "operation");
                return mVar.invoke(r, bVar);
            }

            public static f b(b bVar, c<?> cVar) {
                k.d(cVar, "key");
                return k.a((Object) bVar.getKey(), (Object) cVar) ? g.INSTANCE : bVar;
            }
        }
    }
}
