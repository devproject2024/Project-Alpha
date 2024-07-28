package net.one97.paytm.o2o.movies.adapter;

import kotlin.g.b.k;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    final String f74676a;

    /* renamed from: b  reason: collision with root package name */
    final String f74677b;

    /* renamed from: c  reason: collision with root package name */
    final String f74678c;

    /* renamed from: d  reason: collision with root package name */
    final String f74679d;

    /* renamed from: e  reason: collision with root package name */
    final String f74680e;

    /* renamed from: f  reason: collision with root package name */
    final String f74681f;

    /* renamed from: g  reason: collision with root package name */
    final String f74682g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f74683h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f74684i;
    final String j;
    final String k;
    private final String l;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return k.a((Object) this.f74676a, (Object) mVar.f74676a) && k.a((Object) this.f74677b, (Object) mVar.f74677b) && k.a((Object) this.f74678c, (Object) mVar.f74678c) && k.a((Object) this.f74679d, (Object) mVar.f74679d) && k.a((Object) this.f74680e, (Object) mVar.f74680e) && k.a((Object) this.f74681f, (Object) mVar.f74681f) && k.a((Object) this.f74682g, (Object) mVar.f74682g) && this.f74683h == mVar.f74683h && this.f74684i == mVar.f74684i && k.a((Object) this.l, (Object) mVar.l) && k.a((Object) this.j, (Object) mVar.j) && k.a((Object) this.k, (Object) mVar.k);
    }

    public final int hashCode() {
        String str = this.f74676a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f74677b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f74678c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f74679d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f74680e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f74681f;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f74682g;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        boolean z = this.f74683h;
        if (z) {
            z = true;
        }
        int i3 = (hashCode7 + (z ? 1 : 0)) * 31;
        boolean z2 = this.f74684i;
        if (z2) {
            z2 = true;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        String str8 = this.l;
        int hashCode8 = (i4 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.j;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.k;
        if (str10 != null) {
            i2 = str10.hashCode();
        }
        return hashCode9 + i2;
    }

    public final String toString() {
        return "CJRMovieDetailModel(mCity=" + this.f74676a + ", mSpecificCity=" + this.f74677b + ", mSelectedCategory=" + this.f74678c + ", mSelectedCode=" + this.f74679d + ", mUrlType=" + this.f74680e + ", mDeeplinkSessionId=" + this.f74681f + ", mDeepLinkBookingDate=" + this.f74682g + ", mMoviePassCodeForUser=" + this.f74683h + ", mIsMoveExist=" + this.f74684i + ", mCinemaMovieCode=" + this.l + ", mMovieCinemaName=" + this.j + ", mfrmtId=" + this.k + ")";
    }

    public m(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, boolean z2, String str8, String str9, String str10) {
        k.c(str, "mCity");
        this.f74676a = str;
        this.f74677b = str2;
        this.f74678c = str3;
        this.f74679d = str4;
        this.f74680e = str5;
        this.f74681f = str6;
        this.f74682g = str7;
        this.f74683h = z;
        this.f74684i = z2;
        this.l = str8;
        this.j = str9;
        this.k = str10;
    }
}
