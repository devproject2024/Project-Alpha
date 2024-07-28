package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final int f9079a = 1;

    /* renamed from: b  reason: collision with root package name */
    private final String f9080b;

    zzad(String str) {
        this.f9080b = (String) s.a(str);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f9079a);
        b.a(parcel, 2, this.f9080b, false);
        b.b(parcel, a2);
    }
}
