package com.google.firebase.crashlytics.a.h;

import android.app.ActivityManager;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.firebase.crashlytics.a.b;
import com.google.firebase.crashlytics.a.l.e;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.List;
import java.util.Map;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final a f38611a = a.a("0");

    /* renamed from: b  reason: collision with root package name */
    private static final a f38612b = a.a("Unity");

    public static void a(c cVar, String str, String str2, long j) throws Exception {
        cVar.a(1, a.a(str2));
        cVar.a(2, a.a(str));
        cVar.a(3, j);
    }

    public static void a(c cVar, String str, String str2, String str3, String str4, int i2, String str5) throws Exception {
        a a2 = a.a(str);
        a a3 = a.a(str2);
        a a4 = a.a(str3);
        a a5 = a.a(str4);
        a a6 = str5 != null ? a.a(str5) : null;
        cVar.e(7, 2);
        int b2 = c.b(1, a2) + 0 + c.b(2, a3) + c.b(3, a4) + c.b(6, a5);
        if (a6 != null) {
            b2 = b2 + c.b(8, f38612b) + c.b(9, a6);
        }
        cVar.d(b2 + c.d(10, i2));
        cVar.a(1, a2);
        cVar.a(2, a3);
        cVar.a(3, a4);
        cVar.a(6, a5);
        if (a6 != null) {
            cVar.a(8, f38612b);
            cVar.a(9, a6);
        }
        cVar.b(10, i2);
    }

    public static void a(c cVar, String str, String str2, boolean z) throws Exception {
        a a2 = a.a(str);
        a a3 = a.a(str2);
        cVar.e(8, 2);
        cVar.d(c.d(1, 3) + 0 + c.b(2, a2) + c.b(3, a3) + c.a(4));
        cVar.b(1, 3);
        cVar.a(2, a2);
        cVar.a(3, a3);
        cVar.a(4, z);
    }

    public static void a(c cVar, int i2, String str, int i3, long j, long j2, boolean z, int i4, String str2, String str3) throws Exception {
        int i5;
        int i6;
        int i7;
        c cVar2 = cVar;
        int i8 = i2;
        int i9 = i3;
        long j3 = j;
        long j4 = j2;
        int i10 = i4;
        a a2 = a(str);
        a a3 = a(str3);
        a a4 = a(str2);
        cVar2.e(9, 2);
        int d2 = c.d(3, i8) + 0;
        if (a2 == null) {
            i5 = 0;
        } else {
            i5 = c.b(4, a2);
        }
        int c2 = d2 + i5 + c.c(5, i9) + c.b(6, j3) + c.b(7, j4) + c.a(10) + c.c(12, i10);
        if (a4 == null) {
            i6 = 0;
        } else {
            i6 = c.b(13, a4);
        }
        int i11 = c2 + i6;
        if (a3 == null) {
            i7 = 0;
        } else {
            i7 = c.b(14, a3);
        }
        cVar2.d(i11 + i7);
        cVar2.b(3, i8);
        cVar2.a(4, a2);
        cVar2.a(5, i9);
        cVar2.a(6, j3);
        cVar2.a(7, j4);
        cVar2.a(10, z);
        cVar2.a(12, i10);
        if (a4 != null) {
            cVar2.a(13, a4);
        }
        if (a3 != null) {
            cVar2.a(14, a3);
        }
    }

    public static void a(c cVar, String str) throws Exception {
        if (str == null) {
            str = "";
        }
        a a2 = a.a(str);
        a((String) null);
        a((String) null);
        cVar.e(6, 2);
        cVar.d(c.b(1, a2) + 0);
        cVar.a(1, a2);
    }

    public static void a(c cVar, long j, String str, e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, Map<String, String> map, byte[] bArr, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2, String str2, String str3, Float f2, int i3, boolean z, long j2, long j3) throws Exception {
        a aVar;
        c cVar2 = cVar;
        long j4 = j;
        Thread[] threadArr2 = threadArr;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo2 = runningAppProcessInfo;
        int i4 = i2;
        String str4 = str3;
        a a2 = a.a(str2);
        a aVar2 = null;
        if (str4 == null) {
            aVar = null;
        } else {
            aVar = a.a(str4.replace("-", ""));
        }
        if (bArr != null) {
            aVar2 = a.a(bArr);
        } else {
            b.a().a(3);
        }
        cVar2.e(10, 2);
        int b2 = c.b(1, j4) + 0 + c.b(2, a.a(str));
        a aVar3 = aVar2;
        a aVar4 = aVar;
        String str5 = "";
        a aVar5 = a2;
        int a3 = a(eVar, thread, stackTraceElementArr, threadArr, list, a2, aVar, map, runningAppProcessInfo, i2);
        int c2 = b2 + c.c(3) + c.e(a3) + a3;
        int a4 = a(f2, i3, i2, j2, j3);
        int c3 = c2 + c.c(5) + c.e(a4) + a4;
        if (aVar3 != null) {
            int b3 = c.b(1, aVar3);
            c3 += c.c(6) + c.e(b3) + b3;
        }
        cVar2.d(c3);
        cVar2.a(1, j4);
        cVar2.a(2, a.a(str));
        cVar2.e(3, 2);
        Thread thread2 = thread;
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        Thread[] threadArr3 = threadArr;
        List<StackTraceElement[]> list2 = list;
        a aVar6 = aVar5;
        a aVar7 = aVar4;
        cVar2.d(a(eVar, thread2, stackTraceElementArr2, threadArr3, list2, aVar6, aVar7, map, runningAppProcessInfo, i2));
        cVar2.e(1, 2);
        cVar2.d(a(eVar, thread2, stackTraceElementArr2, threadArr3, list2, aVar6, aVar7));
        a(cVar2, thread2, stackTraceElementArr2, 4, true);
        int length = threadArr2.length;
        for (int i5 = 0; i5 < length; i5++) {
            a(cVar2, threadArr2[i5], list.get(i5), 0, false);
        }
        e eVar2 = eVar;
        int i6 = 2;
        int i7 = 1;
        while (true) {
            cVar2.e(i6, 2);
            cVar2.d(a(eVar2, 1, 8));
            cVar2.a(1, a.a(eVar2.f38707b));
            String str6 = eVar2.f38706a;
            if (str6 != null) {
                cVar2.a(3, a.a(str6));
            }
            for (StackTraceElement a5 : eVar2.f38708c) {
                a(cVar2, 4, a5, true);
            }
            eVar2 = eVar2.f38709d;
            if (eVar2 == null) {
                break;
            } else if (i7 < 8) {
                i7++;
                i6 = 6;
            } else {
                int i8 = 0;
                while (eVar2 != null) {
                    eVar2 = eVar2.f38709d;
                    i8++;
                }
                cVar2.a(7, i8);
            }
        }
        cVar2.e(3, 2);
        cVar2.d(a());
        cVar2.a(1, f38611a);
        cVar2.a(2, f38611a);
        cVar2.a(3, 0);
        cVar2.e(4, 2);
        a aVar8 = aVar4;
        a aVar9 = aVar5;
        cVar2.d(a(aVar9, aVar8));
        cVar2.a(1, 0);
        cVar2.a(2, 0);
        cVar2.a(3, aVar9);
        if (aVar8 != null) {
            cVar2.a(4, aVar8);
        }
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                cVar2.e(2, 2);
                cVar2.d(a((String) next.getKey(), (String) next.getValue()));
                cVar2.a(1, a.a((String) next.getKey()));
                String str7 = (String) next.getValue();
                if (str7 == null) {
                    str7 = str5;
                }
                cVar2.a(2, a.a(str7));
            }
        }
        if (runningAppProcessInfo2 != null) {
            cVar2.a(3, runningAppProcessInfo2.importance != 100);
        }
        int i9 = i2;
        cVar2.a(4, i9);
        cVar2.e(5, 2);
        cVar2.d(a(f2, i3, i2, j2, j3));
        if (f2 != null) {
            float floatValue = f2.floatValue();
            cVar2.e(1, 5);
            int floatToRawIntBits = Float.floatToRawIntBits(floatValue);
            cVar2.a((byte) (floatToRawIntBits & PriceRangeSeekBar.INVALID_POINTER_ID));
            cVar2.a((byte) ((floatToRawIntBits >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID));
            cVar2.a((byte) ((floatToRawIntBits >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID));
            cVar2.a((byte) ((floatToRawIntBits >> 24) & PriceRangeSeekBar.INVALID_POINTER_ID));
        }
        cVar2.e(2, 0);
        cVar2.d(c.f(i3));
        cVar2.a(3, z);
        cVar2.a(4, i9);
        cVar2.a(5, j2);
        cVar2.a(6, j3);
        if (aVar3 != null) {
            cVar2.e(6, 2);
            cVar2.d(c.b(1, aVar3));
            cVar2.a(1, aVar3);
        }
    }

    public static void b(c cVar, String str) throws Exception {
        a a2 = a.a(str);
        cVar.e(7, 2);
        int b2 = c.b(2, a2);
        cVar.d(c.c(5) + c.e(b2) + b2);
        cVar.e(5, 2);
        cVar.d(b2);
        cVar.a(2, a2);
    }

    private static void a(c cVar, Thread thread, StackTraceElement[] stackTraceElementArr, int i2, boolean z) throws Exception {
        cVar.e(1, 2);
        cVar.d(a(thread, stackTraceElementArr, i2, z));
        cVar.a(1, a.a(thread.getName()));
        cVar.a(2, i2);
        for (StackTraceElement a2 : stackTraceElementArr) {
            a(cVar, 3, a2, z);
        }
    }

    private static void a(c cVar, int i2, StackTraceElement stackTraceElement, boolean z) throws Exception {
        cVar.e(i2, 2);
        cVar.d(a(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            cVar.a(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            cVar.a(1, 0);
        }
        cVar.a(2, a.a(stackTraceElement.getClassName() + AppUtility.CENTER_DOT + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            cVar.a(3, a.a(stackTraceElement.getFileName()));
        }
        int i3 = 4;
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            cVar.a(4, (long) stackTraceElement.getLineNumber());
        }
        if (!z) {
            i3 = 0;
        }
        cVar.a(5, i3);
    }

    private static int a(a aVar, a aVar2) {
        int b2 = c.b(1, 0) + 0 + c.b(2, 0) + c.b(3, aVar);
        return aVar2 != null ? b2 + c.b(4, aVar2) : b2;
    }

    private static int a(e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, a aVar, a aVar2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int a2 = a(eVar, thread, stackTraceElementArr, threadArr, list, aVar, aVar2);
        int c2 = c.c(1) + c.e(a2) + a2 + 0;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                int a3 = a((String) next.getKey(), (String) next.getValue());
                c2 += c.c(2) + c.e(a3) + a3;
            }
        }
        if (runningAppProcessInfo != null) {
            int i3 = runningAppProcessInfo.importance;
            c2 += c.a(3);
        }
        return c2 + c.c(4, i2);
    }

    private static int a(e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, a aVar, a aVar2) {
        int a2 = a(thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        int c2 = c.c(1) + c.e(a2) + a2 + 0;
        for (int i2 = 0; i2 < length; i2++) {
            int a3 = a(threadArr[i2], list.get(i2), 0, false);
            c2 += c.c(1) + c.e(a3) + a3;
        }
        int a4 = a(eVar, 1, 8);
        int a5 = a();
        int a6 = a(aVar, aVar2);
        return c2 + c.c(2) + c.e(a4) + a4 + c.c(3) + c.e(a5) + a5 + c.c(3) + c.e(a6) + a6;
    }

    private static int a(String str, String str2) {
        int b2 = c.b(1, a.a(str));
        if (str2 == null) {
            str2 = "";
        }
        return b2 + c.b(2, a.a(str2));
    }

    private static int a(Float f2, int i2, int i3, long j, long j2) {
        int i4 = 0;
        if (f2 != null) {
            f2.floatValue();
            i4 = 0 + c.a();
        }
        return i4 + c.b(i2) + c.a(3) + c.c(4, i3) + c.b(5, j) + c.b(6, j2);
    }

    private static int a(e eVar, int i2, int i3) {
        int i4 = 0;
        int b2 = c.b(1, a.a(eVar.f38707b)) + 0;
        String str = eVar.f38706a;
        if (str != null) {
            b2 += c.b(3, a.a(str));
        }
        int i5 = b2;
        for (StackTraceElement a2 : eVar.f38708c) {
            int a3 = a(a2, true);
            i5 += c.c(4) + c.e(a3) + a3;
        }
        e eVar2 = eVar.f38709d;
        if (eVar2 == null) {
            return i5;
        }
        if (i2 < i3) {
            int a4 = a(eVar2, i2 + 1, i3);
            return i5 + c.c(6) + c.e(a4) + a4;
        }
        while (eVar2 != null) {
            eVar2 = eVar2.f38709d;
            i4++;
        }
        return i5 + c.c(7, i4);
    }

    private static int a() {
        return c.b(1, f38611a) + 0 + c.b(2, f38611a) + c.b(3, 0);
    }

    private static int a(StackTraceElement stackTraceElement, boolean z) {
        int i2;
        int i3 = 0;
        if (stackTraceElement.isNativeMethod()) {
            i2 = c.b(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            i2 = c.b(1, 0);
        }
        int b2 = i2 + 0 + c.b(2, a.a(stackTraceElement.getClassName() + AppUtility.CENTER_DOT + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            b2 += c.b(3, a.a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            b2 += c.b(4, (long) stackTraceElement.getLineNumber());
        }
        if (z) {
            i3 = 2;
        }
        return b2 + c.c(5, i3);
    }

    private static int a(Thread thread, StackTraceElement[] stackTraceElementArr, int i2, boolean z) {
        int b2 = c.b(1, a.a(thread.getName())) + c.c(2, i2);
        for (StackTraceElement a2 : stackTraceElementArr) {
            int a3 = a(a2, z);
            b2 += c.c(3) + c.e(a3) + a3;
        }
        return b2;
    }

    private static a a(String str) {
        if (str == null) {
            return null;
        }
        return a.a(str);
    }
}
