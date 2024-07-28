package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class e implements Parcelable.Creator<WebImage> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new WebImage[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        int i2 = 0;
        Uri uri = null;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i5 = 65535 & readInt;
            if (i5 == 1) {
                i2 = a.e(parcel, readInt);
            } else if (i5 == 2) {
                uri = (Uri) a.a(parcel, readInt, Uri.CREATOR);
            } else if (i5 == 3) {
                i3 = a.e(parcel, readInt);
            } else if (i5 != 4) {
                a.b(parcel, readInt);
            } else {
                i4 = a.e(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new WebImage(i2, uri, i3, i4);
    }
}
