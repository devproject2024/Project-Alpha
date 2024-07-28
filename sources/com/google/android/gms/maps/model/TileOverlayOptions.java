package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.h.b;
import com.google.android.gms.internal.h.c;

public final class TileOverlayOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new y();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public b f11652a;

    /* renamed from: b  reason: collision with root package name */
    private e f11653b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11654c = true;

    /* renamed from: d  reason: collision with root package name */
    private float f11655d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11656e = true;

    /* renamed from: f  reason: collision with root package name */
    private float f11657f = 0.0f;

    public TileOverlayOptions() {
    }

    TileOverlayOptions(IBinder iBinder, boolean z, float f2, boolean z2, float f3) {
        x xVar;
        this.f11652a = c.a(iBinder);
        if (this.f11652a == null) {
            xVar = null;
        } else {
            xVar = new x(this);
        }
        this.f11653b = xVar;
        this.f11654c = z;
        this.f11655d = f2;
        this.f11656e = z2;
        this.f11657f = f3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f11652a.asBinder());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.f11654c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.f11655d);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.f11656e);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, this.f11657f);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a2);
    }
}
