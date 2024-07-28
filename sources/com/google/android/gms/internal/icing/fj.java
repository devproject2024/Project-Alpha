package com.google.android.gms.internal.icing;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class fj implements Parcelable.Creator<zzh> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzh[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        zzk[] zzkArr = null;
        String str = null;
        Account account = null;
        boolean z = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                zzkArr = (zzk[]) a.b(parcel, readInt, zzk.CREATOR);
            } else if (i2 == 2) {
                str = a.n(parcel, readInt);
            } else if (i2 == 3) {
                z = a.c(parcel, readInt);
            } else if (i2 != 4) {
                a.b(parcel, readInt);
            } else {
                account = (Account) a.a(parcel, readInt, Account.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new zzh(zzkArr, str, z, account);
    }
}
