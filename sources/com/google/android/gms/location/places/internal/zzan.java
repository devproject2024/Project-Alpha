package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Collections;
import java.util.List;

public final class zzan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzan> CREATOR = new l();

    /* renamed from: a  reason: collision with root package name */
    private final int f11449a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11450b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11451c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11452d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11453e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11454f;

    /* renamed from: g  reason: collision with root package name */
    private final List<zzao> f11455g;

    zzan(int i2, int i3, int i4, int i5, int i6, int i7, List<zzao> list) {
        this.f11449a = i2;
        this.f11450b = i3;
        this.f11451c = i4;
        this.f11452d = i5;
        this.f11453e = i6;
        this.f11454f = i7;
        this.f11455g = Collections.unmodifiableList(list);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f11449a);
        b.b(parcel, 2, this.f11450b);
        b.b(parcel, 3, this.f11451c);
        b.b(parcel, 4, this.f11452d);
        b.b(parcel, 5, this.f11453e);
        b.b(parcel, 6, this.f11454f);
        b.a(parcel, 7, this.f11455g, false);
        b.b(parcel, a2);
    }
}
