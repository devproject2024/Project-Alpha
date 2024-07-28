package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class e implements Parcelable.Creator<WakeLockEvent> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new WakeLockEvent[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a2 = a.a(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        float f2 = 0.0f;
        boolean z = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = a.e(parcel2, readInt);
                    break;
                case 2:
                    j = a.g(parcel2, readInt);
                    break;
                case 4:
                    str = a.n(parcel2, readInt);
                    break;
                case 5:
                    i4 = a.e(parcel2, readInt);
                    break;
                case 6:
                    arrayList = a.x(parcel2, readInt);
                    break;
                case 8:
                    j2 = a.g(parcel2, readInt);
                    break;
                case 10:
                    str3 = a.n(parcel2, readInt);
                    break;
                case 11:
                    i3 = a.e(parcel2, readInt);
                    break;
                case 12:
                    str2 = a.n(parcel2, readInt);
                    break;
                case 13:
                    str4 = a.n(parcel2, readInt);
                    break;
                case 14:
                    i5 = a.e(parcel2, readInt);
                    break;
                case 15:
                    f2 = a.j(parcel2, readInt);
                    break;
                case 16:
                    j3 = a.g(parcel2, readInt);
                    break;
                case 17:
                    str5 = a.n(parcel2, readInt);
                    break;
                case 18:
                    z = a.c(parcel2, readInt);
                    break;
                default:
                    a.b(parcel2, readInt);
                    break;
            }
        }
        a.A(parcel2, a2);
        return new WakeLockEvent(i2, j, i3, str, i4, arrayList, str2, j2, i5, str3, str4, f2, j3, str5, z);
    }
}
