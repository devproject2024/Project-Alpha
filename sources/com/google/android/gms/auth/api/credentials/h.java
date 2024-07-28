package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class h implements Parcelable.Creator<IdToken> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new IdToken[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str = a.n(parcel, readInt);
            } else if (i2 != 2) {
                a.b(parcel, readInt);
            } else {
                str2 = a.n(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new IdToken(str, str2);
    }
}
