package com.google.android.exoplayer2.source.dash.a;

import android.net.Uri;
import com.google.android.exoplayer2.g.ad;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final long f32942a;

    /* renamed from: b  reason: collision with root package name */
    public final long f32943b;

    /* renamed from: c  reason: collision with root package name */
    private final String f32944c;

    /* renamed from: d  reason: collision with root package name */
    private int f32945d;

    public h(String str, long j, long j2) {
        this.f32944c = str == null ? "" : str;
        this.f32942a = j;
        this.f32943b = j2;
    }

    public final Uri a(String str) {
        return ad.a(str, this.f32944c);
    }

    private String b(String str) {
        return ad.b(str, this.f32944c);
    }

    public final h a(h hVar, String str) {
        String b2 = b(str);
        if (hVar != null && b2.equals(hVar.b(str))) {
            long j = this.f32943b;
            long j2 = -1;
            if (j != -1) {
                long j3 = this.f32942a;
                if (j3 + j == hVar.f32942a) {
                    long j4 = hVar.f32943b;
                    if (j4 != -1) {
                        j2 = j + j4;
                    }
                    return new h(b2, j3, j2);
                }
            }
            long j5 = hVar.f32943b;
            if (j5 != -1) {
                long j6 = hVar.f32942a;
                if (j6 + j5 == this.f32942a) {
                    long j7 = this.f32943b;
                    if (j7 != -1) {
                        j2 = j5 + j7;
                    }
                    return new h(b2, j6, j2);
                }
            }
        }
        return null;
    }

    public final int hashCode() {
        if (this.f32945d == 0) {
            this.f32945d = ((((((int) this.f32942a) + 527) * 31) + ((int) this.f32943b)) * 31) + this.f32944c.hashCode();
        }
        return this.f32945d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            h hVar = (h) obj;
            return this.f32942a == hVar.f32942a && this.f32943b == hVar.f32943b && this.f32944c.equals(hVar.f32944c);
        }
    }

    public final String toString() {
        return "RangedUri(referenceUri=" + this.f32944c + ", start=" + this.f32942a + ", length=" + this.f32943b + ")";
    }
}
