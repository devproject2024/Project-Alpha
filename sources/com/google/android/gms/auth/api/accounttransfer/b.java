package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class b implements Parcelable.Creator<zzo> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzo[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        ArrayList<String> arrayList = null;
        ArrayList<String> arrayList2 = null;
        ArrayList<String> arrayList3 = null;
        ArrayList<String> arrayList4 = null;
        ArrayList<String> arrayList5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = a.e(parcel, readInt);
                    break;
                case 2:
                    arrayList = a.x(parcel, readInt);
                    break;
                case 3:
                    arrayList2 = a.x(parcel, readInt);
                    break;
                case 4:
                    arrayList3 = a.x(parcel, readInt);
                    break;
                case 5:
                    arrayList4 = a.x(parcel, readInt);
                    break;
                case 6:
                    arrayList5 = a.x(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        a.A(parcel, a2);
        return new zzo(i2, arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
    }
}
