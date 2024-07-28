package com.alipay.mobile.rome.syncsdk.d.b;

import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.e.p;
import java.util.Arrays;

public class d extends a {

    /* renamed from: h  reason: collision with root package name */
    private static final String f15031h = d.class.getSimpleName();

    public d() {
        this.f15020a = (byte) b.f15028b;
        this.f15025f = new byte[7];
    }

    public final void c(byte[] bArr) {
        h.b(f15031h, "initPacketFromHeadBytes: ");
        this.f15020a = bArr[0];
        this.f15021b = bArr[1];
        this.f15022c = bArr[2];
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 3, 7);
        this.f15023d = ((((((copyOfRange[0] & 255) << 8) | (copyOfRange[1] & 255)) << 8) | (copyOfRange[2] & 255)) << 8) | (copyOfRange[3] & 255);
        this.f15024e = bArr[7];
        this.f15025f = Arrays.copyOfRange(bArr, 8, 15);
    }

    public final byte[] g() {
        byte[] bArr;
        int i2;
        byte[] bArr2 = this.f15026g;
        int length = this.f15026g != null ? this.f15026g.length : 0;
        if (this.f15026g == null || this.f15026g.length <= 512) {
            bArr = bArr2;
            i2 = 0;
        } else {
            byte[] a2 = p.a(this.f15026g);
            length = a2.length;
            bArr = a2;
            i2 = 1;
        }
        byte[] bArr3 = new byte[(b.f15029c + length)];
        bArr3[0] = this.f15020a;
        bArr3[1] = this.f15021b;
        bArr3[2] = this.f15022c;
        System.arraycopy(new byte[]{(byte) (length >>> 24), (byte) (length >>> 16), (byte) (length >>> 8), (byte) length}, 0, bArr3, 3, 4);
        bArr3[7] = (byte) i2;
        System.arraycopy(this.f15025f, 0, bArr3, 8, 7);
        if (bArr != null) {
            System.arraycopy(bArr, 0, bArr3, 15, length);
        }
        return bArr3;
    }
}
