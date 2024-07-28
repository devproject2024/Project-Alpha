package net.one97.paytm.hotels2.c.a;

public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final a f29975a;

    /* renamed from: b  reason: collision with root package name */
    final int f29976b;

    public interface a {
        void b(int i2);
    }

    public d(a aVar, int i2) {
        this.f29975a = aVar;
        this.f29976b = i2;
    }

    public final void run() {
        this.f29975a.b(this.f29976b);
    }
}
