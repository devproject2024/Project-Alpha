package com.google.android.gms.internal.a;

import android.os.Parcel;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final ClassLoader f9064a = c.class.getClassLoader();

    private c() {
    }

    public static boolean a(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static void b(Parcel parcel) {
        parcel.writeInt(1);
    }
}
