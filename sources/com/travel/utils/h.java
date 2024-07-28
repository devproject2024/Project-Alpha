package com.travel.utils;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private Long f28526a;

    /* renamed from: b  reason: collision with root package name */
    private final long f28527b;

    public h(long j) {
        this.f28527b = j;
    }

    public final boolean a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null) {
            return false;
        }
        Long l = this.f28526a;
        this.f28526a = Long.valueOf(currentTimeMillis);
        return l != null && currentTimeMillis - l.longValue() < this.f28527b;
    }
}
