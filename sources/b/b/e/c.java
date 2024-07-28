package b.b.e;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class c extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final int f5525a;

    /* renamed from: b  reason: collision with root package name */
    private d f5526b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f5527c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f5528d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f5529e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f5530f;

    /* renamed from: g  reason: collision with root package name */
    private int f5531g;

    /* renamed from: h  reason: collision with root package name */
    private int f5532h;

    /* renamed from: i  reason: collision with root package name */
    private int f5533i = Integer.MAX_VALUE;
    private int j;

    public final boolean markSupported() {
        return false;
    }

    public c(InputStream inputStream, int[] iArr, int i2) throws IOException {
        super(inputStream);
        this.f5525a = Math.min(Math.max(i2, 3), 16);
        this.f5527c = new byte[8];
        this.f5528d = new byte[8];
        this.f5529e = new byte[8];
        this.f5530f = new int[2];
        this.f5531g = 8;
        this.f5532h = 8;
        this.j = 1;
        this.f5526b = new d(iArr, this.f5525a, true);
    }

    public final int read() throws IOException {
        b();
        int i2 = this.f5531g;
        if (i2 >= this.f5532h) {
            return -1;
        }
        byte[] bArr = this.f5527c;
        this.f5531g = i2 + 1;
        return bArr[i2] & 255;
    }

    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = i2 + i3;
        int i5 = i2;
        while (i5 < i4) {
            b();
            int i6 = this.f5531g;
            if (i6 < this.f5532h) {
                byte[] bArr2 = this.f5527c;
                this.f5531g = i6 + 1;
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

    public final long skip(long j2) throws IOException {
        long j3 = 0;
        while (j3 < j2 && read() != -1) {
            j3++;
        }
        return j3;
    }

    public final int available() throws IOException {
        b();
        return this.f5532h - this.f5531g;
    }

    private void a() {
        if (this.j == 2) {
            byte[] bArr = this.f5527c;
            System.arraycopy(bArr, 0, this.f5529e, 0, bArr.length);
        }
        byte[] bArr2 = this.f5527c;
        b.a(((bArr2[0] << 24) & -16777216) + ((bArr2[1] << 16) & 16711680) + ((bArr2[2] << 8) & PriceRangeSeekBar.ACTION_POINTER_INDEX_MASK) + (bArr2[3] & 255), (-16777216 & (bArr2[4] << 24)) + (16711680 & (bArr2[5] << 16)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255), false, this.f5525a, this.f5526b.f5536b, this.f5526b.f5535a, this.f5530f);
        int[] iArr = this.f5530f;
        int i2 = iArr[0];
        int i3 = iArr[1];
        byte[] bArr3 = this.f5527c;
        bArr3[0] = (byte) (i2 >> 24);
        bArr3[1] = (byte) (i2 >> 16);
        bArr3[2] = (byte) (i2 >> 8);
        bArr3[3] = (byte) i2;
        bArr3[4] = (byte) (i3 >> 24);
        bArr3[5] = (byte) (i3 >> 16);
        bArr3[6] = (byte) (i3 >> 8);
        bArr3[7] = (byte) i3;
        if (this.j == 2) {
            for (int i4 = 0; i4 < 8; i4++) {
                byte[] bArr4 = this.f5527c;
                bArr4[i4] = (byte) (bArr4[i4] ^ this.f5528d[i4]);
            }
            byte[] bArr5 = this.f5529e;
            System.arraycopy(bArr5, 0, this.f5528d, 0, bArr5.length);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int b() throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r7.f5533i
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != r1) goto L_0x000f
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.f5533i = r0
        L_0x000f:
            int r0 = r7.f5531g
            r1 = 8
            if (r0 != r1) goto L_0x005c
            byte[] r0 = r7.f5527c
            int r2 = r7.f5533i
            byte r3 = (byte) r2
            r4 = 0
            r0[r4] = r3
            java.lang.String r0 = "unexpected block size"
            if (r2 < 0) goto L_0x0056
            r2 = 1
        L_0x0023:
            java.io.InputStream r3 = r7.in
            byte[] r5 = r7.f5527c
            int r6 = 8 - r2
            int r3 = r3.read(r5, r2, r6)
            if (r3 <= 0) goto L_0x0032
            int r2 = r2 + r3
            if (r2 < r1) goto L_0x0023
        L_0x0032:
            if (r2 < r1) goto L_0x0050
            r7.a()
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.f5533i = r0
            r7.f5531g = r4
            int r0 = r7.f5533i
            if (r0 >= 0) goto L_0x004d
            byte[] r0 = r7.f5527c
            r2 = 7
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r1 - r0
        L_0x004d:
            r7.f5532h = r1
            goto L_0x005c
        L_0x0050:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0056:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x005c:
            int r0 = r7.f5532h
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.e.c.b():int");
    }
}
