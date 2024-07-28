package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.b.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class GroundOverlayOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private a f11584a;

    /* renamed from: b  reason: collision with root package name */
    private LatLng f11585b;

    /* renamed from: c  reason: collision with root package name */
    private float f11586c;

    /* renamed from: d  reason: collision with root package name */
    private float f11587d;

    /* renamed from: e  reason: collision with root package name */
    private LatLngBounds f11588e;

    /* renamed from: f  reason: collision with root package name */
    private float f11589f;

    /* renamed from: g  reason: collision with root package name */
    private float f11590g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11591h = true;

    /* renamed from: i  reason: collision with root package name */
    private float f11592i = 0.0f;
    private float j = 0.5f;
    private float k = 0.5f;
    private boolean l = false;

    GroundOverlayOptions(IBinder iBinder, LatLng latLng, float f2, float f3, LatLngBounds latLngBounds, float f4, float f5, boolean z, float f6, float f7, float f8, boolean z2) {
        this.f11584a = new a(b.a.a(iBinder));
        this.f11585b = latLng;
        this.f11586c = f2;
        this.f11587d = f3;
        this.f11588e = latLngBounds;
        this.f11589f = f4;
        this.f11590g = f5;
        this.f11591h = z;
        this.f11592i = f6;
        this.j = f7;
        this.k = f8;
        this.l = z2;
    }

    public GroundOverlayOptions() {
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f11584a.f11663a.asBinder());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.f11585b, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.f11586c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.f11587d);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, this.f11588e, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, this.f11589f);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, this.f11590g);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, this.f11591h);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 10, this.f11592i);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 11, this.j);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 12, this.k);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 13, this.l);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a2);
    }
}
