package com.travel.flight.flightSRPV2.a;

import androidx.databinding.i;
import com.google.gsonhtcfix.a.a;
import kotlin.g.b.k;

public final class d implements o<d> {

    /* renamed from: a  reason: collision with root package name */
    public final String f24095a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24096b;

    /* renamed from: c  reason: collision with root package name */
    public int f24097c;

    /* renamed from: d  reason: collision with root package name */
    public int f24098d;
    @a(a = false, b = false)

    /* renamed from: e  reason: collision with root package name */
    public transient i<Boolean> f24099e;

    public static /* synthetic */ d a(d dVar, String str, String str2, int i2, int i3, i<Boolean> iVar, int i4) {
        if ((i4 & 1) != 0) {
            str = dVar.f24095a;
        }
        if ((i4 & 2) != 0) {
            str2 = dVar.f24096b;
        }
        if ((i4 & 4) != 0) {
            i2 = dVar.f24097c;
        }
        if ((i4 & 8) != 0) {
            i3 = dVar.f24098d;
        }
        if ((i4 & 16) != 0) {
            iVar = dVar.f24099e;
        }
        return a(str, str2, i2, i3, iVar);
    }

    private static d a(String str, String str2, int i2, int i3, i<Boolean> iVar) {
        k.c(str, "airlineCode");
        k.c(str2, "airlineName");
        k.c(iVar, "isAirlineSelected");
        return new d(str, str2, i2, i3, iVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return k.a((Object) this.f24095a, (Object) dVar.f24095a) && k.a((Object) this.f24096b, (Object) dVar.f24096b) && this.f24097c == dVar.f24097c && this.f24098d == dVar.f24098d && k.a((Object) this.f24099e, (Object) dVar.f24099e);
    }

    public final int hashCode() {
        String str = this.f24095a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f24096b;
        int hashCode2 = (((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f24097c) * 31) + this.f24098d) * 31;
        i<Boolean> iVar = this.f24099e;
        if (iVar != null) {
            i2 = iVar.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "AirlineFilterInfo(airlineCode=" + this.f24095a + ", airlineName=" + this.f24096b + ", count=" + this.f24097c + ", minPrice=" + this.f24098d + ", isAirlineSelected=" + this.f24099e + ")";
    }

    public d(String str, String str2, int i2, int i3, i<Boolean> iVar) {
        k.c(str, "airlineCode");
        k.c(str2, "airlineName");
        k.c(iVar, "isAirlineSelected");
        this.f24095a = str;
        this.f24096b = str2;
        this.f24097c = i2;
        this.f24098d = i3;
        this.f24099e = iVar;
    }

    public final void a(i<Boolean> iVar) {
        k.c(iVar, "<set-?>");
        this.f24099e = iVar;
    }

    /* renamed from: a */
    public final d b() {
        i iVar = new i();
        iVar.set(this.f24099e.get());
        return a(this, (String) null, (String) null, 0, 0, iVar, 15);
    }
}
