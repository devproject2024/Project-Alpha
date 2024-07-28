package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class b implements Parcelable.Creator<ProxyRequest> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new ProxyRequest[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        byte[] bArr = null;
        Bundle bundle = null;
        long j = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                str = a.n(parcel, readInt);
            } else if (i4 == 2) {
                i3 = a.e(parcel, readInt);
            } else if (i4 == 3) {
                j = a.g(parcel, readInt);
            } else if (i4 == 4) {
                bArr = a.q(parcel, readInt);
            } else if (i4 == 5) {
                bundle = a.p(parcel, readInt);
            } else if (i4 != 1000) {
                a.b(parcel, readInt);
            } else {
                i2 = a.e(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new ProxyRequest(i2, str, i3, j, bArr, bundle);
    }
}
