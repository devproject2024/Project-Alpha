package kotlinx.coroutines;

import kotlin.d.a;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import kotlinx.coroutines.ThreadContextElement;

public final class CoroutineId extends a implements ThreadContextElement<String> {
    public static final Key Key = new Key((g) null);
    private final long id;

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CoroutineId) && this.id == ((CoroutineId) obj).id;
        }
        return true;
    }

    public final int hashCode() {
        long j = this.id;
        return (int) (j ^ (j >>> 32));
    }

    public final <R> R fold(R r, m<? super R, ? super f.b, ? extends R> mVar) {
        return ThreadContextElement.DefaultImpls.fold(this, r, mVar);
    }

    public final <E extends f.b> E get(f.c<E> cVar) {
        return ThreadContextElement.DefaultImpls.get(this, cVar);
    }

    public final f minusKey(f.c<?> cVar) {
        return ThreadContextElement.DefaultImpls.minusKey(this, cVar);
    }

    public final f plus(f fVar) {
        return ThreadContextElement.DefaultImpls.plus(this, fVar);
    }

    public final long getId() {
        return this.id;
    }

    public static final class Key implements f.c<CoroutineId> {
        private Key() {
        }

        public /* synthetic */ Key(g gVar) {
            this();
        }
    }

    public CoroutineId(long j) {
        super(Key);
        this.id = j;
    }

    public final String toString() {
        return "CoroutineId(" + this.id + ')';
    }

    public final String updateThreadContext(f fVar) {
        String str;
        CoroutineName coroutineName = (CoroutineName) fVar.get(CoroutineName.Key);
        if (coroutineName == null || (str = coroutineName.getName()) == null) {
            str = "coroutine";
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        int a2 = p.a((CharSequence) name, " @", p.d(name));
        if (a2 < 0) {
            a2 = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + a2 + 10);
        if (name != null) {
            String substring = name.substring(0, a2);
            k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append(" @");
            sb.append(str);
            sb.append('#');
            sb.append(this.id);
            String sb2 = sb.toString();
            k.a((Object) sb2, "StringBuilder(capacity).…builderAction).toString()");
            currentThread.setName(sb2);
            return name;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public final void restoreThreadContext(f fVar, String str) {
        Thread.currentThread().setName(str);
    }
}
