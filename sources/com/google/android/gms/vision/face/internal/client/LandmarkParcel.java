package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class LandmarkParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LandmarkParcel> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    public final float f12640a;

    /* renamed from: b  reason: collision with root package name */
    public final float f12641b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12642c;

    /* renamed from: d  reason: collision with root package name */
    private final int f12643d;

    public LandmarkParcel(int i2, float f2, float f3, int i3) {
        this.f12643d = i2;
        this.f12640a = f2;
        this.f12641b = f3;
        this.f12642c = i3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f12643d);
        b.a(parcel, 2, this.f12640a);
        b.a(parcel, 3, this.f12641b);
        b.b(parcel, 4, this.f12642c);
        b.b(parcel, a2);
    }
}
