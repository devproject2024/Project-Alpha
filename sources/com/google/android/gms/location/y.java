package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class y implements Parcelable.Creator<ActivityTransitionRequest> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new ActivityTransitionRequest[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        ArrayList<ActivityTransition> arrayList = null;
        String str = null;
        ArrayList<ClientIdentity> arrayList2 = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                arrayList = a.c(parcel, readInt, ActivityTransition.CREATOR);
            } else if (i2 == 2) {
                str = a.n(parcel, readInt);
            } else if (i2 != 3) {
                a.b(parcel, readInt);
            } else {
                arrayList2 = a.c(parcel, readInt, ClientIdentity.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new ActivityTransitionRequest(arrayList, str, arrayList2);
    }
}
