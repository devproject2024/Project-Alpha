package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    private final int f11456a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11457b;

    zzao(int i2, int i3) {
        this.f11456a = i2;
        this.f11457b = i3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f11456a);
        b.b(parcel, 2, this.f11457b);
        b.b(parcel, a2);
    }
}
