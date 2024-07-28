package kotlinx.coroutines;

import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.p;

public final class DebugStringsKt {
    public static final String getHexAddress(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String toDebugString(d<?> dVar) {
        Object obj;
        if (dVar instanceof DispatchedContinuation) {
            return dVar.toString();
        }
        try {
            p.a aVar = p.Companion;
            obj = p.m530constructorimpl(dVar + '@' + getHexAddress(dVar));
        } catch (Throwable th) {
            p.a aVar2 = p.Companion;
            obj = p.m530constructorimpl(ResultKt.a(th));
        }
        if (p.m533exceptionOrNullimpl(obj) != null) {
            obj = dVar.getClass().getName() + '@' + getHexAddress(dVar);
        }
        return (String) obj;
    }

    public static final String getClassSimpleName(Object obj) {
        return obj.getClass().getSimpleName();
    }
}
