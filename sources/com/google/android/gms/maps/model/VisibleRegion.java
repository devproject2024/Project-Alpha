package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public final class VisibleRegion extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VisibleRegion> CREATOR = new z();

    /* renamed from: a  reason: collision with root package name */
    public final LatLng f11658a;

    /* renamed from: b  reason: collision with root package name */
    public final LatLng f11659b;

    /* renamed from: c  reason: collision with root package name */
    public final LatLng f11660c;

    /* renamed from: d  reason: collision with root package name */
    public final LatLng f11661d;

    /* renamed from: e  reason: collision with root package name */
    public final LatLngBounds f11662e;

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.f11658a = latLng;
        this.f11659b = latLng2;
        this.f11660c = latLng3;
        this.f11661d = latLng4;
        this.f11662e = latLngBounds;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11658a, this.f11659b, this.f11660c, this.f11661d, this.f11662e});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return this.f11658a.equals(visibleRegion.f11658a) && this.f11659b.equals(visibleRegion.f11659b) && this.f11660c.equals(visibleRegion.f11660c) && this.f11661d.equals(visibleRegion.f11661d) && this.f11662e.equals(visibleRegion.f11662e);
    }

    public final String toString() {
        return q.a((Object) this).a("nearLeft", this.f11658a).a("nearRight", this.f11659b).a("farLeft", this.f11660c).a("farRight", this.f11661d).a("latLngBounds", this.f11662e).toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f11658a, i2, false);
        b.a(parcel, 3, this.f11659b, i2, false);
        b.a(parcel, 4, this.f11660c, i2, false);
        b.a(parcel, 5, this.f11661d, i2, false);
        b.a(parcel, 6, this.f11662e, i2, false);
        b.b(parcel, a2);
    }
}
