package com.alipay.imobile.network.quake.h.b;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import net.one97.paytm.upi.util.UpiConstants;

public final class b extends ByteArrayOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final a f14886a;

    public b(a aVar, int i2) {
        this.f14886a = aVar;
        this.buf = this.f14886a.a(Math.max(i2, UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS));
    }

    private void a(int i2) {
        if (this.count + i2 > this.buf.length) {
            byte[] a2 = this.f14886a.a((this.count + i2) * 2);
            System.arraycopy(this.buf, 0, a2, 0, this.count);
            this.f14886a.a(this.buf);
            this.buf = a2;
        }
    }

    public final void close() throws IOException {
        this.f14886a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.f14886a.a(this.buf);
    }

    public final synchronized void write(int i2) {
        a(1);
        super.write(i2);
    }

    public final synchronized void write(byte[] bArr, int i2, int i3) {
        a(i3);
        super.write(bArr, i2, i3);
    }
}
