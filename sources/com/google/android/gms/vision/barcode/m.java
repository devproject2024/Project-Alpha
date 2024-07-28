package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.vision.barcode.Barcode;

public final class m implements Parcelable.Creator<Barcode.WiFi> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new Barcode.WiFi[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 2) {
                str = a.n(parcel, readInt);
            } else if (i3 == 3) {
                str2 = a.n(parcel, readInt);
            } else if (i3 != 4) {
                a.b(parcel, readInt);
            } else {
                i2 = a.e(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new Barcode.WiFi(str, str2, i2);
    }
}
