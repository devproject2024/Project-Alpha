package com.google.zxing;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public final int f40562a;

    /* renamed from: b  reason: collision with root package name */
    public final int f40563b;

    public abstract byte[] a();

    public abstract byte[] a(int i2, byte[] bArr);

    public boolean b() {
        return false;
    }

    protected j(int i2, int i3) {
        this.f40562a = i2;
        this.f40563b = i3;
    }

    public j c() {
        return new i(this);
    }

    public j d() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i2 = this.f40562a;
        StringBuilder sb = new StringBuilder(this.f40563b * (i2 + 1));
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < this.f40563b; i3++) {
            bArr = a(i3, bArr);
            for (int i4 = 0; i4 < this.f40562a; i4++) {
                byte b2 = bArr[i4] & 255;
                sb.append(b2 < 64 ? '#' : b2 < 128 ? '+' : b2 < 192 ? '.' : ' ');
            }
            sb.append(10);
        }
        return sb.toString();
    }
}
