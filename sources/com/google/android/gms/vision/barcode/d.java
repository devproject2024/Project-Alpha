package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.vision.barcode.Barcode;

public final class d implements Parcelable.Creator<Barcode.CalendarDateTime> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new Barcode.CalendarDateTime[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        boolean z = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    i2 = a.e(parcel, readInt);
                    break;
                case 3:
                    i3 = a.e(parcel, readInt);
                    break;
                case 4:
                    i4 = a.e(parcel, readInt);
                    break;
                case 5:
                    i5 = a.e(parcel, readInt);
                    break;
                case 6:
                    i6 = a.e(parcel, readInt);
                    break;
                case 7:
                    i7 = a.e(parcel, readInt);
                    break;
                case 8:
                    z = a.c(parcel, readInt);
                    break;
                case 9:
                    str = a.n(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        a.A(parcel, a2);
        return new Barcode.CalendarDateTime(i2, i3, i4, i5, i6, i7, z, str);
    }
}
