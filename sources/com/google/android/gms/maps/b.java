package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.maps.a.a;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.d;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static a f11544a;

    private static a a() {
        return (a) s.a(f11544a, (Object) "CameraUpdateFactory is not initialized");
    }

    public static a a(CameraPosition cameraPosition) {
        try {
            return new a(a().a(cameraPosition));
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }

    public static a a(LatLng latLng, float f2) {
        try {
            return new a(a().a(latLng, f2));
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }
}
