package kotlin.i.a;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.g.b.k;

public final class a extends kotlin.i.a {
    public final Random a() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        k.a((Object) current, "ThreadLocalRandom.current()");
        return current;
    }

    public final int a(int i2, int i3) {
        return ThreadLocalRandom.current().nextInt(i2, i3);
    }
}
