package com.alipay.mobile.rome.syncsdk.d.d.a;

import javax.net.SocketFactory;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f15059a;

    /* renamed from: b  reason: collision with root package name */
    public int f15060b;

    /* renamed from: c  reason: collision with root package name */
    public int f15061c = 15;

    /* renamed from: d  reason: collision with root package name */
    public b f15062d;

    public a(b bVar, String str, int i2) {
        this.f15062d = bVar;
        this.f15059a = str;
        this.f15060b = i2;
    }

    public final SocketFactory a() {
        if (this.f15062d == b.NONE) {
            new c().a(this.f15061c);
            return new c();
        } else if (this.f15062d == b.HTTP) {
            d dVar = new d(this);
            int i2 = this.f15061c;
            if (i2 > 0) {
                dVar.f15065a = i2;
            }
            return dVar;
        } else if (this.f15062d != b.SOCKS) {
            return null;
        } else {
            new c().a(this.f15061c);
            return new c();
        }
    }

    public final String toString() {
        return "ProxyInfo [proxyAddress=" + this.f15059a + ", proxyPort=" + this.f15060b + ", proxyType=" + this.f15062d + ", connTimeout=" + this.f15061c + "]";
    }
}
