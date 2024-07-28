package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class b implements Parcelable.Creator<UserAddress> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new UserAddress[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a2 = a.a(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        boolean z = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = a.n(parcel2, readInt);
                    break;
                case 3:
                    str2 = a.n(parcel2, readInt);
                    break;
                case 4:
                    str3 = a.n(parcel2, readInt);
                    break;
                case 5:
                    str4 = a.n(parcel2, readInt);
                    break;
                case 6:
                    str5 = a.n(parcel2, readInt);
                    break;
                case 7:
                    str6 = a.n(parcel2, readInt);
                    break;
                case 8:
                    str7 = a.n(parcel2, readInt);
                    break;
                case 9:
                    str8 = a.n(parcel2, readInt);
                    break;
                case 10:
                    str9 = a.n(parcel2, readInt);
                    break;
                case 11:
                    str10 = a.n(parcel2, readInt);
                    break;
                case 12:
                    str11 = a.n(parcel2, readInt);
                    break;
                case 13:
                    str12 = a.n(parcel2, readInt);
                    break;
                case 14:
                    z = a.c(parcel2, readInt);
                    break;
                case 15:
                    str13 = a.n(parcel2, readInt);
                    break;
                case 16:
                    str14 = a.n(parcel2, readInt);
                    break;
                default:
                    a.b(parcel2, readInt);
                    break;
            }
        }
        a.A(parcel2, a2);
        return new UserAddress(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
    }
}
