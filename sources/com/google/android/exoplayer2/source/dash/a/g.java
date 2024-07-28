package com.google.android.exoplayer2.source.dash.a;

import com.google.android.exoplayer2.g.ae;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f32937a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32938b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32939c;

    /* renamed from: d  reason: collision with root package name */
    public final String f32940d;

    /* renamed from: e  reason: collision with root package name */
    public final String f32941e;

    public g(String str, String str2, String str3, String str4, String str5) {
        this.f32937a = str;
        this.f32938b = str2;
        this.f32939c = str3;
        this.f32940d = str4;
        this.f32941e = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            g gVar = (g) obj;
            return ae.a((Object) this.f32937a, (Object) gVar.f32937a) && ae.a((Object) this.f32938b, (Object) gVar.f32938b) && ae.a((Object) this.f32939c, (Object) gVar.f32939c) && ae.a((Object) this.f32940d, (Object) gVar.f32940d) && ae.a((Object) this.f32941e, (Object) gVar.f32941e);
        }
    }

    public final int hashCode() {
        String str = this.f32937a;
        int i2 = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f32938b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f32939c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f32940d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f32941e;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }
}
