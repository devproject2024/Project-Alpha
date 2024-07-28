package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import kotlin.ResultKt;
import kotlin.p;
import kotlin.u;

public final class HandlerDispatcherKt {
    public static final HandlerDispatcher Main;

    public static final Handler asHandler(Looper looper, boolean z) {
        if (!z || Build.VERSION.SDK_INT < 16) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke((Object) null, new Object[]{looper});
            if (invoke != null) {
                return (Handler) invoke;
            }
            throw new u("null cannot be cast to non-null type android.os.Handler");
        }
        Class<Handler> cls = Handler.class;
        try {
            return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }

    static {
        Object obj;
        try {
            p.a aVar = p.Companion;
            obj = p.m530constructorimpl(new HandlerContext(asHandler(Looper.getMainLooper(), true), "Main"));
        } catch (Throwable th) {
            p.a aVar2 = p.Companion;
            obj = p.m530constructorimpl(ResultKt.a(th));
        }
        if (p.m536isFailureimpl(obj)) {
            obj = null;
        }
        Main = (HandlerDispatcher) obj;
    }
}
