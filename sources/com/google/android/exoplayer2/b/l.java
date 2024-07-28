package com.google.android.exoplayer2.b;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final int f31210a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final float f31211b = 0.0f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            l lVar = (l) obj;
            return this.f31210a == lVar.f31210a && Float.compare(lVar.f31211b, this.f31211b) == 0;
        }
    }

    public final int hashCode() {
        return ((this.f31210a + 527) * 31) + Float.floatToIntBits(this.f31211b);
    }
}
