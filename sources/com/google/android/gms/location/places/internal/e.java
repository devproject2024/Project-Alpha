package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class e implements Parcelable.Creator<zzak> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzak[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        PlaceEntity placeEntity = null;
        float f2 = 0.0f;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                placeEntity = (PlaceEntity) a.a(parcel, readInt, PlaceEntity.CREATOR);
            } else if (i2 != 2) {
                a.b(parcel, readInt);
            } else {
                f2 = a.j(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzak(placeEntity, f2);
    }
}
