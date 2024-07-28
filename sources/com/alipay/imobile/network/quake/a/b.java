package com.alipay.imobile.network.quake.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private char[] f14716a;

    /* renamed from: b  reason: collision with root package name */
    private int f14717b;

    public b(int i2) {
        if (i2 >= 0) {
            this.f14716a = new char[i2];
            return;
        }
        throw new IllegalArgumentException("Buffer capacity may not be negative");
    }

    private void a(int i2) {
        char[] cArr = new char[Math.max(this.f14716a.length << 1, i2)];
        System.arraycopy(this.f14716a, 0, cArr, 0, this.f14717b);
        this.f14716a = cArr;
    }

    public final void a(String str) {
        if (str == null) {
            str = "null";
        }
        int length = str.length();
        int i2 = this.f14717b + length;
        if (i2 > this.f14716a.length) {
            a(i2);
        }
        str.getChars(0, length, this.f14716a, this.f14717b);
        this.f14717b = i2;
    }

    public final String toString() {
        return new String(this.f14716a, 0, this.f14717b);
    }
}
