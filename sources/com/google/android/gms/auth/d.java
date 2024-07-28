package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class d implements Parcelable.Creator<TokenData> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new TokenData[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        Long l = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = a.e(parcel, readInt);
                    break;
                case 2:
                    str = a.n(parcel, readInt);
                    break;
                case 3:
                    l = a.h(parcel, readInt);
                    break;
                case 4:
                    z = a.c(parcel, readInt);
                    break;
                case 5:
                    z2 = a.c(parcel, readInt);
                    break;
                case 6:
                    arrayList = a.x(parcel, readInt);
                    break;
                case 7:
                    str2 = a.n(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        a.A(parcel, a2);
        return new TokenData(i2, str, l, z, z2, arrayList, str2);
    }
}
