package kotlin.i;

import java.util.Random;
import kotlin.g.b.k;

public final class b extends a {

    /* renamed from: c  reason: collision with root package name */
    private final a f47935c = new a();

    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        public final /* synthetic */ Object initialValue() {
            return new Random();
        }
    }

    public final Random a() {
        Object obj = this.f47935c.get();
        k.b(obj, "implStorage.get()");
        return (Random) obj;
    }
}
