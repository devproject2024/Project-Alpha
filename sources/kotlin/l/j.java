package kotlin.l;

import java.util.Iterator;
import kotlin.g.b.k;

public class j extends i {

    public static final class a implements d<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterator f47965a;

        public a(Iterator it2) {
            this.f47965a = it2;
        }

        public final Iterator<T> a() {
            return this.f47965a;
        }
    }

    public static final <T> d<T> a(Iterator<? extends T> it2) {
        k.d(it2, "$this$asSequence");
        d aVar = new a(it2);
        k.d(aVar, "$this$constrainOnce");
        return new a<>(aVar);
    }
}
