package com.google.android.gms.maps.model;

public final class Gap extends PatternItem {

    /* renamed from: a  reason: collision with root package name */
    public final float f11583a;

    public final String toString() {
        float f2 = this.f11583a;
        StringBuilder sb = new StringBuilder(29);
        sb.append("[Gap: length=");
        sb.append(f2);
        sb.append("]");
        return sb.toString();
    }
}
