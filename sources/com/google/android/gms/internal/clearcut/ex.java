package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public class ex {

    /* renamed from: b  reason: collision with root package name */
    protected volatile int f9357b = -1;

    /* access modifiers changed from: protected */
    public int a() {
        return 0;
    }

    public void a(eq eqVar) throws IOException {
    }

    /* renamed from: c */
    public ex clone() throws CloneNotSupportedException {
        return (ex) super.clone();
    }

    public final int d() {
        int a2 = a();
        this.f9357b = a2;
        return a2;
    }

    public String toString() {
        return ez.a(this);
    }

    public static final void a(ex exVar, byte[] bArr, int i2) {
        try {
            eq a2 = eq.a(bArr, i2);
            exVar.a(a2);
            if (a2.f9341a.remaining() != 0) {
                throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(a2.f9341a.remaining())}));
            }
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }
}
