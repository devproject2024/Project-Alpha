package com.google.android.exoplayer2.b;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface g {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteBuffer f31187a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    void a(ByteBuffer byteBuffer);

    boolean a();

    boolean a(int i2, int i3, int i4) throws a;

    int b();

    int c();

    int d();

    void e();

    ByteBuffer f();

    boolean g();

    void h();

    void i();

    public static final class a extends Exception {
        public a(int i2, int i3, int i4) {
            super("Unhandled format: " + i2 + " Hz, " + i3 + " channels in encoding " + i4);
        }
    }
}
