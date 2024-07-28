package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import kotlin.ResultKt;
import kotlin.g.a.b;
import kotlin.g.b.l;
import kotlin.p;
import kotlin.u;

public final class ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4 extends l implements b<Throwable, Throwable> {
    final /* synthetic */ Constructor $constructor$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(Constructor constructor) {
        super(1);
        this.$constructor$inlined = constructor;
    }

    public final Throwable invoke(Throwable th) {
        Object obj;
        try {
            Object newInstance = this.$constructor$inlined.newInstance(new Object[0]);
            if (newInstance != null) {
                Throwable th2 = (Throwable) newInstance;
                th2.initCause(th);
                obj = p.m530constructorimpl(th2);
                if (p.m536isFailureimpl(obj)) {
                    obj = null;
                }
                return (Throwable) obj;
            }
            throw new u("null cannot be cast to non-null type kotlin.Throwable");
        } catch (Throwable th3) {
            obj = p.m530constructorimpl(ResultKt.a(th3));
        }
    }
}
