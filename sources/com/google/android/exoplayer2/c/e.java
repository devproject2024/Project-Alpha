package com.google.android.exoplayer2.c;

import java.nio.ByteBuffer;

public class e extends a {

    /* renamed from: b  reason: collision with root package name */
    public final b f31310b = new b();

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f31311c;

    /* renamed from: d  reason: collision with root package name */
    public long f31312d;

    /* renamed from: e  reason: collision with root package name */
    private final int f31313e;

    public e(int i2) {
        this.f31313e = i2;
    }

    public final void c(int i2) {
        ByteBuffer byteBuffer = this.f31311c;
        if (byteBuffer == null) {
            this.f31311c = d(i2);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.f31311c.position();
        int i3 = i2 + position;
        if (capacity < i3) {
            ByteBuffer d2 = d(i3);
            if (position > 0) {
                this.f31311c.position(0);
                this.f31311c.limit(position);
                d2.put(this.f31311c);
            }
            this.f31311c = d2;
        }
    }

    public final boolean e() {
        return this.f31311c == null && this.f31313e == 0;
    }

    public final boolean f() {
        return b(1073741824);
    }

    public final void g() {
        this.f31311c.flip();
    }

    public final void a() {
        super.a();
        ByteBuffer byteBuffer = this.f31311c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    private ByteBuffer d(int i2) {
        int i3 = this.f31313e;
        if (i3 == 1) {
            return ByteBuffer.allocate(i2);
        }
        if (i3 == 2) {
            return ByteBuffer.allocateDirect(i2);
        }
        ByteBuffer byteBuffer = this.f31311c;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        throw new IllegalStateException("Buffer too small (" + capacity + " < " + i2 + ")");
    }
}
