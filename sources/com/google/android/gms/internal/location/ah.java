package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.location.zzj;
import java.util.List;

public final class ah implements Parcelable.Creator<zzm> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzm[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        zzj zzj = zzm.f10426b;
        List<ClientIdentity> list = zzm.f10425a;
        String str = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                zzj = (zzj) a.a(parcel, readInt, zzj.CREATOR);
            } else if (i2 == 2) {
                list = a.c(parcel, readInt, ClientIdentity.CREATOR);
            } else if (i2 != 3) {
                a.b(parcel, readInt);
            } else {
                str = a.n(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzm(zzj, list, str);
    }
}
