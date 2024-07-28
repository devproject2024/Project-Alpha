package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    public final LatLng f11595a;

    /* renamed from: b  reason: collision with root package name */
    public final LatLng f11596b;

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        s.a(latLng, (Object) "null southwest");
        s.a(latLng2, (Object) "null northeast");
        s.b(latLng2.f11593a >= latLng.f11593a, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(latLng.f11593a), Double.valueOf(latLng2.f11593a));
        this.f11595a = latLng;
        this.f11596b = latLng2;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11595a, this.f11596b});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.f11595a.equals(latLngBounds.f11595a) && this.f11596b.equals(latLngBounds.f11596b);
    }

    public final String toString() {
        return q.a((Object) this).a("southwest", this.f11595a).a("northeast", this.f11596b).toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f11595a, i2, false);
        b.a(parcel, 3, this.f11596b, i2, false);
        b.b(parcel, a2);
    }
}
