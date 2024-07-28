package com.alibaba.wireless.security.b;

import java.io.PrintStream;
import java.io.PrintWriter;

public final class b extends Exception {
    public static final int ERROR_NULL_CONTEXT = -100;

    /* renamed from: a  reason: collision with root package name */
    private int f14643a;

    public b(int i2) {
        this.f14643a = i2;
    }

    public b(String str, int i2) {
        super(str);
        this.f14643a = i2;
    }

    public b(String str, Throwable th, int i2) {
        super(str, th);
        this.f14643a = i2;
    }

    public b(Throwable th, int i2) {
        super(th);
        this.f14643a = i2;
    }

    public final int getErrorCode() {
        return this.f14643a;
    }

    public final void printStackTrace(PrintStream printStream) {
        printStream.println("ErrorCode = " + getErrorCode());
        super.printStackTrace(printStream);
    }

    public final void printStackTrace(PrintWriter printWriter) {
        printWriter.println("ErrorCode = " + getErrorCode());
        super.printStackTrace(printWriter);
    }

    public final void setErrorCode(int i2) {
        this.f14643a = i2;
    }
}
