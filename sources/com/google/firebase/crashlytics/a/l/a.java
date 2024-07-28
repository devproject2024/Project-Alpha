package com.google.firebase.crashlytics.a.l;

import com.alipay.mobile.nebula.util.tar.TarConstants;

public final class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private final int f38701a = TarConstants.EOF_BLOCK;

    /* renamed from: b  reason: collision with root package name */
    private final d[] f38702b;

    /* renamed from: c  reason: collision with root package name */
    private final b f38703c;

    public a(d... dVarArr) {
        this.f38702b = dVarArr;
        this.f38703c = new b();
    }

    public final StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f38701a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (d dVar : this.f38702b) {
            if (stackTraceElementArr2.length <= this.f38701a) {
                break;
            }
            stackTraceElementArr2 = dVar.a(stackTraceElementArr);
        }
        return stackTraceElementArr2.length > this.f38701a ? this.f38703c.a(stackTraceElementArr2) : stackTraceElementArr2;
    }
}
