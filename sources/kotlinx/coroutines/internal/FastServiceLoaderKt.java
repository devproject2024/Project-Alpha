package kotlinx.coroutines.internal;

import kotlin.ResultKt;
import kotlin.p;

public final class FastServiceLoaderKt {
    private static final boolean ANDROID_DETECTED;

    static {
        Object obj;
        try {
            p.a aVar = p.Companion;
            obj = p.m530constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            p.a aVar2 = p.Companion;
            obj = p.m530constructorimpl(ResultKt.a(th));
        }
        ANDROID_DETECTED = p.m537isSuccessimpl(obj);
    }

    public static final boolean getANDROID_DETECTED() {
        return ANDROID_DETECTED;
    }
}
