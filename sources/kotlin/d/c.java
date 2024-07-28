package kotlin.d;

import java.io.Serializable;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.x;
import kotlin.x;

public final class c implements Serializable, f {
    private final f.b element;
    private final f left;

    /* renamed from: kotlin.d.c$c  reason: collision with other inner class name */
    static final class C0835c extends l implements m<x, f.b, x> {
        final /* synthetic */ f[] $elements;
        final /* synthetic */ x.c $index;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0835c(f[] fVarArr, x.c cVar) {
            super(2);
            this.$elements = fVarArr;
            this.$index = cVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((kotlin.x) obj, (f.b) obj2);
            return kotlin.x.f47997a;
        }

        public final void invoke(kotlin.x xVar, f.b bVar) {
            k.d(xVar, "<anonymous parameter 0>");
            k.d(bVar, "element");
            f[] fVarArr = this.$elements;
            x.c cVar = this.$index;
            int i2 = cVar.element;
            cVar.element = i2 + 1;
            fVarArr[i2] = bVar;
        }
    }

    public c(f fVar, f.b bVar) {
        k.d(fVar, "left");
        k.d(bVar, "element");
        this.left = fVar;
        this.element = bVar;
    }

    public final f plus(f fVar) {
        k.d(fVar, "context");
        return f.a.a(this, fVar);
    }

    public final <E extends f.b> E get(f.c<E> cVar) {
        k.d(cVar, "key");
        f fVar = this;
        while (true) {
            c cVar2 = (c) fVar;
            E e2 = cVar2.element.get(cVar);
            if (e2 != null) {
                return e2;
            }
            fVar = cVar2.left;
            if (!(fVar instanceof c)) {
                return fVar.get(cVar);
            }
        }
    }

    public final <R> R fold(R r, m<? super R, ? super f.b, ? extends R> mVar) {
        k.d(mVar, "operation");
        return mVar.invoke(this.left.fold(r, mVar), this.element);
    }

    public final f minusKey(f.c<?> cVar) {
        k.d(cVar, "key");
        if (this.element.get(cVar) != null) {
            return this.left;
        }
        f minusKey = this.left.minusKey(cVar);
        if (minusKey == this.left) {
            return this;
        }
        if (minusKey == g.INSTANCE) {
            return this.element;
        }
        return new c(minusKey, this.element);
    }

    private final int size() {
        c cVar = this;
        int i2 = 2;
        while (true) {
            f fVar = cVar.left;
            if (!(fVar instanceof c)) {
                fVar = null;
            }
            cVar = (c) fVar;
            if (cVar == null) {
                return i2;
            }
            i2++;
        }
    }

    private final boolean contains(f.b bVar) {
        return k.a((Object) get(bVar.getKey()), (Object) bVar);
    }

    private final boolean containsAll(c cVar) {
        while (contains(cVar.element)) {
            f fVar = cVar.left;
            if (fVar instanceof c) {
                cVar = (c) fVar;
            } else if (fVar != null) {
                return contains((f.b) fVar);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            }
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return cVar.size() == size() && cVar.containsAll(this);
    }

    public final int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    static final class b extends l implements m<String, f.b, String> {
        public static final b INSTANCE = new b();

        b() {
            super(2);
        }

        public final String invoke(String str, f.b bVar) {
            k.d(str, "acc");
            k.d(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public final String toString() {
        return "[" + ((String) fold("", b.INSTANCE)) + "]";
    }

    private final Object writeReplace() {
        int size = size();
        f[] fVarArr = new f[size];
        x.c cVar = new x.c();
        boolean z = false;
        cVar.element = 0;
        fold(kotlin.x.f47997a, new C0835c(fVarArr, cVar));
        if (cVar.element == size) {
            z = true;
        }
        if (z) {
            return new a(fVarArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    static final class a implements Serializable {
        public static final C0834a Companion = new C0834a((byte) 0);
        private static final long serialVersionUID = 0;
        private final f[] elements;

        /* renamed from: kotlin.d.c$a$a  reason: collision with other inner class name */
        public static final class C0834a {
            private C0834a() {
            }

            public /* synthetic */ C0834a(byte b2) {
                this();
            }
        }

        public a(f[] fVarArr) {
            k.d(fVarArr, "elements");
            this.elements = fVarArr;
        }

        public final f[] getElements() {
            return this.elements;
        }

        private final Object readResolve() {
            f[] fVarArr = this.elements;
            f fVar = g.INSTANCE;
            for (f plus : fVarArr) {
                fVar = fVar.plus(plus);
            }
            return fVar;
        }
    }
}
