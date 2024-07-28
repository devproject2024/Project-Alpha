package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.b.d;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new x();

    /* renamed from: a  reason: collision with root package name */
    private final String f9004a;

    /* renamed from: b  reason: collision with root package name */
    private final o f9005b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9006c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f9007d;

    zzj(String str, IBinder iBinder, boolean z, boolean z2) {
        this.f9004a = str;
        this.f9005b = a(iBinder);
        this.f9006c = z;
        this.f9007d = z2;
    }

    zzj(String str, o oVar, boolean z, boolean z2) {
        this.f9004a = str;
        this.f9005b = oVar;
        this.f9006c = z;
        this.f9007d = z2;
    }

    private static o a(IBinder iBinder) {
        byte[] bArr;
        if (iBinder == null) {
            return null;
        }
        try {
            b a2 = ar.a(iBinder).a();
            if (a2 == null) {
                bArr = null;
            } else {
                bArr = (byte[]) d.a(a2);
            }
            if (bArr != null) {
                return new s(bArr);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        IBinder iBinder;
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f9004a, false);
        o oVar = this.f9005b;
        if (oVar == null) {
            iBinder = null;
        } else {
            iBinder = oVar.asBinder();
        }
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, iBinder);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.f9006c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.f9007d);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a2);
    }
}
