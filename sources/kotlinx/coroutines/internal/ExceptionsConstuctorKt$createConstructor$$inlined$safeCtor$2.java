package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import kotlin.ResultKt;
import kotlin.g.a.b;
import kotlin.g.b.l;
import kotlin.p;
import kotlin.u;

public final class ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2 extends l implements b<Throwable, Throwable> {
    final /* synthetic */ Constructor $constructor$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(Constructor constructor) {
        super(1);
        this.$constructor$inlined = constructor;
    }

    public final Throwable invoke(Throwable th) {
        Object obj;
        try {
            Object newInstance = this.$constructor$inlined.newInstance(new Object[]{th});
            if (newInstance != null) {
                obj = p.m530constructorimpl((Throwable) newInstance);
                if (p.m536isFailureimpl(obj)) {
                    obj = null;
                }
                return (Throwable) obj;
            }
            throw new u("null cannot be cast to non-null type kotlin.Throwable");
        } catch (Throwable th2) {
            obj = p.m530constructorimpl(ResultKt.a(th2));
        }
    }
}
