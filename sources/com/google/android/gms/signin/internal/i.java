package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.a;

public final class i implements Parcelable.Creator<zak> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zak[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        ConnectionResult connectionResult = null;
        int i2 = 0;
        ResolveAccountResponse resolveAccountResponse = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = a.e(parcel, readInt);
            } else if (i3 == 2) {
                connectionResult = (ConnectionResult) a.a(parcel, readInt, ConnectionResult.CREATOR);
            } else if (i3 != 3) {
                a.b(parcel, readInt);
            } else {
                resolveAccountResponse = (ResolveAccountResponse) a.a(parcel, readInt, ResolveAccountResponse.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new zak(i2, connectionResult, resolveAccountResponse);
    }
}
