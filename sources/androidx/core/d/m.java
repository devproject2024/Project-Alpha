package androidx.core.d;

import android.os.Build;
import android.os.Trace;
import java.lang.reflect.Method;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static long f2863a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f2864b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f2865c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f2866d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f2867e;

    static {
        if (Build.VERSION.SDK_INT >= 18 && Build.VERSION.SDK_INT < 29) {
            try {
                f2863a = Trace.class.getField("TRACE_TAG_APP").getLong((Object) null);
                f2864b = Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});
                f2865c = Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});
                f2866d = Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});
                f2867e = Trace.class.getMethod("traceCounter", new Class[]{Long.TYPE, String.class, Integer.TYPE});
            } catch (Exception unused) {
            }
        }
    }

    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
