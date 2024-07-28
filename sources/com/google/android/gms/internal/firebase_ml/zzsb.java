package com.google.android.gms.internal.firebase_ml;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzsb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsb> CREATOR = new em();

    /* renamed from: a  reason: collision with root package name */
    public final int f10031a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10032b;

    /* renamed from: c  reason: collision with root package name */
    public final long f10033c;

    /* renamed from: d  reason: collision with root package name */
    public final int f10034d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10035e;

    public zzsb(int i2, int i3, int i4, long j, int i5) {
        this.f10031a = i2;
        this.f10032b = i3;
        this.f10035e = i4;
        this.f10033c = j;
        this.f10034d = i5;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f10031a);
        b.b(parcel, 2, this.f10032b);
        b.b(parcel, 3, this.f10035e);
        b.a(parcel, 4, this.f10033c);
        b.b(parcel, 5, this.f10034d);
        b.b(parcel, a2);
    }
}
