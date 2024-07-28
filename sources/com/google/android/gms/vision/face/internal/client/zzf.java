package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    public int f12646a;

    /* renamed from: b  reason: collision with root package name */
    public int f12647b;

    /* renamed from: c  reason: collision with root package name */
    public int f12648c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12649d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12650e;

    /* renamed from: f  reason: collision with root package name */
    public float f12651f;

    public zzf() {
    }

    public zzf(int i2, int i3, int i4, boolean z, boolean z2, float f2) {
        this.f12646a = i2;
        this.f12647b = i3;
        this.f12648c = i4;
        this.f12649d = z;
        this.f12650e = z2;
        this.f12651f = f2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 2, this.f12646a);
        b.b(parcel, 3, this.f12647b);
        b.b(parcel, 4, this.f12648c);
        b.a(parcel, 5, this.f12649d);
        b.a(parcel, 6, this.f12650e);
        b.a(parcel, 7, this.f12651f);
        b.b(parcel, a2);
    }
}
