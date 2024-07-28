package com.appsflyer.internal;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class an extends FilterInputStream {

    /* renamed from: ı  reason: contains not printable characters */
    private byte[] f210;

    /* renamed from: Ɩ  reason: contains not printable characters */
    private int f211;

    /* renamed from: ǃ  reason: contains not printable characters */
    private byte[] f212;

    /* renamed from: ɩ  reason: contains not printable characters */
    private ak f213;

    /* renamed from: ɹ  reason: contains not printable characters */
    private int[] f214;

    /* renamed from: Ι  reason: contains not printable characters */
    private byte[] f215;

    /* renamed from: ι  reason: contains not printable characters */
    private final int f216;

    /* renamed from: І  reason: contains not printable characters */
    private int f217;

    /* renamed from: і  reason: contains not printable characters */
    private int f218 = Integer.MAX_VALUE;

    /* renamed from: Ӏ  reason: contains not printable characters */
    private int f219;

    public boolean markSupported() {
        return false;
    }

    public an(InputStream inputStream, int[] iArr, byte[] bArr, int i2, boolean z, int i3) throws IOException {
        super(inputStream);
        this.f216 = Math.min(Math.max(i2, 3), 16);
        this.f212 = new byte[8];
        this.f215 = new byte[8];
        this.f210 = new byte[8];
        this.f214 = new int[2];
        this.f211 = 8;
        this.f219 = 8;
        this.f217 = i3;
        if (i3 == 2) {
            System.arraycopy(bArr, 0, this.f215, 0, 8);
        }
        this.f213 = new ak(iArr, this.f216, true, z);
    }

    public int read() throws IOException {
        m157();
        int i2 = this.f211;
        if (i2 >= this.f219) {
            return -1;
        }
        byte[] bArr = this.f212;
        this.f211 = i2 + 1;
        return bArr[i2] & 255;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = i2 + i3;
        int i5 = i2;
        while (i5 < i4) {
            m157();
            int i6 = this.f211;
            if (i6 < this.f219) {
                byte[] bArr2 = this.f212;
                this.f211 = i6 + 1;
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
        m157();
        return this.f219 - this.f211;
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private void m158() {
        if (this.f217 == 2) {
            byte[] bArr = this.f212;
            System.arraycopy(bArr, 0, this.f210, 0, bArr.length);
        }
        byte[] bArr2 = this.f212;
        aj.m152(((bArr2[0] << 24) & -16777216) + ((bArr2[1] << 16) & 16711680) + ((bArr2[2] << 8) & PriceRangeSeekBar.ACTION_POINTER_INDEX_MASK) + (bArr2[3] & 255), (-16777216 & (bArr2[4] << 24)) + (16711680 & (bArr2[5] << 16)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255), false, this.f216, this.f213.f194, this.f213.f195, this.f214);
        int[] iArr = this.f214;
        int i2 = iArr[0];
        int i3 = iArr[1];
        byte[] bArr3 = this.f212;
        bArr3[0] = (byte) (i2 >> 24);
        bArr3[1] = (byte) (i2 >> 16);
        bArr3[2] = (byte) (i2 >> 8);
        bArr3[3] = (byte) i2;
        bArr3[4] = (byte) (i3 >> 24);
        bArr3[5] = (byte) (i3 >> 16);
        bArr3[6] = (byte) (i3 >> 8);
        bArr3[7] = (byte) i3;
        if (this.f217 == 2) {
            for (int i4 = 0; i4 < 8; i4++) {
                byte[] bArr4 = this.f212;
                bArr4[i4] = (byte) (bArr4[i4] ^ this.f215[i4]);
            }
            byte[] bArr5 = this.f210;
            System.arraycopy(bArr5, 0, this.f215, 0, bArr5.length);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* renamed from: ǃ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m157() throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r7.f218
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != r1) goto L_0x000f
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.f218 = r0
        L_0x000f:
            int r0 = r7.f211
            r1 = 8
            if (r0 != r1) goto L_0x005c
            byte[] r0 = r7.f212
            int r2 = r7.f218
            byte r3 = (byte) r2
            r4 = 0
            r0[r4] = r3
            java.lang.String r0 = "unexpected block size"
            if (r2 < 0) goto L_0x0056
            r2 = 1
        L_0x0023:
            java.io.InputStream r3 = r7.in
            byte[] r5 = r7.f212
            int r6 = 8 - r2
            int r3 = r3.read(r5, r2, r6)
            if (r3 <= 0) goto L_0x0032
            int r2 = r2 + r3
            if (r2 < r1) goto L_0x0023
        L_0x0032:
            if (r2 < r1) goto L_0x0050
            r7.m158()
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.f218 = r0
            r7.f211 = r4
            int r0 = r7.f218
            if (r0 >= 0) goto L_0x004d
            byte[] r0 = r7.f212
            r2 = 7
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r1 - r0
        L_0x004d:
            r7.f219 = r1
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
            int r0 = r7.f219
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.an.m157():int");
    }
}
