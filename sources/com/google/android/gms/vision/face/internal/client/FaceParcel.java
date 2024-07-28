package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class FaceParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FaceParcel> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    public final int f12631a;

    /* renamed from: b  reason: collision with root package name */
    public final float f12632b;

    /* renamed from: c  reason: collision with root package name */
    public final float f12633c;

    /* renamed from: d  reason: collision with root package name */
    public final float f12634d;

    /* renamed from: e  reason: collision with root package name */
    public final float f12635e;

    /* renamed from: f  reason: collision with root package name */
    public final float f12636f;

    /* renamed from: g  reason: collision with root package name */
    public final float f12637g;

    /* renamed from: h  reason: collision with root package name */
    public final float f12638h;

    /* renamed from: i  reason: collision with root package name */
    public final LandmarkParcel[] f12639i;
    public final float j;
    public final float k;
    public final float l;
    public final zza[] m;
    public final float n;
    private final int o;

    public FaceParcel(int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, float f8, LandmarkParcel[] landmarkParcelArr, float f9, float f10, float f11, zza[] zzaArr, float f12) {
        this.o = i2;
        this.f12631a = i3;
        this.f12632b = f2;
        this.f12633c = f3;
        this.f12634d = f4;
        this.f12635e = f5;
        this.f12636f = f6;
        this.f12637g = f7;
        this.f12638h = f8;
        this.f12639i = landmarkParcelArr;
        this.j = f9;
        this.k = f10;
        this.l = f11;
        this.m = zzaArr;
        this.n = f12;
    }

    public FaceParcel(int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, LandmarkParcel[] landmarkParcelArr, float f8, float f9, float f10) {
        this(i2, i3, f2, f3, f4, f5, f6, f7, 0.0f, landmarkParcelArr, f8, f9, f10, new zza[0], -1.0f);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.o);
        b.b(parcel, 2, this.f12631a);
        b.a(parcel, 3, this.f12632b);
        b.a(parcel, 4, this.f12633c);
        b.a(parcel, 5, this.f12634d);
        b.a(parcel, 6, this.f12635e);
        b.a(parcel, 7, this.f12636f);
        b.a(parcel, 8, this.f12637g);
        b.a(parcel, 9, (T[]) this.f12639i, i2);
        b.a(parcel, 10, this.j);
        b.a(parcel, 11, this.k);
        b.a(parcel, 12, this.l);
        b.a(parcel, 13, (T[]) this.m, i2);
        b.a(parcel, 14, this.f12638h);
        b.a(parcel, 15, this.n);
        b.b(parcel, a2);
    }
}
