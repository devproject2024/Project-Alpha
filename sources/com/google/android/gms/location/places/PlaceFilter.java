package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Deprecated
public final class PlaceFilter extends zzb {
    public static final Parcelable.Creator<PlaceFilter> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    private static final PlaceFilter f11389a = new PlaceFilter();

    /* renamed from: b  reason: collision with root package name */
    private final List<Integer> f11390b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f11391c;

    /* renamed from: d  reason: collision with root package name */
    private final List<zzp> f11392d;

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f11393e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<Integer> f11394f;

    /* renamed from: g  reason: collision with root package name */
    private final Set<zzp> f11395g;

    /* renamed from: h  reason: collision with root package name */
    private final Set<String> f11396h;

    public PlaceFilter() {
        this((byte) 0);
    }

    private PlaceFilter(byte b2) {
        this(0);
    }

    PlaceFilter(List<Integer> list, boolean z, List<String> list2, List<zzp> list3) {
        this.f11390b = list;
        this.f11391c = z;
        this.f11392d = list3;
        this.f11393e = list2;
        this.f11394f = a(this.f11390b);
        this.f11395g = a(this.f11392d);
        this.f11396h = a(this.f11393e);
    }

    public final String toString() {
        q.a a2 = q.a((Object) this);
        if (!this.f11394f.isEmpty()) {
            a2.a("types", this.f11394f);
        }
        a2.a("requireOpenNow", Boolean.valueOf(this.f11391c));
        if (!this.f11396h.isEmpty()) {
            a2.a("placeIds", this.f11396h);
        }
        if (!this.f11395g.isEmpty()) {
            a2.a("requestedUserDataTypes", this.f11395g);
        }
        return a2.toString();
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11394f, Boolean.valueOf(this.f11391c), this.f11395g, this.f11396h});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) obj;
        return this.f11394f.equals(placeFilter.f11394f) && this.f11391c == placeFilter.f11391c && this.f11395g.equals(placeFilter.f11395g) && this.f11396h.equals(placeFilter.f11396h);
    }

    private PlaceFilter(char c2) {
        this(Collections.emptyList(), false, Collections.emptyList(), Collections.emptyList());
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11390b);
        b.a(parcel, 3, this.f11391c);
        b.a(parcel, 4, this.f11392d, false);
        b.b(parcel, 6, this.f11393e);
        b.b(parcel, a2);
    }
}
