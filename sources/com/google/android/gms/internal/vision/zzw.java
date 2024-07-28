package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new ie();

    /* renamed from: a  reason: collision with root package name */
    public final int f11307a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11308b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11309c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11310d;

    /* renamed from: e  reason: collision with root package name */
    public final float f11311e;

    public zzw(int i2, int i3, int i4, int i5, float f2) {
        this.f11307a = i2;
        this.f11308b = i3;
        this.f11309c = i4;
        this.f11310d = i5;
        this.f11311e = f2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 2, this.f11307a);
        b.b(parcel, 3, this.f11308b);
        b.b(parcel, 4, this.f11309c);
        b.b(parcel, 5, this.f11310d);
        b.a(parcel, 6, this.f11311e);
        b.b(parcel, a2);
    }
}
