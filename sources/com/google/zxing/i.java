package com.google.zxing;

public final class i extends j {

    /* renamed from: c  reason: collision with root package name */
    private final j f40561c;

    public final byte[] a(int i2, byte[] bArr) {
        byte[] a2 = this.f40561c.a(i2, bArr);
        int i3 = this.f40562a;
        for (int i4 = 0; i4 < i3; i4++) {
            a2[i4] = (byte) (255 - (a2[i4] & 255));
        }
        return a2;
    }

    public final byte[] a() {
        byte[] a2 = this.f40561c.a();
        int i2 = this.f40562a * this.f40563b;
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) (255 - (a2[i3] & 255));
        }
        return bArr;
    }

    public final boolean b() {
        return this.f40561c.b();
    }

    public final j c() {
        return this.f40561c;
    }

    public final j d() {
        return new i(this.f40561c.d());
    }

    public i(j jVar) {
        super(jVar.f40562a, jVar.f40563b);
        this.f40561c = jVar;
    }
}
