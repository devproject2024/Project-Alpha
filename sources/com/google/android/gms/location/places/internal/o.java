package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;
import java.util.Locale;

public final class o extends g<r> {

    /* renamed from: a  reason: collision with root package name */
    private final zzau f11439a;

    private o(Context context, Looper looper, d dVar, e.b bVar, e.c cVar, String str) {
        super(context, looper, 65, dVar, bVar, cVar);
        this.f11439a = new zzau(str, Locale.getDefault(), dVar.f8816a != null ? dVar.f8816a.name : null);
    }

    public final String a() {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    public final String b() {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }

    public final int e() {
        return h.f8688b;
    }

    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (queryLocalInterface instanceof r) {
            return (r) queryLocalInterface;
        }
        return new t(iBinder);
    }

    /* synthetic */ o(Context context, Looper looper, d dVar, e.b bVar, e.c cVar, String str, byte b2) {
        this(context, looper, dVar, bVar, cVar, str);
    }
}
