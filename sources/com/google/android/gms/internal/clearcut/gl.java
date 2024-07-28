package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class gl implements Parcelable.Creator<zzr> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzr[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        boolean z = true;
        boolean z2 = false;
        int i4 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = a.n(parcel, readInt);
                    break;
                case 3:
                    i2 = a.e(parcel, readInt);
                    break;
                case 4:
                    i3 = a.e(parcel, readInt);
                    break;
                case 5:
                    str2 = a.n(parcel, readInt);
                    break;
                case 6:
                    str3 = a.n(parcel, readInt);
                    break;
                case 7:
                    z = a.c(parcel, readInt);
                    break;
                case 8:
                    str4 = a.n(parcel, readInt);
                    break;
                case 9:
                    z2 = a.c(parcel, readInt);
                    break;
                case 10:
                    i4 = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        a.A(parcel, a2);
        return new zzr(str, i2, i3, str2, str3, z, str4, z2, i4);
    }
}
