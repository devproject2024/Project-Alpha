package com.travel.train.model;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public int f27694a;

    /* renamed from: b  reason: collision with root package name */
    private int f27695b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f27695b == dVar.f27695b && this.f27694a == dVar.f27694a;
    }

    public final int hashCode() {
        return (this.f27695b * 31) + this.f27694a;
    }

    public final String toString() {
        return "CJRScreenDisplayMetricsModel(height=" + this.f27695b + ", width=" + this.f27694a + ")";
    }

    public d(int i2, int i3) {
        this.f27695b = i2;
        this.f27694a = i3;
    }
}
