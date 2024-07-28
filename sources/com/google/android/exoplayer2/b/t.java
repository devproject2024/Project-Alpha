package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.b.g;
import com.google.android.exoplayer2.g.ae;
import java.nio.ByteBuffer;

public final class t extends m {

    /* renamed from: f  reason: collision with root package name */
    boolean f31255f;

    /* renamed from: g  reason: collision with root package name */
    long f31256g;

    /* renamed from: h  reason: collision with root package name */
    private int f31257h;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f31258i = ae.f32504f;
    private byte[] j = ae.f32504f;
    private int k;
    private int l;
    private int m;
    private boolean n;

    public final boolean a(int i2, int i3, int i4) throws g.a {
        if (i4 == 2) {
            this.f31257h = i3 * 2;
            return b(i2, i3, i4);
        }
        throw new g.a(i2, i3, i4);
    }

    public final boolean a() {
        return super.a() && this.f31255f;
    }

    public final void a(ByteBuffer byteBuffer) {
        int position;
        while (byteBuffer.hasRemaining() && !this.f31215e.hasRemaining()) {
            int i2 = this.k;
            if (i2 == 0) {
                int limit = byteBuffer.limit();
                byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.f31258i.length));
                int limit2 = byteBuffer.limit() - 1;
                while (true) {
                    if (limit2 < byteBuffer.position()) {
                        position = byteBuffer.position();
                        break;
                    } else if (Math.abs(byteBuffer.get(limit2)) > 4) {
                        int i3 = this.f31257h;
                        position = ((limit2 / i3) * i3) + i3;
                        break;
                    } else {
                        limit2 -= 2;
                    }
                }
                if (position == byteBuffer.position()) {
                    this.k = 1;
                } else {
                    byteBuffer.limit(position);
                    int remaining = byteBuffer.remaining();
                    a(remaining).put(byteBuffer).flip();
                    if (remaining > 0) {
                        this.n = true;
                    }
                }
                byteBuffer.limit(limit);
            } else if (i2 == 1) {
                int limit3 = byteBuffer.limit();
                int b2 = b(byteBuffer);
                int position2 = b2 - byteBuffer.position();
                byte[] bArr = this.f31258i;
                int length = bArr.length;
                int i4 = this.l;
                int i5 = length - i4;
                if (b2 >= limit3 || position2 >= i5) {
                    int min = Math.min(position2, i5);
                    byteBuffer.limit(byteBuffer.position() + min);
                    byteBuffer.get(this.f31258i, this.l, min);
                    this.l += min;
                    int i6 = this.l;
                    byte[] bArr2 = this.f31258i;
                    if (i6 == bArr2.length) {
                        if (this.n) {
                            a(bArr2, this.m);
                            this.f31256g += (long) ((this.l - (this.m * 2)) / this.f31257h);
                        } else {
                            this.f31256g += (long) ((i6 - this.m) / this.f31257h);
                        }
                        a(byteBuffer, this.f31258i, this.l);
                        this.l = 0;
                        this.k = 2;
                    }
                    byteBuffer.limit(limit3);
                } else {
                    a(bArr, i4);
                    this.l = 0;
                    this.k = 0;
                }
            } else if (i2 == 2) {
                int limit4 = byteBuffer.limit();
                int b3 = b(byteBuffer);
                byteBuffer.limit(b3);
                this.f31256g += (long) (byteBuffer.remaining() / this.f31257h);
                a(byteBuffer, this.j, this.m);
                if (b3 < limit4) {
                    a(this.j, this.m);
                    this.k = 0;
                    byteBuffer.limit(limit4);
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void j() {
        int i2 = this.l;
        if (i2 > 0) {
            a(this.f31258i, i2);
        }
        if (!this.n) {
            this.f31256g += (long) (this.m / this.f31257h);
        }
    }

    /* access modifiers changed from: protected */
    public final void k() {
        if (a()) {
            int a2 = a(150000) * this.f31257h;
            if (this.f31258i.length != a2) {
                this.f31258i = new byte[a2];
            }
            this.m = a(20000) * this.f31257h;
            int length = this.j.length;
            int i2 = this.m;
            if (length != i2) {
                this.j = new byte[i2];
            }
        }
        this.k = 0;
        this.f31256g = 0;
        this.l = 0;
        this.n = false;
    }

    /* access modifiers changed from: protected */
    public final void l() {
        this.f31255f = false;
        this.m = 0;
        this.f31258i = ae.f32504f;
        this.j = ae.f32504f;
    }

    private void a(byte[] bArr, int i2) {
        a(i2).put(bArr, 0, i2).flip();
        if (i2 > 0) {
            this.n = true;
        }
    }

    private void a(ByteBuffer byteBuffer, byte[] bArr, int i2) {
        int min = Math.min(byteBuffer.remaining(), this.m);
        int i3 = this.m - min;
        System.arraycopy(bArr, i2 - i3, this.j, 0, i3);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.j, i3, min);
    }

    private int a(long j2) {
        return (int) ((j2 * ((long) this.f31212b)) / 1000000);
    }

    private int b(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position() + 1; position < byteBuffer.limit(); position += 2) {
            if (Math.abs(byteBuffer.get(position)) > 4) {
                int i2 = this.f31257h;
                return i2 * (position / i2);
            }
        }
        return byteBuffer.limit();
    }
}
