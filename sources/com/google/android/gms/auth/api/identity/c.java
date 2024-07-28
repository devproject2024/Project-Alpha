package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class c implements Parcelable.Creator<BeginSignInResult> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new BeginSignInResult[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                a.b(parcel, readInt);
            } else {
                pendingIntent = (PendingIntent) a.a(parcel, readInt, PendingIntent.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new BeginSignInResult(pendingIntent);
    }
}
