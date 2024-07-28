package com.google.firebase.crashlytics.a.l;

import java.util.HashMap;

public final class c implements d {

    /* renamed from: a  reason: collision with root package name */
    private final int f38705a;

    public c() {
        this(1);
    }

    public c(int i2) {
        this.f38705a = i2;
    }

    public final StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        int i2;
        int i3 = this.f38705a;
        HashMap hashMap = new HashMap();
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[stackTraceElementArr.length];
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (i4 < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i4];
            Integer num = (Integer) hashMap.get(stackTraceElement);
            if (num == null || !a(stackTraceElementArr, num.intValue(), i4)) {
                stackTraceElementArr2[i5] = stackTraceElementArr[i4];
                i5++;
                i2 = i4;
                i6 = 1;
            } else {
                int intValue = i4 - num.intValue();
                if (i6 < i3) {
                    System.arraycopy(stackTraceElementArr, i4, stackTraceElementArr2, i5, intValue);
                    i5 += intValue;
                    i6++;
                }
                i2 = (intValue - 1) + i4;
            }
            hashMap.put(stackTraceElement, Integer.valueOf(i4));
            i4 = i2 + 1;
        }
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[i5];
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, 0, stackTraceElementArr3.length);
        return stackTraceElementArr3.length < stackTraceElementArr.length ? stackTraceElementArr3 : stackTraceElementArr;
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr, int i2, int i3) {
        int i4 = i3 - i2;
        if (i3 + i4 > stackTraceElementArr.length) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!stackTraceElementArr[i2 + i5].equals(stackTraceElementArr[i3 + i5])) {
                return false;
            }
        }
        return true;
    }
}
