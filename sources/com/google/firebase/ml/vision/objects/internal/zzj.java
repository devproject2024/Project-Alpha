package com.google.firebase.ml.vision.objects.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    public final int[] f39172a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f39173b;

    /* renamed from: c  reason: collision with root package name */
    public final Float f39174c;

    /* renamed from: d  reason: collision with root package name */
    public final int f39175d;

    /* renamed from: e  reason: collision with root package name */
    private final String f39176e;

    public zzj(int[] iArr, Integer num, Float f2, String str, int i2) {
        this.f39172a = iArr;
        this.f39173b = num;
        this.f39174c = f2;
        this.f39176e = str;
        this.f39175d = i2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f39172a);
        b.a(parcel, 2, this.f39173b);
        b.a(parcel, 3, this.f39174c);
        b.a(parcel, 4, this.f39176e, false);
        b.b(parcel, 5, this.f39175d);
        b.b(parcel, a2);
    }
}
