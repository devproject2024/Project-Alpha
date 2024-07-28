package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.vision.barcode.Barcode;

public final class g implements Parcelable.Creator<Barcode.Email> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new Barcode.Email[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 2) {
                i2 = a.e(parcel, readInt);
            } else if (i3 == 3) {
                str = a.n(parcel, readInt);
            } else if (i3 == 4) {
                str2 = a.n(parcel, readInt);
            } else if (i3 != 5) {
                a.b(parcel, readInt);
            } else {
                str3 = a.n(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new Barcode.Email(i2, str, str2, str3);
    }
}
