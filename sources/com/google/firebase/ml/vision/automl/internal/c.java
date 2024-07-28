package com.google.firebase.ml.vision.automl.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class c implements Parcelable.Creator<OnDeviceAutoMLImageLabelerOptionsParcel> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new OnDeviceAutoMLImageLabelerOptionsParcel[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        float f2 = 0.0f;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                f2 = a.j(parcel, readInt);
            } else if (i2 == 2) {
                str = a.n(parcel, readInt);
            } else if (i2 == 3) {
                str2 = a.n(parcel, readInt);
            } else if (i2 != 4) {
                a.b(parcel, readInt);
            } else {
                str3 = a.n(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new OnDeviceAutoMLImageLabelerOptionsParcel(f2, str, str2, str3);
    }
}
