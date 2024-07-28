package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.List;

public final class PolylineOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    private final List<LatLng> f11623a;

    /* renamed from: b  reason: collision with root package name */
    private float f11624b;

    /* renamed from: c  reason: collision with root package name */
    private int f11625c;

    /* renamed from: d  reason: collision with root package name */
    private float f11626d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11627e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11628f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11629g;

    /* renamed from: h  reason: collision with root package name */
    private Cap f11630h;

    /* renamed from: i  reason: collision with root package name */
    private Cap f11631i;
    private int j;
    private List<PatternItem> k;

    public PolylineOptions() {
        this.f11624b = 10.0f;
        this.f11625c = -16777216;
        this.f11626d = 0.0f;
        this.f11627e = true;
        this.f11628f = false;
        this.f11629g = false;
        this.f11630h = new ButtCap();
        this.f11631i = new ButtCap();
        this.j = 0;
        this.k = null;
        this.f11623a = new ArrayList();
    }

    PolylineOptions(List list, float f2, int i2, float f3, boolean z, boolean z2, boolean z3, Cap cap, Cap cap2, int i3, List<PatternItem> list2) {
        this.f11624b = 10.0f;
        this.f11625c = -16777216;
        this.f11626d = 0.0f;
        this.f11627e = true;
        this.f11628f = false;
        this.f11629g = false;
        this.f11630h = new ButtCap();
        this.f11631i = new ButtCap();
        this.j = 0;
        this.k = null;
        this.f11623a = list;
        this.f11624b = f2;
        this.f11625c = i2;
        this.f11626d = f3;
        this.f11627e = z;
        this.f11628f = z2;
        this.f11629g = z3;
        if (cap != null) {
            this.f11630h = cap;
        }
        if (cap2 != null) {
            this.f11631i = cap2;
        }
        this.j = i3;
        this.k = list2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f11623a, false);
        b.a(parcel, 3, this.f11624b);
        b.b(parcel, 4, this.f11625c);
        b.a(parcel, 5, this.f11626d);
        b.a(parcel, 6, this.f11627e);
        b.a(parcel, 7, this.f11628f);
        b.a(parcel, 8, this.f11629g);
        b.a(parcel, 9, this.f11630h, i2, false);
        b.a(parcel, 10, this.f11631i, i2, false);
        b.b(parcel, 11, this.j);
        b.a(parcel, 12, this.k, false);
        b.b(parcel, a2);
    }
}
