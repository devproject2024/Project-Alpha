package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class PointOfInterest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PointOfInterest> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    public final LatLng f11611a;

    /* renamed from: b  reason: collision with root package name */
    public final String f11612b;

    /* renamed from: c  reason: collision with root package name */
    public final String f11613c;

    public PointOfInterest(LatLng latLng, String str, String str2) {
        this.f11611a = latLng;
        this.f11612b = str;
        this.f11613c = str2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f11611a, i2, false);
        b.a(parcel, 3, this.f11612b, false);
        b.a(parcel, 4, this.f11613c, false);
        b.b(parcel, a2);
    }
}
