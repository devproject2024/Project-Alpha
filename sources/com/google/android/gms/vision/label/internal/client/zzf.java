package com.google.android.gms.vision.label.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f12657a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12658b;

    /* renamed from: c  reason: collision with root package name */
    public final float f12659c;

    public zzf(String str, String str2, float f2) {
        this.f12658b = str2;
        this.f12659c = f2;
        this.f12657a = str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f12658b, false);
        b.a(parcel, 3, this.f12659c);
        b.a(parcel, 4, this.f12657a, false);
        b.b(parcel, a2);
    }
}
