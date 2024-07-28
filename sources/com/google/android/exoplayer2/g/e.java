package com.google.android.exoplayer2.g;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f32516a;

    public final synchronized boolean a() {
        if (this.f32516a) {
            return false;
        }
        this.f32516a = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean b() {
        boolean z;
        z = this.f32516a;
        this.f32516a = false;
        return z;
    }

    public final synchronized void c() throws InterruptedException {
        while (!this.f32516a) {
            wait();
        }
    }
}
