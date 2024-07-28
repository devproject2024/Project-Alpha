package net.one97.paytm.passbook.spendanalytics.piechart;

import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    Integer f58590a;

    /* renamed from: b  reason: collision with root package name */
    Float f58591b;

    /* renamed from: c  reason: collision with root package name */
    float f58592c;

    /* renamed from: d  reason: collision with root package name */
    float f58593d;

    /* renamed from: e  reason: collision with root package name */
    private String f58594e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a((Object) this.f58590a, (Object) aVar.f58590a) && k.a((Object) this.f58591b, (Object) aVar.f58591b) && k.a((Object) this.f58594e, (Object) aVar.f58594e) && Float.compare(this.f58592c, aVar.f58592c) == 0 && Float.compare(this.f58593d, aVar.f58593d) == 0;
    }

    public final int hashCode() {
        Integer num = this.f58590a;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Float f2 = this.f58591b;
        int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 31;
        String str = this.f58594e;
        if (str != null) {
            i2 = str.hashCode();
        }
        return ((((hashCode2 + i2) * 31) + Float.floatToIntBits(this.f58592c)) * 31) + Float.floatToIntBits(this.f58593d);
    }

    public final String toString() {
        return "GraphItem(colorCode=" + this.f58590a + ", amount=" + this.f58591b + ", tag=" + this.f58594e + ", startCurveDegree=" + this.f58592c + ", endCurveDegree=" + this.f58593d + ")";
    }

    private a(Integer num, Float f2, String str) {
        this.f58590a = num;
        this.f58591b = f2;
        this.f58594e = str;
        this.f58592c = 0.0f;
        this.f58593d = 0.0f;
    }

    public /* synthetic */ a(Integer num, Float f2, String str, byte b2) {
        this(num, f2, str);
    }

    public final Float a(float f2) {
        Float f3 = this.f58591b;
        if (f3 != null) {
            return Float.valueOf((f3.floatValue() * 360.0f) / f2);
        }
        return null;
    }
}
