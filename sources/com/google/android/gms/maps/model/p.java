package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class p implements Parcelable.Creator<PolygonOptions> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new PolygonOptions[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a2 = a.a(parcel);
        ArrayList arrayList = new ArrayList();
        ArrayList<LatLng> arrayList2 = null;
        ArrayList<PatternItem> arrayList3 = null;
        float f2 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        float f3 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i4 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    arrayList2 = a.c(parcel2, readInt, LatLng.CREATOR);
                    break;
                case 3:
                    ClassLoader classLoader = getClass().getClassLoader();
                    int a3 = a.a(parcel2, readInt);
                    int dataPosition = parcel.dataPosition();
                    if (a3 == 0) {
                        break;
                    } else {
                        parcel2.readList(arrayList, classLoader);
                        parcel2.setDataPosition(dataPosition + a3);
                        break;
                    }
                case 4:
                    f2 = a.j(parcel2, readInt);
                    break;
                case 5:
                    i2 = a.e(parcel2, readInt);
                    break;
                case 6:
                    i3 = a.e(parcel2, readInt);
                    break;
                case 7:
                    f3 = a.j(parcel2, readInt);
                    break;
                case 8:
                    z = a.c(parcel2, readInt);
                    break;
                case 9:
                    z2 = a.c(parcel2, readInt);
                    break;
                case 10:
                    z3 = a.c(parcel2, readInt);
                    break;
                case 11:
                    i4 = a.e(parcel2, readInt);
                    break;
                case 12:
                    arrayList3 = a.c(parcel2, readInt, PatternItem.CREATOR);
                    break;
                default:
                    a.b(parcel2, readInt);
                    break;
            }
        }
        a.A(parcel2, a2);
        return new PolygonOptions(arrayList2, arrayList, f2, i2, i3, f3, z, z2, z3, i4, arrayList3);
    }
}
