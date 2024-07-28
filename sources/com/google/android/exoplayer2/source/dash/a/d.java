package com.google.android.exoplayer2.source.dash.a;

import com.google.android.exoplayer2.g.ae;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f32925a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32926b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32927c;

    public d(String str, String str2, String str3) {
        this.f32925a = str;
        this.f32926b = str2;
        this.f32927c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            d dVar = (d) obj;
            return ae.a((Object) this.f32925a, (Object) dVar.f32925a) && ae.a((Object) this.f32926b, (Object) dVar.f32926b) && ae.a((Object) this.f32927c, (Object) dVar.f32927c);
        }
    }

    public final int hashCode() {
        String str = this.f32925a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f32926b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f32927c;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }
}
