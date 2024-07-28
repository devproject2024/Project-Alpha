package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzab extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzab> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f9076a = 1;

    /* renamed from: b  reason: collision with root package name */
    private final String f9077b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9078c;

    zzab(String str, int i2) {
        this.f9077b = (String) s.a(str);
        this.f9078c = i2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f9076a);
        b.a(parcel, 2, this.f9077b, false);
        b.b(parcel, 3, this.f9078c);
        b.b(parcel, a2);
    }
}
