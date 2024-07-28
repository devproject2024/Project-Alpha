package com.alipay.a.a.a;

import com.squareup.b.g;
import com.squareup.b.k;

public final class b extends g {

    /* renamed from: a  reason: collision with root package name */
    public static final Integer f14674a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final Integer f14675b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final Integer f14676c = 0;
    @k(a = 1, b = g.a.STRING)

    /* renamed from: d  reason: collision with root package name */
    public String f14677d;
    @k(a = 2, b = g.a.INT32)

    /* renamed from: e  reason: collision with root package name */
    public Integer f14678e;
    @k(a = 3, b = g.a.INT32)

    /* renamed from: f  reason: collision with root package name */
    public Integer f14679f;
    @k(a = 4, b = g.a.INT32)

    /* renamed from: g  reason: collision with root package name */
    public Integer f14680g;
    @k(a = 5, b = g.a.STRING)

    /* renamed from: h  reason: collision with root package name */
    public String f14681h;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return a((Object) this.f14677d, (Object) bVar.f14677d) && a((Object) this.f14678e, (Object) bVar.f14678e) && a((Object) this.f14679f, (Object) bVar.f14679f) && a((Object) this.f14680g, (Object) bVar.f14680g) && a((Object) this.f14681h, (Object) bVar.f14681h);
    }

    public final int hashCode() {
        int i2 = this.w;
        if (i2 != 0) {
            return i2;
        }
        String str = this.f14677d;
        int i3 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.f14678e;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.f14679f;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.f14680g;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.f14681h;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        int i4 = hashCode4 + i3;
        this.w = i4;
        return i4;
    }
}
