package kotlinx.coroutines;

import kotlin.d.a;
import kotlin.d.f;
import kotlin.g.b.g;

public final class YieldContext extends a {
    public static final Key Key = new Key((g) null);
    public boolean dispatcherWasUnconfined;

    public static final class Key implements f.c<YieldContext> {
        private Key() {
        }

        public /* synthetic */ Key(g gVar) {
            this();
        }
    }

    public YieldContext() {
        super(Key);
    }
}
