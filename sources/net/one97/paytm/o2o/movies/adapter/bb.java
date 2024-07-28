package net.one97.paytm.o2o.movies.adapter;

import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;

public final class bb {

    /* renamed from: a  reason: collision with root package name */
    final String f74537a;

    /* renamed from: b  reason: collision with root package name */
    final String f74538b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f74539c;

    /* renamed from: d  reason: collision with root package name */
    final int f74540d;

    /* renamed from: e  reason: collision with root package name */
    final String f74541e;

    /* renamed from: f  reason: collision with root package name */
    final CJRMoviesSession f74542f;

    /* renamed from: g  reason: collision with root package name */
    private final int f74543g;

    /* renamed from: h  reason: collision with root package name */
    private final int f74544h;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bb)) {
            return false;
        }
        bb bbVar = (bb) obj;
        return k.a((Object) this.f74537a, (Object) bbVar.f74537a) && this.f74543g == bbVar.f74543g && this.f74544h == bbVar.f74544h && k.a((Object) this.f74538b, (Object) bbVar.f74538b) && this.f74539c == bbVar.f74539c && this.f74540d == bbVar.f74540d && k.a((Object) this.f74541e, (Object) bbVar.f74541e) && k.a((Object) this.f74542f, (Object) bbVar.f74542f);
    }

    public final int hashCode() {
        String str = this.f74537a;
        int i2 = 0;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.f74543g).hashCode()) * 31) + Integer.valueOf(this.f74544h).hashCode()) * 31;
        String str2 = this.f74538b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.f74539c;
        if (z) {
            z = true;
        }
        int hashCode3 = (((hashCode2 + (z ? 1 : 0)) * 31) + Integer.valueOf(this.f74540d).hashCode()) * 31;
        String str3 = this.f74541e;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        CJRMoviesSession cJRMoviesSession = this.f74542f;
        if (cJRMoviesSession != null) {
            i2 = cJRMoviesSession.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "MovieTimeSlot(time=" + this.f74537a + ", totalSeats=" + this.f74543g + ", seats=" + this.f74544h + ", screenFormat=" + this.f74538b + ", isFormatVisible=" + this.f74539c + ", colorInt=" + this.f74540d + ", colorString=" + this.f74541e + ", item=" + this.f74542f + ")";
    }

    public bb(String str, int i2, int i3, String str2, boolean z, int i4, String str3, CJRMoviesSession cJRMoviesSession) {
        k.c(str, "time");
        k.c(str2, "screenFormat");
        k.c(cJRMoviesSession, "item");
        this.f74537a = str;
        this.f74543g = i2;
        this.f74544h = i3;
        this.f74538b = str2;
        this.f74539c = z;
        this.f74540d = i4;
        this.f74541e = str3;
        this.f74542f = cJRMoviesSession;
    }
}
