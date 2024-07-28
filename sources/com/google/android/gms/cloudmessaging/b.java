package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class b implements Parcelable.Creator<CloudMessage> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new CloudMessage[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                a.b(parcel, readInt);
            } else {
                intent = (Intent) a.a(parcel, readInt, Intent.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new CloudMessage(intent);
    }
}
