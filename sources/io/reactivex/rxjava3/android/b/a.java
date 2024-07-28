package io.reactivex.rxjava3.android.b;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.d.h;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final x f46629a;

    /* renamed from: io.reactivex.rxjava3.android.b.a$a  reason: collision with other inner class name */
    static final class C0783a {
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public static final x f46630a = new b(new Handler(Looper.getMainLooper()));
    }

    static {
        x xVar;
        $$Lambda$a$lej1wdIJrNPzy8KHa0iCH5rDHA r0 = $$Lambda$a$lej1wdIJrNPzy8KHa0iCH5rDHA.INSTANCE;
        if (r0 != null) {
            h hVar = io.reactivex.rxjava3.android.a.a.f46627a;
            if (hVar == null) {
                xVar = io.reactivex.rxjava3.android.a.a.a(r0);
            } else {
                xVar = (x) io.reactivex.rxjava3.android.a.a.a(hVar, r0);
                if (xVar == null) {
                    throw new NullPointerException("Scheduler Callable returned null");
                }
            }
            f46629a = xVar;
            return;
        }
        throw new NullPointerException("scheduler == null");
    }

    public static x a() {
        x xVar = f46629a;
        if (xVar != null) {
            h hVar = io.reactivex.rxjava3.android.a.a.f46628b;
            if (hVar == null) {
                return xVar;
            }
            return (x) io.reactivex.rxjava3.android.a.a.a(hVar, xVar);
        }
        throw new NullPointerException("scheduler == null");
    }
}
