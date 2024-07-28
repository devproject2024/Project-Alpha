package com.alipay.mobile.a;

import android.util.Pair;
import java.util.List;

public final class c {
    public static void a(String str, Object obj, Object[] objArr) {
        List<a> a2 = b.a().a(str);
        if (a2 != null && !a2.isEmpty()) {
            for (a next : a2) {
                if (next != null) {
                    try {
                        next.onExecutionBefore(str, obj, objArr);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static Pair<Boolean, Object> b(String str, Object obj, Object[] objArr) {
        List<a> a2 = b.a().a(str);
        Pair<Boolean, Object> pair = null;
        if (a2 != null && !a2.isEmpty()) {
            for (a next : a2) {
                if (next != null) {
                    try {
                        pair = next.onExecutionAround(str, obj, objArr);
                    } catch (Throwable unused) {
                    }
                    if (pair != null && ((Boolean) pair.first).booleanValue()) {
                        break;
                    }
                }
            }
        }
        return pair;
    }

    public static void c(String str, Object obj, Object[] objArr) {
        List<a> a2 = b.a().a(str);
        if (a2 != null && !a2.isEmpty()) {
            for (a next : a2) {
                if (next != null) {
                    try {
                        next.onExecutionAfter(str, obj, objArr);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }
}
