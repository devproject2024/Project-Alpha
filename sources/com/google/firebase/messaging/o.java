package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class o implements Parcelable.Creator<RemoteMessage> {
    static void a(RemoteMessage remoteMessage, Parcel parcel) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, remoteMessage.f38993a);
        b.b(parcel, a2);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
        return new RemoteMessage[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 2) {
                a.b(parcel, readInt);
            } else {
                bundle = a.p(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new RemoteMessage(bundle);
    }
}
