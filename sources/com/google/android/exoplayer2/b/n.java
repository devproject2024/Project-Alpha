package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.b.g;
import com.google.android.exoplayer2.g.a;
import java.nio.ByteBuffer;
import java.util.Arrays;

final class n extends m {

    /* renamed from: f  reason: collision with root package name */
    int[] f31218f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f31219g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f31220h;

    n() {
    }

    public final boolean a(int i2, int i3, int i4) throws g.a {
        boolean z = !Arrays.equals(this.f31218f, this.f31220h);
        this.f31220h = this.f31218f;
        int[] iArr = this.f31220h;
        if (iArr == null) {
            this.f31219g = false;
            return z;
        } else if (i4 != 2) {
            throw new g.a(i2, i3, i4);
        } else if (!z && !b(i2, i3, i4)) {
            return false;
        } else {
            this.f31219g = i3 != iArr.length;
            int i5 = 0;
            while (i5 < iArr.length) {
                int i6 = iArr[i5];
                if (i6 < i3) {
                    this.f31219g = (i6 != i5) | this.f31219g;
                    i5++;
                } else {
                    throw new g.a(i2, i3, i4);
                }
            }
            return true;
        }
    }

    public final boolean a() {
        return this.f31219g;
    }

    public final int b() {
        int[] iArr = this.f31220h;
        return iArr == null ? this.f31213c : iArr.length;
    }

    public final void a(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) a.a(this.f31220h);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer a2 = a(((limit - position) / (this.f31213c * 2)) * iArr.length * 2);
        while (position < limit) {
            for (int i2 : iArr) {
                a2.putShort(byteBuffer.getShort((i2 * 2) + position));
            }
            position += this.f31213c * 2;
        }
        byteBuffer.position(limit);
        a2.flip();
    }

    /* access modifiers changed from: protected */
    public final void l() {
        this.f31220h = null;
        this.f31218f = null;
        this.f31219g = false;
    }
}
