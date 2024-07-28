package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.ai;
import com.google.android.gms.location.aj;

public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new ai();

    /* renamed from: a  reason: collision with root package name */
    private int f10430a;

    /* renamed from: b  reason: collision with root package name */
    private zzm f10431b;

    /* renamed from: c  reason: collision with root package name */
    private ai f10432c;

    /* renamed from: d  reason: collision with root package name */
    private f f10433d;

    zzo(int i2, zzm zzm, IBinder iBinder, IBinder iBinder2) {
        this.f10430a = i2;
        this.f10431b = zzm;
        f fVar = null;
        this.f10432c = iBinder == null ? null : aj.a(iBinder);
        if (!(iBinder2 == null || iBinder2 == null)) {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            fVar = queryLocalInterface instanceof f ? (f) queryLocalInterface : new h(iBinder2);
        }
        this.f10433d = fVar;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f10430a);
        b.a(parcel, 2, this.f10431b, i2, false);
        ai aiVar = this.f10432c;
        IBinder iBinder = null;
        b.a(parcel, 3, aiVar == null ? null : aiVar.asBinder());
        f fVar = this.f10433d;
        if (fVar != null) {
            iBinder = fVar.asBinder();
        }
        b.a(parcel, 4, iBinder);
        b.b(parcel, a2);
    }
}
