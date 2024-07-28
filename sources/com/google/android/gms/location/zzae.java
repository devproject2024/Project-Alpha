package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    private final String f11482a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11483b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11484c;

    zzae(String str, String str2, String str3) {
        this.f11484c = str;
        this.f11482a = str2;
        this.f11483b = str3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11482a, false);
        b.a(parcel, 2, this.f11483b, false);
        b.a(parcel, 5, this.f11484c, false);
        b.b(parcel, a2);
    }
}
