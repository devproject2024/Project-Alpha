package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;

public final class k implements Parcelable.Creator<PlacePhotoMetadataResult> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new PlacePhotoMetadataResult[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        Status status = null;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                status = (Status) a.a(parcel, readInt, Status.CREATOR);
            } else if (i2 != 2) {
                a.b(parcel, readInt);
            } else {
                dataHolder = (DataHolder) a.a(parcel, readInt, DataHolder.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new PlacePhotoMetadataResult(status, dataHolder);
    }
}
