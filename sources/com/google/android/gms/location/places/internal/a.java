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

public final class a extends g<p> {

    /* renamed from: a  reason: collision with root package name */
    private final zzau f11437a;
    private final Locale j;

    private a(Context context, Looper looper, d dVar, e.b bVar, e.c cVar, String str) {
        super(context, looper, 67, dVar, bVar, cVar);
        this.j = Locale.getDefault();
        this.f11437a = new zzau(str, this.j, dVar.f8816a != null ? dVar.f8816a.name : null);
    }

    public final String a() {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }

    public final String b() {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }

    public final int e() {
        return h.f8688b;
    }

    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
        if (queryLocalInterface instanceof p) {
            return (p) queryLocalInterface;
        }
        return new s(iBinder);
    }

    /* synthetic */ a(Context context, Looper looper, d dVar, e.b bVar, e.c cVar, String str, byte b2) {
        this(context, looper, dVar, bVar, cVar, str);
    }
}
