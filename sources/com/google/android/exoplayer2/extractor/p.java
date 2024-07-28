package com.google.android.exoplayer2.extractor;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final p f32293a = new p(0, 0);

    /* renamed from: b  reason: collision with root package name */
    public final long f32294b;

    /* renamed from: c  reason: collision with root package name */
    public final long f32295c;

    public p(long j, long j2) {
        this.f32294b = j;
        this.f32295c = j2;
    }

    public final String toString() {
        return "[timeUs=" + this.f32294b + ", position=" + this.f32295c + "]";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            p pVar = (p) obj;
            return this.f32294b == pVar.f32294b && this.f32295c == pVar.f32295c;
        }
    }

    public final int hashCode() {
        return (((int) this.f32294b) * 31) + ((int) this.f32295c);
    }
}
