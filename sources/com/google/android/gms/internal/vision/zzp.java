package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.vision.b;

public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR = new ic();

    /* renamed from: a  reason: collision with root package name */
    public int f11302a;

    /* renamed from: b  reason: collision with root package name */
    public int f11303b;

    /* renamed from: c  reason: collision with root package name */
    public int f11304c;

    /* renamed from: d  reason: collision with root package name */
    public long f11305d;

    /* renamed from: e  reason: collision with root package name */
    public int f11306e;

    public zzp() {
    }

    public zzp(int i2, int i3, int i4, long j, int i5) {
        this.f11302a = i2;
        this.f11303b = i3;
        this.f11304c = i4;
        this.f11305d = j;
        this.f11306e = i5;
    }

    public static zzp a(b bVar) {
        zzp zzp = new zzp();
        zzp.f11302a = bVar.f12542a.f12546a;
        zzp.f11303b = bVar.f12542a.f12547b;
        zzp.f11306e = bVar.f12542a.f12550e;
        zzp.f11304c = bVar.f12542a.f12548c;
        zzp.f11305d = bVar.f12542a.f12549d;
        return zzp;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 2, this.f11302a);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 3, this.f11303b);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 4, this.f11304c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.f11305d);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 6, this.f11306e);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a2);
    }
}
