package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.a;

public final class l implements Parcelable.Creator<PlacePhotoResult> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new PlacePhotoResult[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        Status status = null;
        BitmapTeleporter bitmapTeleporter = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                status = (Status) a.a(parcel, readInt, Status.CREATOR);
            } else if (i2 != 2) {
                a.b(parcel, readInt);
            } else {
                bitmapTeleporter = (BitmapTeleporter) a.a(parcel, readInt, BitmapTeleporter.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new PlacePhotoResult(status, bitmapTeleporter);
    }
}
