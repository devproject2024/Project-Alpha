package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class b implements Parcelable.Creator<BeginSignInRequest.GoogleIdTokenRequestOptions> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new BeginSignInRequest.GoogleIdTokenRequestOptions[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        ArrayList<String> arrayList = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    z = a.c(parcel, readInt);
                    break;
                case 2:
                    str = a.n(parcel, readInt);
                    break;
                case 3:
                    str2 = a.n(parcel, readInt);
                    break;
                case 4:
                    z2 = a.c(parcel, readInt);
                    break;
                case 5:
                    str3 = a.n(parcel, readInt);
                    break;
                case 6:
                    arrayList = a.x(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        a.A(parcel, a2);
        return new BeginSignInRequest.GoogleIdTokenRequestOptions(z, str, str2, z2, str3, arrayList);
    }
}
