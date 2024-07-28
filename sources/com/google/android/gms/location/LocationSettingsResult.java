package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class LocationSettingsResult extends AbstractSafeParcelable implements l {
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    public final Status f11359a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationSettingsStates f11360b;

    public LocationSettingsResult(Status status) {
        this(status, (LocationSettingsStates) null);
    }

    public LocationSettingsResult(Status status, LocationSettingsStates locationSettingsStates) {
        this.f11359a = status;
        this.f11360b = locationSettingsStates;
    }

    public final Status a() {
        return this.f11359a;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11359a, i2, false);
        b.a(parcel, 2, this.f11360b, i2, false);
        b.b(parcel, a2);
    }
}
