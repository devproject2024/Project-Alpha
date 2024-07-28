package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new ml();

    /* renamed from: a  reason: collision with root package name */
    public final long f10959a;

    /* renamed from: b  reason: collision with root package name */
    public final long f10960b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f10961c;

    /* renamed from: d  reason: collision with root package name */
    public final String f10962d;

    /* renamed from: e  reason: collision with root package name */
    public final String f10963e;

    /* renamed from: f  reason: collision with root package name */
    public final String f10964f;

    /* renamed from: g  reason: collision with root package name */
    public final Bundle f10965g;

    public zzv(long j, long j2, boolean z, String str, String str2, String str3, Bundle bundle) {
        this.f10959a = j;
        this.f10960b = j2;
        this.f10961c = z;
        this.f10962d = str;
        this.f10963e = str2;
        this.f10964f = str3;
        this.f10965g = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f10959a);
        b.a(parcel, 2, this.f10960b);
        b.a(parcel, 3, this.f10961c);
        b.a(parcel, 4, this.f10962d, false);
        b.a(parcel, 5, this.f10963e, false);
        b.a(parcel, 6, this.f10964f, false);
        b.a(parcel, 7, this.f10965g);
        b.b(parcel, a2);
    }
}
