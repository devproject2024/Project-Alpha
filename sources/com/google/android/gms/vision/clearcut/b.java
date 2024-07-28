package com.google.android.gms.vision.clearcut;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final long f12622a = Math.round(30000.0d);

    /* renamed from: b  reason: collision with root package name */
    private final Object f12623b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private long f12624c = Long.MIN_VALUE;

    public final boolean a() {
        synchronized (this.f12623b) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f12624c + this.f12622a > currentTimeMillis) {
                return false;
            }
            this.f12624c = currentTimeMillis;
            return true;
        }
    }
}
