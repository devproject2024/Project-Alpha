package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    public final zzw f11293a;

    /* renamed from: b  reason: collision with root package name */
    public final String f11294b;

    /* renamed from: c  reason: collision with root package name */
    public final String f11295c;

    /* renamed from: d  reason: collision with root package name */
    private final zzag[] f11296d;

    /* renamed from: e  reason: collision with root package name */
    private final zzw f11297e;

    /* renamed from: f  reason: collision with root package name */
    private final float f11298f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f11299g;

    public zzaj(zzag[] zzagArr, zzw zzw, zzw zzw2, String str, float f2, String str2, boolean z) {
        this.f11296d = zzagArr;
        this.f11293a = zzw;
        this.f11297e = zzw2;
        this.f11294b = str;
        this.f11298f = f2;
        this.f11295c = str2;
        this.f11299g = z;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, (T[]) this.f11296d, i2);
        b.a(parcel, 3, this.f11293a, i2, false);
        b.a(parcel, 4, this.f11297e, i2, false);
        b.a(parcel, 5, this.f11294b, false);
        b.a(parcel, 6, this.f11298f);
        b.a(parcel, 7, this.f11295c, false);
        b.a(parcel, 8, this.f11299g);
        b.b(parcel, a2);
    }
}
