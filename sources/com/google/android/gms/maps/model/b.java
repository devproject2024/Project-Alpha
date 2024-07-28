package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.h.h;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static h f11664a;

    public static a a(Bitmap bitmap) {
        try {
            return new a(((h) s.a(f11664a, (Object) "IBitmapDescriptorFactory is not initialized")).a(bitmap));
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }
}
