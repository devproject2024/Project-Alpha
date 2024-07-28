package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    private static final List<zzb> f11467a = Collections.emptyList();

    /* renamed from: b  reason: collision with root package name */
    private final String f11468b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11469c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Integer> f11470d;

    /* renamed from: e  reason: collision with root package name */
    private final List<zzb> f11471e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11472f;

    /* renamed from: g  reason: collision with root package name */
    private final String f11473g;

    /* renamed from: h  reason: collision with root package name */
    private final List<zzb> f11474h;

    /* renamed from: i  reason: collision with root package name */
    private final String f11475i;
    private final List<zzb> j;

    zzc(String str, List<Integer> list, int i2, String str2, List<zzb> list2, String str3, List<zzb> list3, String str4, List<zzb> list4) {
        this.f11469c = str;
        this.f11470d = list;
        this.f11472f = i2;
        this.f11468b = str2;
        this.f11471e = list2;
        this.f11473g = str3;
        this.f11474h = list3;
        this.f11475i = str4;
        this.j = list4;
    }

    public final String toString() {
        return q.a((Object) this).a("placeId", this.f11469c).a("placeTypes", this.f11470d).a("fullText", this.f11468b).a("fullTextMatchedSubstrings", this.f11471e).a("primaryText", this.f11473g).a("primaryTextMatchedSubstrings", this.f11474h).a("secondaryText", this.f11475i).a("secondaryTextMatchedSubstrings", this.j).toString();
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11469c, this.f11470d, Integer.valueOf(this.f11472f), this.f11468b, this.f11471e, this.f11473g, this.f11474h, this.f11475i, this.j});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzc = (zzc) obj;
        return q.a(this.f11469c, zzc.f11469c) && q.a(this.f11470d, zzc.f11470d) && q.a(Integer.valueOf(this.f11472f), Integer.valueOf(zzc.f11472f)) && q.a(this.f11468b, zzc.f11468b) && q.a(this.f11471e, zzc.f11471e) && q.a(this.f11473g, zzc.f11473g) && q.a(this.f11474h, zzc.f11474h) && q.a(this.f11475i, zzc.f11475i) && q.a(this.j, zzc.j);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11468b, false);
        b.a(parcel, 2, this.f11469c, false);
        b.a(parcel, 3, this.f11470d);
        b.a(parcel, 4, this.f11471e, false);
        b.b(parcel, 5, this.f11472f);
        b.a(parcel, 6, this.f11473g, false);
        b.a(parcel, 7, this.f11474h, false);
        b.a(parcel, 8, this.f11475i, false);
        b.a(parcel, 9, this.j, false);
        b.b(parcel, a2);
    }
}
