package kotlinx.coroutines;

import kotlin.d.a;
import kotlin.d.f;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CoroutineName extends a {
    public static final Key Key = new Key((g) null);
    private final String name;

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CoroutineName) && k.a((Object) this.name, (Object) ((CoroutineName) obj).name);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.name;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String getName() {
        return this.name;
    }

    public static final class Key implements f.c<CoroutineName> {
        private Key() {
        }

        public /* synthetic */ Key(g gVar) {
            this();
        }
    }

    public final String toString() {
        return "CoroutineName(" + this.name + ')';
    }
}
