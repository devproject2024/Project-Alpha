package com.google.firebase.crashlytics.a.l;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f38706a;

    /* renamed from: b  reason: collision with root package name */
    public final String f38707b;

    /* renamed from: c  reason: collision with root package name */
    public final StackTraceElement[] f38708c;

    /* renamed from: d  reason: collision with root package name */
    public final e f38709d;

    public e(Throwable th, d dVar) {
        this.f38706a = th.getLocalizedMessage();
        this.f38707b = th.getClass().getName();
        this.f38708c = dVar.a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.f38709d = cause != null ? new e(cause, dVar) : null;
    }
}
