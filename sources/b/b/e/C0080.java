package b.b.e;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: b.b.e.ı  reason: contains not printable characters */
public class C0080 extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final int f5538a;

    /* renamed from: b  reason: collision with root package name */
    private long[] f5539b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f5540c;

    /* renamed from: d  reason: collision with root package name */
    private short f5541d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f5542e;

    /* renamed from: f  reason: collision with root package name */
    private int f5543f = Integer.MAX_VALUE;

    /* renamed from: g  reason: collision with root package name */
    private int f5544g;

    /* renamed from: h  reason: collision with root package name */
    private int f5545h;

    public boolean markSupported() {
        return false;
    }

    public C0080(InputStream inputStream, int i2, int i3, short s, int i4, int i5) throws IOException {
        super(inputStream);
        this.f5538a = Math.min(Math.max(s, 4), 8);
        int i6 = this.f5538a;
        this.f5542e = new byte[i6];
        this.f5539b = new long[4];
        this.f5540c = new long[4];
        this.f5544g = i6;
        this.f5545h = i6;
        this.f5539b = a.a(i2 ^ i5, i6 ^ i5);
        this.f5540c = a.a(i3 ^ i5, i4 ^ i5);
    }

    public int read() throws IOException {
        b();
        int i2 = this.f5544g;
        if (i2 >= this.f5545h) {
            return -1;
        }
        byte[] bArr = this.f5542e;
        this.f5544g = i2 + 1;
        return bArr[i2] & 255;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = i2 + i3;
        int i5 = i2;
        while (i5 < i4) {
            b();
            int i6 = this.f5544g;
            if (i6 < this.f5545h) {
                byte[] bArr2 = this.f5542e;
                this.f5544g = i6 + 1;
                bArr[i5] = bArr2[i6];
                i5++;
            } else if (i5 == i2) {
                return -1;
            } else {
                return i3 - (i4 - i5);
            }
        }
        return i3;
    }

    public long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    public int available() throws IOException {
        b();
        return this.f5545h - this.f5544g;
    }

    private void a() {
        long[] jArr = this.f5539b;
        long[] jArr2 = this.f5540c;
        short s = this.f5541d;
        int i2 = (s + 2) % 4;
        int i3 = (s + 3) % 4;
        jArr2[i3] = ((jArr[i3] * 2147483085) + jArr2[i2]) / 2147483647L;
        jArr[i3] = ((jArr[s % 4] * 2147483085) + jArr2[i2]) % 2147483647L;
        for (int i4 = 0; i4 < this.f5538a; i4++) {
            byte[] bArr = this.f5542e;
            bArr[i4] = (byte) ((int) (((long) bArr[i4]) ^ ((this.f5539b[this.f5541d] >> (i4 << 3)) & 255)));
        }
        this.f5541d = (short) ((this.f5541d + 1) % 4);
    }

    private int b() throws IOException {
        int read;
        int i2;
        if (this.f5543f == Integer.MAX_VALUE) {
            this.f5543f = this.in.read();
        }
        if (this.f5544g == this.f5538a) {
            byte[] bArr = this.f5542e;
            int i3 = this.f5543f;
            bArr[0] = (byte) i3;
            if (i3 >= 0) {
                int i4 = 1;
                do {
                    read = this.in.read(this.f5542e, i4, this.f5538a - i4);
                    if (read <= 0 || (i4 = i4 + read) >= this.f5538a) {
                    }
                    read = this.in.read(this.f5542e, i4, this.f5538a - i4);
                    break;
                } while ((i4 = i4 + read) >= this.f5538a);
                if (i4 >= this.f5538a) {
                    a();
                    this.f5543f = this.in.read();
                    this.f5544g = 0;
                    if (this.f5543f < 0) {
                        int i5 = this.f5538a;
                        i2 = i5 - (this.f5542e[i5 - 1] & 255);
                    } else {
                        i2 = this.f5538a;
                    }
                    this.f5545h = i2;
                } else {
                    throw new IllegalStateException("unexpected block size");
                }
            } else {
                throw new IllegalStateException("unexpected block size");
            }
        }
        return this.f5545h;
    }
}
