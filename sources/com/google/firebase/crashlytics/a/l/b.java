package com.google.firebase.crashlytics.a.l;

import com.alipay.mobile.nebula.util.tar.TarConstants;

public final class b implements d {

    /* renamed from: a  reason: collision with root package name */
    private final int f38704a = TarConstants.EOF_BLOCK;

    public final StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        int length = stackTraceElementArr.length;
        int i2 = this.f38704a;
        if (length <= i2) {
            return stackTraceElementArr;
        }
        int i3 = i2 / 2;
        int i4 = i2 - i3;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i2];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, i4);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i3, stackTraceElementArr2, i4, i3);
        return stackTraceElementArr2;
    }
}
