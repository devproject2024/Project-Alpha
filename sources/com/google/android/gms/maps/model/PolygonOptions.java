package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.List;

public final class PolygonOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolygonOptions> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    private final List<LatLng> f11614a;

    /* renamed from: b  reason: collision with root package name */
    private final List<List<LatLng>> f11615b;

    /* renamed from: c  reason: collision with root package name */
    private float f11616c;

    /* renamed from: d  reason: collision with root package name */
    private int f11617d;

    /* renamed from: e  reason: collision with root package name */
    private int f11618e;

    /* renamed from: f  reason: collision with root package name */
    private float f11619f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11620g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11621h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11622i;
    private int j;
    private List<PatternItem> k;

    public PolygonOptions() {
        this.f11616c = 10.0f;
        this.f11617d = -16777216;
        this.f11618e = 0;
        this.f11619f = 0.0f;
        this.f11620g = true;
        this.f11621h = false;
        this.f11622i = false;
        this.j = 0;
        this.k = null;
        this.f11614a = new ArrayList();
        this.f11615b = new ArrayList();
    }

    PolygonOptions(List<LatLng> list, List list2, float f2, int i2, int i3, float f3, boolean z, boolean z2, boolean z3, int i4, List<PatternItem> list3) {
        this.f11616c = 10.0f;
        this.f11617d = -16777216;
        this.f11618e = 0;
        this.f11619f = 0.0f;
        this.f11620g = true;
        this.f11621h = false;
        this.f11622i = false;
        this.j = 0;
        this.k = null;
        this.f11614a = list;
        this.f11615b = list2;
        this.f11616c = f2;
        this.f11617d = i2;
        this.f11618e = i3;
        this.f11619f = f3;
        this.f11620g = z;
        this.f11621h = z2;
        this.f11622i = z3;
        this.j = i4;
        this.k = list3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f11614a, false);
        List<List<LatLng>> list = this.f11615b;
        if (list != null) {
            int a3 = b.a(parcel, 3);
            parcel.writeList(list);
            b.b(parcel, a3);
        }
        b.a(parcel, 4, this.f11616c);
        b.b(parcel, 5, this.f11617d);
        b.b(parcel, 6, this.f11618e);
        b.a(parcel, 7, this.f11619f);
        b.a(parcel, 8, this.f11620g);
        b.a(parcel, 9, this.f11621h);
        b.a(parcel, 10, this.f11622i);
        b.b(parcel, 11, this.j);
        b.a(parcel, 12, this.k, false);
        b.b(parcel, a2);
    }
}
