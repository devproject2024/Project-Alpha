package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class z implements Parcelable.Creator<ActivityTransitionResult> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new ActivityTransitionResult[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        ArrayList<ActivityTransitionEvent> arrayList = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                a.b(parcel, readInt);
            } else {
                arrayList = a.c(parcel, readInt, ActivityTransitionEvent.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new ActivityTransitionResult(arrayList);
    }
}
