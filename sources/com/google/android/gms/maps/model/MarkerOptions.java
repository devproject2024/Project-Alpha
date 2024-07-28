package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.b.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class MarkerOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    private LatLng f11599a;

    /* renamed from: b  reason: collision with root package name */
    private String f11600b;

    /* renamed from: c  reason: collision with root package name */
    private String f11601c;

    /* renamed from: d  reason: collision with root package name */
    private a f11602d;

    /* renamed from: e  reason: collision with root package name */
    private float f11603e = 0.5f;

    /* renamed from: f  reason: collision with root package name */
    private float f11604f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11605g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11606h = true;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11607i = false;
    private float j = 0.0f;
    private float k = 0.5f;
    private float l = 0.0f;
    private float m = 1.0f;
    private float n;

    public MarkerOptions() {
    }

    MarkerOptions(LatLng latLng, String str, String str2, IBinder iBinder, float f2, float f3, boolean z, boolean z2, boolean z3, float f4, float f5, float f6, float f7, float f8) {
        this.f11599a = latLng;
        this.f11600b = str;
        this.f11601c = str2;
        if (iBinder == null) {
            this.f11602d = null;
        } else {
            this.f11602d = new a(b.a.a(iBinder));
        }
        this.f11603e = f2;
        this.f11604f = f3;
        this.f11605g = z;
        this.f11606h = z2;
        this.f11607i = z3;
        this.j = f4;
        this.k = f5;
        this.l = f6;
        this.m = f7;
        this.n = f8;
    }

    public final MarkerOptions a(LatLng latLng) {
        if (latLng != null) {
            this.f11599a = latLng;
            return this;
        }
        throw new IllegalArgumentException("latlng cannot be null - a position is required.");
    }

    public final MarkerOptions a(a aVar) {
        this.f11602d = aVar;
        return this;
    }

    public final MarkerOptions a(String str) {
        this.f11600b = str;
        return this;
    }

    public final MarkerOptions b(String str) {
        this.f11601c = str;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        IBinder iBinder;
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f11599a, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.f11600b, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.f11601c, false);
        a aVar = this.f11602d;
        if (aVar == null) {
            iBinder = null;
        } else {
            iBinder = aVar.f11663a.asBinder();
        }
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, iBinder);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, this.f11603e);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, this.f11604f);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, this.f11605g);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, this.f11606h);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 10, this.f11607i);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 11, this.j);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 12, this.k);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 13, this.l);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 14, this.m);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 15, this.n);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a2);
    }
}
