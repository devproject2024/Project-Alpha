package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.al;
import com.google.android.gms.location.am;
import com.google.android.gms.location.ao;
import com.google.android.gms.location.ap;

public final class zzbf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbf> CREATOR = new x();

    /* renamed from: a  reason: collision with root package name */
    private int f10410a;

    /* renamed from: b  reason: collision with root package name */
    private zzbd f10411b;

    /* renamed from: c  reason: collision with root package name */
    private ao f10412c;

    /* renamed from: d  reason: collision with root package name */
    private PendingIntent f10413d;

    /* renamed from: e  reason: collision with root package name */
    private al f10414e;

    /* renamed from: f  reason: collision with root package name */
    private f f10415f;

    public zzbf(int i2, zzbd zzbd, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        this.f10410a = i2;
        this.f10411b = zzbd;
        f fVar = null;
        this.f10412c = iBinder == null ? null : ap.a(iBinder);
        this.f10413d = pendingIntent;
        this.f10414e = iBinder2 == null ? null : am.a(iBinder2);
        if (!(iBinder3 == null || iBinder3 == null)) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            fVar = queryLocalInterface instanceof f ? (f) queryLocalInterface : new h(iBinder3);
        }
        this.f10415f = fVar;
    }

    public static zzbf a(al alVar, f fVar) {
        return new zzbf(2, (zzbd) null, (IBinder) null, (PendingIntent) null, alVar.asBinder(), fVar != null ? fVar.asBinder() : null);
    }

    public static zzbf a(ao aoVar, f fVar) {
        return new zzbf(2, (zzbd) null, aoVar.asBinder(), (PendingIntent) null, (IBinder) null, fVar != null ? fVar.asBinder() : null);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f10410a);
        b.a(parcel, 2, this.f10411b, i2, false);
        ao aoVar = this.f10412c;
        IBinder iBinder = null;
        b.a(parcel, 3, aoVar == null ? null : aoVar.asBinder());
        b.a(parcel, 4, this.f10413d, i2, false);
        al alVar = this.f10414e;
        b.a(parcel, 5, alVar == null ? null : alVar.asBinder());
        f fVar = this.f10415f;
        if (fVar != null) {
            iBinder = fVar.asBinder();
        }
        b.a(parcel, 6, iBinder);
        b.b(parcel, a2);
    }
}
