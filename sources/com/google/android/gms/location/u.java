package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class u implements Parcelable.Creator<ActivityRecognitionResult> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new ActivityRecognitionResult[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        long j = 0;
        long j2 = 0;
        ArrayList<DetectedActivity> arrayList = null;
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                arrayList = a.c(parcel, readInt, DetectedActivity.CREATOR);
            } else if (i3 == 2) {
                j = a.g(parcel, readInt);
            } else if (i3 == 3) {
                j2 = a.g(parcel, readInt);
            } else if (i3 == 4) {
                i2 = a.e(parcel, readInt);
            } else if (i3 != 5) {
                a.b(parcel, readInt);
            } else {
                bundle = a.p(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new ActivityRecognitionResult(arrayList, j, j2, i2, bundle);
    }
}
