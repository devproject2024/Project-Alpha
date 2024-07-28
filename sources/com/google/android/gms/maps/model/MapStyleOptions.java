package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class MapStyleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MapStyleOptions> CREATOR = new l();

    /* renamed from: a  reason: collision with root package name */
    private static final String f11597a = MapStyleOptions.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private String f11598b;

    public MapStyleOptions(String str) {
        this.f11598b = str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f11598b, false);
        b.b(parcel, a2);
    }
}
