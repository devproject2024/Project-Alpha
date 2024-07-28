package com.google.android.gms.internal.g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final ClassLoader f10039a = c.class.getClassLoader();

    private c() {
    }

    public static boolean a(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static void a(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static void a(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder((IBinder) null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }
}
