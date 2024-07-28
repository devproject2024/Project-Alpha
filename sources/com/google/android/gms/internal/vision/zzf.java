package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new bs();

    /* renamed from: a  reason: collision with root package name */
    public int f11300a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11301b;

    public zzf() {
    }

    public zzf(int i2, boolean z) {
        this.f11300a = i2;
        this.f11301b = z;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 2, this.f11300a);
        b.a(parcel, 3, this.f11301b);
        b.b(parcel, a2);
    }
}
