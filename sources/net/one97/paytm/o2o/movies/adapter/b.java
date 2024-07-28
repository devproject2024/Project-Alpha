package net.one97.paytm.o2o.movies.adapter;

import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    final String f74523a;

    /* renamed from: b  reason: collision with root package name */
    final String f74524b;

    /* renamed from: c  reason: collision with root package name */
    final String f74525c;

    /* renamed from: d  reason: collision with root package name */
    final String f74526d;

    /* renamed from: e  reason: collision with root package name */
    final String f74527e;

    /* renamed from: f  reason: collision with root package name */
    final String f74528f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f74529g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f74530h;

    /* renamed from: i  reason: collision with root package name */
    final String f74531i;
    private final String j;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return k.a((Object) this.f74523a, (Object) bVar.f74523a) && k.a((Object) this.f74524b, (Object) bVar.f74524b) && k.a((Object) this.f74525c, (Object) bVar.f74525c) && k.a((Object) this.f74526d, (Object) bVar.f74526d) && k.a((Object) this.f74527e, (Object) bVar.f74527e) && k.a((Object) this.f74528f, (Object) bVar.f74528f) && this.f74529g == bVar.f74529g && this.f74530h == bVar.f74530h && k.a((Object) this.j, (Object) bVar.j) && k.a((Object) this.f74531i, (Object) bVar.f74531i);
    }

    public final int hashCode() {
        String str = this.f74523a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f74524b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f74525c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f74526d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f74527e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f74528f;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z = this.f74529g;
        if (z) {
            z = true;
        }
        int i3 = (hashCode6 + (z ? 1 : 0)) * 31;
        boolean z2 = this.f74530h;
        if (z2) {
            z2 = true;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        String str7 = this.j;
        int hashCode7 = (i4 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.f74531i;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        return hashCode7 + i2;
    }

    public final String toString() {
        return "CJRCinemaDetailModel(mCity=" + this.f74523a + ", mSelectedCategory=" + this.f74524b + ", mSelectedCode=" + this.f74525c + ", mUrlType=" + this.f74526d + ", mDeeplinkSessionId=" + this.f74527e + ", mDeepLinkBookingDate=" + this.f74528f + ", mMoviePassCodeForUser=" + this.f74529g + ", mIsMoveExist=" + this.f74530h + ", mCinemaMovieCode=" + this.j + ", mMovieCinemaName=" + this.f74531i + ")";
    }

    public b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, String str7, String str8) {
        k.c(str, "mCity");
        k.c(str2, "mSelectedCategory");
        k.c(str3, "mSelectedCode");
        this.f74523a = str;
        this.f74524b = str2;
        this.f74525c = str3;
        this.f74526d = str4;
        this.f74527e = str5;
        this.f74528f = str6;
        this.f74529g = z;
        this.f74530h = z2;
        this.j = str7;
        this.f74531i = str8;
    }
}
