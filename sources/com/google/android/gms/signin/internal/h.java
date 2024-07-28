package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.a;

public final class h implements Parcelable.Creator<zai> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zai[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        int i2 = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = a.e(parcel, readInt);
            } else if (i3 != 2) {
                a.b(parcel, readInt);
            } else {
                resolveAccountRequest = (ResolveAccountRequest) a.a(parcel, readInt, ResolveAccountRequest.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new zai(i2, resolveAccountRequest);
    }
}
