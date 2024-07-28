package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable.Creator<AccountChangeEvent> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new AccountChangeEvent[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        String str = null;
        String str2 = null;
        long j = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, readInt);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.a.n(parcel, readInt);
                    break;
                case 4:
                    i3 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 5:
                    i4 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        com.google.android.gms.common.internal.safeparcel.a.A(parcel, a2);
        return new AccountChangeEvent(i2, j, str, i3, i4, str2);
    }
}
