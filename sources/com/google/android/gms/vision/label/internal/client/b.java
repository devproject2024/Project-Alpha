package com.google.android.gms.vision.label.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class b implements Parcelable.Creator<ImageLabelerOptions> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new ImageLabelerOptions[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        int i2 = 0;
        int i3 = 0;
        float f2 = 0.0f;
        int i4 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i5 = 65535 & readInt;
            if (i5 == 2) {
                i2 = a.e(parcel, readInt);
            } else if (i5 == 3) {
                i3 = a.e(parcel, readInt);
            } else if (i5 == 4) {
                f2 = a.j(parcel, readInt);
            } else if (i5 != 5) {
                a.b(parcel, readInt);
            } else {
                i4 = a.e(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new ImageLabelerOptions(i2, i3, f2, i4);
    }
}
