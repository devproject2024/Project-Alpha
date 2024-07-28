package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.vision.barcode.Barcode;

public final class i implements Parcelable.Creator<Barcode.PersonName> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new Barcode.PersonName[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = a.n(parcel, readInt);
                    break;
                case 3:
                    str2 = a.n(parcel, readInt);
                    break;
                case 4:
                    str3 = a.n(parcel, readInt);
                    break;
                case 5:
                    str4 = a.n(parcel, readInt);
                    break;
                case 6:
                    str5 = a.n(parcel, readInt);
                    break;
                case 7:
                    str6 = a.n(parcel, readInt);
                    break;
                case 8:
                    str7 = a.n(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        a.A(parcel, a2);
        return new Barcode.PersonName(str, str2, str3, str4, str5, str6, str7);
    }
}
