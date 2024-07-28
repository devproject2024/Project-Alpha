package com.appsflyer.internal;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class al extends FilterInputStream {

    /* renamed from: Ι  reason: contains not printable characters */
    private static final short f196 = ((short) ((int) ((Math.sqrt(5.0d) - 1.0d) * Math.pow(2.0d, 15.0d))));

    /* renamed from: ı  reason: contains not printable characters */
    private byte[] f197 = new byte[8];

    /* renamed from: Ɩ  reason: contains not printable characters */
    private int f198;

    /* renamed from: ǃ  reason: contains not printable characters */
    private int f199 = 8;

    /* renamed from: ȷ  reason: contains not printable characters */
    private int f200;

    /* renamed from: ɩ  reason: contains not printable characters */
    private byte[] f201 = new byte[8];

    /* renamed from: ɹ  reason: contains not printable characters */
    private int f202;

    /* renamed from: ɾ  reason: contains not printable characters */
    private int f203;

    /* renamed from: ι  reason: contains not printable characters */
    private byte[] f204 = new byte[8];

    /* renamed from: І  reason: contains not printable characters */
    private int f205;

    /* renamed from: і  reason: contains not printable characters */
    private int f206 = 8;

    /* renamed from: Ӏ  reason: contains not printable characters */
    private int f207 = Integer.MAX_VALUE;

    /* renamed from: ӏ  reason: contains not printable characters */
    private int f208;

    public boolean markSupported() {
        return false;
    }

    public al(InputStream inputStream, int[] iArr, int i2, byte[] bArr, int i3, int i4) throws IOException {
        super(inputStream);
        this.f205 = Math.min(Math.max(i3, 5), 16);
        this.f202 = i4;
        if (i4 == 3) {
            System.arraycopy(bArr, 0, this.f204, 0, 8);
        }
        long j = ((((long) iArr[0]) & 4294967295L) << 32) | (4294967295L & ((long) iArr[1]));
        if (i2 == 0) {
            this.f198 = (int) j;
            long j2 = j >> 3;
            short s = f196;
            this.f203 = (int) ((((long) s) * j2) >> 32);
            this.f200 = (int) (j >> 32);
            this.f208 = (int) (j2 + ((long) s));
            return;
        }
        int i5 = (int) j;
        this.f198 = i5;
        this.f203 = i5 * i2;
        this.f200 = i5 ^ i2;
        this.f208 = (int) (j >> 32);
    }

    public int read() throws IOException {
        m156();
        int i2 = this.f199;
        if (i2 >= this.f206) {
            return -1;
        }
        byte[] bArr = this.f197;
        this.f199 = i2 + 1;
        return bArr[i2] & 255;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = i2 + i3;
        int i5 = i2;
        while (i5 < i4) {
            m156();
            int i6 = this.f199;
            if (i6 < this.f206) {
                byte[] bArr2 = this.f197;
                this.f199 = i6 + 1;
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
        m156();
        return this.f206 - this.f199;
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    private void m155() {
        if (this.f202 == 3) {
            byte[] bArr = this.f197;
            System.arraycopy(bArr, 0, this.f201, 0, bArr.length);
        }
        byte[] bArr2 = this.f197;
        int i2 = ((bArr2[0] << 24) & -16777216) + ((bArr2[1] << 16) & 16711680) + ((bArr2[2] << 8) & PriceRangeSeekBar.ACTION_POINTER_INDEX_MASK) + (bArr2[3] & 255);
        int i3 = (-16777216 & (bArr2[4] << 24)) + (16711680 & (bArr2[5] << 16)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        int i4 = 0;
        while (true) {
            int i5 = this.f205;
            if (i4 >= i5) {
                break;
            }
            short s = f196;
            i3 -= ((((i5 - i4) * s) + i2) ^ ((i2 << 4) + this.f200)) ^ ((i2 >>> 5) + this.f208);
            i2 -= (((i3 << 4) + this.f198) ^ ((s * (i5 - i4)) + i3)) ^ ((i3 >>> 5) + this.f203);
            i4++;
        }
        byte[] bArr3 = this.f197;
        bArr3[0] = (byte) (i2 >> 24);
        bArr3[1] = (byte) (i2 >> 16);
        bArr3[2] = (byte) (i2 >> 8);
        bArr3[3] = (byte) i2;
        bArr3[4] = (byte) (i3 >> 24);
        bArr3[5] = (byte) (i3 >> 16);
        bArr3[6] = (byte) (i3 >> 8);
        bArr3[7] = (byte) i3;
        if (this.f202 == 3) {
            for (int i6 = 0; i6 < 8; i6++) {
                byte[] bArr4 = this.f197;
                bArr4[i6] = (byte) (bArr4[i6] ^ this.f204[i6]);
            }
            byte[] bArr5 = this.f201;
            System.arraycopy(bArr5, 0, this.f204, 0, bArr5.length);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* renamed from: ι  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m156() throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r7.f207
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != r1) goto L_0x000f
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.f207 = r0
        L_0x000f:
            int r0 = r7.f199
            r1 = 8
            if (r0 != r1) goto L_0x005c
            byte[] r0 = r7.f197
            int r2 = r7.f207
            byte r3 = (byte) r2
            r4 = 0
            r0[r4] = r3
            java.lang.String r0 = "unexpected block size"
            if (r2 < 0) goto L_0x0056
            r2 = 1
        L_0x0023:
            java.io.InputStream r3 = r7.in
            byte[] r5 = r7.f197
            int r6 = 8 - r2
            int r3 = r3.read(r5, r2, r6)
            if (r3 <= 0) goto L_0x0032
            int r2 = r2 + r3
            if (r2 < r1) goto L_0x0023
        L_0x0032:
            if (r2 < r1) goto L_0x0050
            r7.m155()
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.f207 = r0
            r7.f199 = r4
            int r0 = r7.f207
            if (r0 >= 0) goto L_0x004d
            byte[] r0 = r7.f197
            r2 = 7
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r1 - r0
        L_0x004d:
            r7.f206 = r1
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
            int r0 = r7.f206
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.al.m156():int");
    }
}
