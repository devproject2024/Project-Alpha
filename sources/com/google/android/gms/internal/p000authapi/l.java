package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.a;

/* renamed from: com.google.android.gms.internal.auth-api.l  reason: invalid package */
public final class l implements Parcelable.Creator<zzz> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzz[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        Credential credential = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                a.b(parcel, readInt);
            } else {
                credential = (Credential) a.a(parcel, readInt, Credential.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new zzz(credential);
    }
}
