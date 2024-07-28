package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.b.g;
import com.google.android.exoplayer2.g.ae;
import java.nio.ByteBuffer;

final class q extends m {

    /* renamed from: f  reason: collision with root package name */
    private static final int f31253f = Float.floatToIntBits(Float.NaN);

    public final int c() {
        return 4;
    }

    q() {
    }

    public final boolean a(int i2, int i3, int i4) throws g.a {
        if (ae.d(i4)) {
            return b(i2, i3, i4);
        }
        throw new g.a(i2, i3, i4);
    }

    public final boolean a() {
        return ae.d(this.f31214d);
    }

    public final void a(ByteBuffer byteBuffer) {
        boolean z = this.f31214d == 1073741824;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        if (!z) {
            i2 = (i2 / 3) * 4;
        }
        ByteBuffer a2 = a(i2);
        if (z) {
            while (position < limit) {
                a((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), a2);
                position += 4;
            }
        } else {
            while (position < limit) {
                a(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), a2);
                position += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        a2.flip();
    }

    private static void a(int i2, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (((double) i2) * 4.656612875245797E-10d));
        if (floatToIntBits == f31253f) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }
}
