package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    public final zzaj[] f11283a;

    /* renamed from: b  reason: collision with root package name */
    public final zzw f11284b;

    /* renamed from: c  reason: collision with root package name */
    public final String f11285c;

    /* renamed from: d  reason: collision with root package name */
    public final String f11286d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f11287e;

    /* renamed from: f  reason: collision with root package name */
    public final int f11288f;

    /* renamed from: g  reason: collision with root package name */
    public final int f11289g;

    /* renamed from: h  reason: collision with root package name */
    private final zzw f11290h;

    /* renamed from: i  reason: collision with root package name */
    private final zzw f11291i;
    private final float j;
    private final int k;

    public zzac(zzaj[] zzajArr, zzw zzw, zzw zzw2, zzw zzw3, String str, float f2, String str2, int i2, boolean z, int i3, int i4) {
        this.f11283a = zzajArr;
        this.f11284b = zzw;
        this.f11290h = zzw2;
        this.f11291i = zzw3;
        this.f11285c = str;
        this.j = f2;
        this.f11286d = str2;
        this.k = i2;
        this.f11287e = z;
        this.f11288f = i3;
        this.f11289g = i4;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, (T[]) this.f11283a, i2);
        b.a(parcel, 3, this.f11284b, i2, false);
        b.a(parcel, 4, this.f11290h, i2, false);
        b.a(parcel, 5, this.f11291i, i2, false);
        b.a(parcel, 6, this.f11285c, false);
        b.a(parcel, 7, this.j);
        b.a(parcel, 8, this.f11286d, false);
        b.b(parcel, 9, this.k);
        b.a(parcel, 10, this.f11287e);
        b.b(parcel, 11, this.f11288f);
        b.b(parcel, 12, this.f11289g);
        b.b(parcel, a2);
    }
}
