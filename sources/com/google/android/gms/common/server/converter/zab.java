package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FastJsonResponse;

public final class zab extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zab> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final StringToIntConverter f8902a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8903b;

    zab(int i2, StringToIntConverter stringToIntConverter) {
        this.f8903b = i2;
        this.f8902a = stringToIntConverter;
    }

    private zab(StringToIntConverter stringToIntConverter) {
        this.f8903b = 1;
        this.f8902a = stringToIntConverter;
    }

    public static zab a(FastJsonResponse.a<?, ?> aVar) {
        if (aVar instanceof StringToIntConverter) {
            return new zab((StringToIntConverter) aVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8903b);
        b.a(parcel, 2, this.f8902a, i2, false);
        b.b(parcel, a2);
    }
}
