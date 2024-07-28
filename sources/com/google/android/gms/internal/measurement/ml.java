package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class ml implements Parcelable.Creator<zzv> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzv[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a2 = a.a(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        boolean z = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    j = a.g(parcel2, readInt);
                    break;
                case 2:
                    j2 = a.g(parcel2, readInt);
                    break;
                case 3:
                    z = a.c(parcel2, readInt);
                    break;
                case 4:
                    str = a.n(parcel2, readInt);
                    break;
                case 5:
                    str2 = a.n(parcel2, readInt);
                    break;
                case 6:
                    str3 = a.n(parcel2, readInt);
                    break;
                case 7:
                    bundle = a.p(parcel2, readInt);
                    break;
                default:
                    a.b(parcel2, readInt);
                    break;
            }
        }
        a.A(parcel2, a2);
        return new zzv(j, j2, z, str, str2, str3, bundle);
    }
}
