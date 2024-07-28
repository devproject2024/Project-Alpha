package com.bumptech.glide.gifdecoder;

import android.util.Log;
import com.alipay.mobile.nebula.util.tar.TarHeader;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import net.one97.paytm.upi.util.UpiConstants;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f6645a = new byte[UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS];

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f6646b;

    /* renamed from: c  reason: collision with root package name */
    public c f6647c;

    /* renamed from: d  reason: collision with root package name */
    public int f6648d = 0;

    public final void a() {
        boolean z = false;
        while (!z && !c() && this.f6647c.f6638c <= Integer.MAX_VALUE) {
            int g2 = g();
            if (g2 == 33) {
                int g3 = g();
                if (g3 == 1) {
                    e();
                } else if (g3 == 249) {
                    this.f6647c.f6639d = new b();
                    g();
                    int g4 = g();
                    this.f6647c.f6639d.f6633g = (g4 & 28) >> 2;
                    if (this.f6647c.f6639d.f6633g == 0) {
                        this.f6647c.f6639d.f6633g = 1;
                    }
                    this.f6647c.f6639d.f6632f = (g4 & 1) != 0;
                    short s = this.f6646b.getShort();
                    if (s < 2) {
                        s = 10;
                    }
                    this.f6647c.f6639d.f6635i = s * 10;
                    this.f6647c.f6639d.f6634h = g();
                    g();
                } else if (g3 == 254) {
                    e();
                } else if (g3 != 255) {
                    e();
                } else {
                    f();
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < 11; i2++) {
                        sb.append((char) this.f6645a[i2]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        d();
                    } else {
                        e();
                    }
                }
            } else if (g2 == 44) {
                if (this.f6647c.f6639d == null) {
                    this.f6647c.f6639d = new b();
                }
                this.f6647c.f6639d.f6627a = this.f6646b.getShort();
                this.f6647c.f6639d.f6628b = this.f6646b.getShort();
                this.f6647c.f6639d.f6629c = this.f6646b.getShort();
                this.f6647c.f6639d.f6630d = this.f6646b.getShort();
                int g5 = g();
                boolean z2 = (g5 & 128) != 0;
                int pow = (int) Math.pow(2.0d, (double) ((g5 & 7) + 1));
                this.f6647c.f6639d.f6631e = (g5 & 64) != 0;
                if (z2) {
                    this.f6647c.f6639d.k = a(pow);
                } else {
                    this.f6647c.f6639d.k = null;
                }
                this.f6647c.f6639d.j = this.f6646b.position();
                g();
                e();
                if (!c()) {
                    this.f6647c.f6638c++;
                    this.f6647c.f6640e.add(this.f6647c.f6639d);
                }
            } else if (g2 != 59) {
                this.f6647c.f6637b = 1;
            } else {
                z = true;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r3 = this;
        L_0x0000:
            r3.f()
            byte[] r0 = r3.f6645a
            r1 = 0
            byte r1 = r0[r1]
            r2 = 1
            if (r1 != r2) goto L_0x001b
            byte r1 = r0[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 2
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            com.bumptech.glide.gifdecoder.c r2 = r3.f6647c
            int r0 = r0 << 8
            r0 = r0 | r1
            r2.m = r0
        L_0x001b:
            int r0 = r3.f6648d
            if (r0 <= 0) goto L_0x0025
            boolean r0 = r3.c()
            if (r0 == 0) goto L_0x0000
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.d.d():void");
    }

    public final void b() {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) g());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f6647c.f6637b = 1;
            return;
        }
        this.f6647c.f6641f = this.f6646b.getShort();
        this.f6647c.f6642g = this.f6646b.getShort();
        int g2 = g();
        c cVar = this.f6647c;
        if ((g2 & 128) != 0) {
            z = true;
        }
        cVar.f6643h = z;
        this.f6647c.f6644i = (int) Math.pow(2.0d, (double) ((g2 & 7) + 1));
        this.f6647c.j = g();
        this.f6647c.k = g();
        if (this.f6647c.f6643h && !c()) {
            c cVar2 = this.f6647c;
            cVar2.f6636a = a(cVar2.f6644i);
            c cVar3 = this.f6647c;
            cVar3.l = cVar3.f6636a[this.f6647c.j];
        }
    }

    private int[] a(int i2) {
        int[] iArr;
        byte[] bArr = new byte[(i2 * 3)];
        try {
            this.f6646b.get(bArr);
            iArr = new int[UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                try {
                    int i6 = i5 + 1;
                    int i7 = i6 + 1;
                    int i8 = i3 + 1;
                    iArr[i3] = ((bArr[i4] & 255) << 16) | TarHeader.LF_OLDNORM | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                    i4 = i7;
                    i3 = i8;
                } catch (BufferUnderflowException unused) {
                    Log.isLoggable("GifHeaderParser", 3);
                    this.f6647c.f6637b = 1;
                    return iArr;
                }
            }
        } catch (BufferUnderflowException unused2) {
            iArr = null;
            Log.isLoggable("GifHeaderParser", 3);
            this.f6647c.f6637b = 1;
            return iArr;
        }
        return iArr;
    }

    private void e() {
        int g2;
        do {
            g2 = g();
            this.f6646b.position(Math.min(this.f6646b.position() + g2, this.f6646b.limit()));
        } while (g2 > 0);
    }

    private void f() {
        this.f6648d = g();
        if (this.f6648d > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.f6648d) {
                try {
                    i3 = this.f6648d - i2;
                    this.f6646b.get(this.f6645a, i2, i3);
                    i2 += i3;
                } catch (Exception unused) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        StringBuilder sb = new StringBuilder("Error Reading Block n: ");
                        sb.append(i2);
                        sb.append(" count: ");
                        sb.append(i3);
                        sb.append(" blockSize: ");
                        sb.append(this.f6648d);
                    }
                    this.f6647c.f6637b = 1;
                    return;
                }
            }
        }
    }

    private int g() {
        try {
            return this.f6646b.get() & 255;
        } catch (Exception unused) {
            this.f6647c.f6637b = 1;
            return 0;
        }
    }

    public final boolean c() {
        return this.f6647c.f6637b != 0;
    }
}
