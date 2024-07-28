package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new al();

    /* renamed from: a  reason: collision with root package name */
    Bundle f8876a;

    /* renamed from: b  reason: collision with root package name */
    Feature[] f8877b;

    /* renamed from: c  reason: collision with root package name */
    private int f8878c;

    zzc(Bundle bundle, Feature[] featureArr, int i2) {
        this.f8876a = bundle;
        this.f8877b = featureArr;
        this.f8878c = i2;
    }

    public zzc() {
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f8876a);
        b.a(parcel, 2, (T[]) this.f8877b, i2);
        b.b(parcel, 3, this.f8878c);
        b.b(parcel, a2);
    }
}
