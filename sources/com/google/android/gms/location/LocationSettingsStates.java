package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f11361a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11362b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f11363c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f11364d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f11365e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f11366f;

    public LocationSettingsStates(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f11361a = z;
        this.f11362b = z2;
        this.f11363c = z3;
        this.f11364d = z4;
        this.f11365e = z5;
        this.f11366f = z6;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11361a);
        b.a(parcel, 2, this.f11362b);
        b.a(parcel, 3, this.f11363c);
        b.a(parcel, 4, this.f11364d);
        b.a(parcel, 5, this.f11365e);
        b.a(parcel, 6, this.f11366f);
        b.b(parcel, a2);
    }
}
