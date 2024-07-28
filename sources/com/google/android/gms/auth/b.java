package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class b implements Parcelable.Creator<AccountChangeEventsRequest> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new AccountChangeEventsRequest[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        int i2 = 0;
        String str = null;
        Account account = null;
        int i3 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = a.e(parcel, readInt);
            } else if (i4 == 2) {
                i3 = a.e(parcel, readInt);
            } else if (i4 == 3) {
                str = a.n(parcel, readInt);
            } else if (i4 != 4) {
                a.b(parcel, readInt);
            } else {
                account = (Account) a.a(parcel, readInt, Account.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new AccountChangeEventsRequest(i2, i3, str, account);
    }
}
