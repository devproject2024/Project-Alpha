package com.travel.bus.model;

import android.text.Html;
import android.text.Spanned;
import com.travel.bus.busticket.i.i;
import kotlin.g.b.k;

public final class b implements Comparable<b> {

    /* renamed from: e  reason: collision with root package name */
    public static final a f22542e = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final String f22543a;

    /* renamed from: b  reason: collision with root package name */
    public String f22544b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22545c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22546d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return k.a((Object) this.f22543a, (Object) bVar.f22543a) && k.a((Object) this.f22544b, (Object) bVar.f22544b) && this.f22545c == bVar.f22545c && this.f22546d == bVar.f22546d;
    }

    public final String toString() {
        return "SeatPriceTag(price=" + this.f22543a + ", discountedPrice=" + this.f22544b + ", hasDiscountedPrice=" + this.f22545c + ", isChecked=" + this.f22546d + ")";
    }

    public b(String str, String str2, boolean z, boolean z2) {
        k.c(str2, "discountedPrice");
        this.f22543a = str;
        this.f22544b = str2;
        this.f22545c = z;
        this.f22546d = z2;
        CharSequence charSequence = this.f22544b;
        boolean z3 = false;
        if (!(charSequence == null || charSequence.length() == 0) && (!k.a((Object) this.f22544b, (Object) this.f22543a))) {
            z3 = true;
        }
        this.f22545c = z3;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        k.c(bVar, "other");
        String str = bVar.f22543a;
        if (str == null) {
            k.a();
        }
        int parseDouble = (int) Double.parseDouble(str);
        String str2 = this.f22543a;
        if (str2 == null) {
            k.a();
        }
        int parseDouble2 = (int) Double.parseDouble(str2);
        if (parseDouble == parseDouble2) {
            return 0;
        }
        return parseDouble > parseDouble2 ? -1 : 1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(String str, String str2, boolean z, int i2) {
        this(str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? false : z, false);
    }

    public final int hashCode() {
        String str = this.f22543a;
        if (str == null) {
            return 0;
        }
        return (int) Double.parseDouble(str);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static Spanned a(String str, String str2) {
        Spanned fromHtml = Html.fromHtml(str + "<strike>" + str2 + "</strike>");
        k.a((Object) fromHtml, "Html.fromHtml(string)");
        return fromHtml;
    }

    public static String a(String str) {
        String a2 = i.a(Double.parseDouble(str));
        k.a((Object) a2, "CJRBusDecimalUtils.getFo…decimalNumber.toDouble())");
        return a2;
    }
}
