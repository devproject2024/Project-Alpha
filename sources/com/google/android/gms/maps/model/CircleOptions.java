package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public final class CircleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CircleOptions> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private LatLng f11571a = null;

    /* renamed from: b  reason: collision with root package name */
    private double f11572b = 0.0d;

    /* renamed from: c  reason: collision with root package name */
    private float f11573c = 10.0f;

    /* renamed from: d  reason: collision with root package name */
    private int f11574d = -16777216;

    /* renamed from: e  reason: collision with root package name */
    private int f11575e = 0;

    /* renamed from: f  reason: collision with root package name */
    private float f11576f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11577g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11578h = false;

    /* renamed from: i  reason: collision with root package name */
    private List<PatternItem> f11579i = null;

    public CircleOptions() {
    }

    CircleOptions(LatLng latLng, double d2, float f2, int i2, int i3, float f3, boolean z, boolean z2, List<PatternItem> list) {
        this.f11571a = latLng;
        this.f11572b = d2;
        this.f11573c = f2;
        this.f11574d = i2;
        this.f11575e = i3;
        this.f11576f = f3;
        this.f11577g = z;
        this.f11578h = z2;
        this.f11579i = list;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f11571a, i2, false);
        b.a(parcel, 3, this.f11572b);
        b.a(parcel, 4, this.f11573c);
        b.b(parcel, 5, this.f11574d);
        b.b(parcel, 6, this.f11575e);
        b.a(parcel, 7, this.f11576f);
        b.a(parcel, 8, this.f11577g);
        b.a(parcel, 9, this.f11578h);
        b.a(parcel, 10, this.f11579i, false);
        b.b(parcel, a2);
    }
}
