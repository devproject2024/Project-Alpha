package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new kf();

    /* renamed from: a  reason: collision with root package name */
    public String f12389a;

    /* renamed from: b  reason: collision with root package name */
    public String f12390b;

    /* renamed from: c  reason: collision with root package name */
    public zzkl f12391c;

    /* renamed from: d  reason: collision with root package name */
    public long f12392d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12393e;

    /* renamed from: f  reason: collision with root package name */
    public String f12394f;

    /* renamed from: g  reason: collision with root package name */
    public zzan f12395g;

    /* renamed from: h  reason: collision with root package name */
    public long f12396h;

    /* renamed from: i  reason: collision with root package name */
    public zzan f12397i;
    public long j;
    public zzan k;

    zzv(zzv zzv) {
        s.a(zzv);
        this.f12389a = zzv.f12389a;
        this.f12390b = zzv.f12390b;
        this.f12391c = zzv.f12391c;
        this.f12392d = zzv.f12392d;
        this.f12393e = zzv.f12393e;
        this.f12394f = zzv.f12394f;
        this.f12395g = zzv.f12395g;
        this.f12396h = zzv.f12396h;
        this.f12397i = zzv.f12397i;
        this.j = zzv.j;
        this.k = zzv.k;
    }

    zzv(String str, String str2, zzkl zzkl, long j2, boolean z, String str3, zzan zzan, long j3, zzan zzan2, long j4, zzan zzan3) {
        this.f12389a = str;
        this.f12390b = str2;
        this.f12391c = zzkl;
        this.f12392d = j2;
        this.f12393e = z;
        this.f12394f = str3;
        this.f12395g = zzan;
        this.f12396h = j3;
        this.f12397i = zzan2;
        this.j = j4;
        this.k = zzan3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f12389a, false);
        b.a(parcel, 3, this.f12390b, false);
        b.a(parcel, 4, this.f12391c, i2, false);
        b.a(parcel, 5, this.f12392d);
        b.a(parcel, 6, this.f12393e);
        b.a(parcel, 7, this.f12394f, false);
        b.a(parcel, 8, this.f12395g, i2, false);
        b.a(parcel, 9, this.f12396h);
        b.a(parcel, 10, this.f12397i, i2, false);
        b.a(parcel, 11, this.j);
        b.a(parcel, 12, this.k, i2, false);
        b.b(parcel, a2);
    }
}
