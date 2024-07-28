package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new jw();

    /* renamed from: a  reason: collision with root package name */
    public final String f12380a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12381b;

    /* renamed from: c  reason: collision with root package name */
    public final String f12382c;

    /* renamed from: d  reason: collision with root package name */
    public final String f12383d;

    /* renamed from: e  reason: collision with root package name */
    public final long f12384e;

    /* renamed from: f  reason: collision with root package name */
    public final long f12385f;

    /* renamed from: g  reason: collision with root package name */
    public final String f12386g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f12387h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f12388i;
    public final long j;
    public final String k;
    public final long l;
    public final long m;
    public final int n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final String r;
    public final Boolean s;
    public final long t;
    public final List<String> u;
    public final String v;

    zzm(String str, String str2, String str3, long j2, String str4, long j3, long j4, String str5, boolean z, boolean z2, String str6, long j5, long j6, int i2, boolean z3, boolean z4, boolean z5, String str7, Boolean bool, long j7, List<String> list, String str8) {
        s.a(str);
        this.f12380a = str;
        this.f12381b = TextUtils.isEmpty(str2) ? null : str2;
        this.f12382c = str3;
        this.j = j2;
        this.f12383d = str4;
        this.f12384e = j3;
        this.f12385f = j4;
        this.f12386g = str5;
        this.f12387h = z;
        this.f12388i = z2;
        this.k = str6;
        this.l = j5;
        this.m = j6;
        this.n = i2;
        this.o = z3;
        this.p = z4;
        this.q = z5;
        this.r = str7;
        this.s = bool;
        this.t = j7;
        this.u = list;
        this.v = str8;
    }

    zzm(String str, String str2, String str3, String str4, long j2, long j3, String str5, boolean z, boolean z2, long j4, String str6, long j5, long j6, int i2, boolean z3, boolean z4, boolean z5, String str7, Boolean bool, long j7, List<String> list, String str8) {
        this.f12380a = str;
        this.f12381b = str2;
        this.f12382c = str3;
        this.j = j4;
        this.f12383d = str4;
        this.f12384e = j2;
        this.f12385f = j3;
        this.f12386g = str5;
        this.f12387h = z;
        this.f12388i = z2;
        this.k = str6;
        this.l = j5;
        this.m = j6;
        this.n = i2;
        this.o = z3;
        this.p = z4;
        this.q = z5;
        this.r = str7;
        this.s = bool;
        this.t = j7;
        this.u = list;
        this.v = str8;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f12380a, false);
        b.a(parcel, 3, this.f12381b, false);
        b.a(parcel, 4, this.f12382c, false);
        b.a(parcel, 5, this.f12383d, false);
        b.a(parcel, 6, this.f12384e);
        b.a(parcel, 7, this.f12385f);
        b.a(parcel, 8, this.f12386g, false);
        b.a(parcel, 9, this.f12387h);
        b.a(parcel, 10, this.f12388i);
        b.a(parcel, 11, this.j);
        b.a(parcel, 12, this.k, false);
        b.a(parcel, 13, this.l);
        b.a(parcel, 14, this.m);
        b.b(parcel, 15, this.n);
        b.a(parcel, 16, this.o);
        b.a(parcel, 17, this.p);
        b.a(parcel, 18, this.q);
        b.a(parcel, 19, this.r, false);
        Boolean bool = this.s;
        if (bool != null) {
            b.a(parcel, 21, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        b.a(parcel, 22, this.t);
        b.b(parcel, 23, this.u);
        b.a(parcel, 24, this.v, false);
        b.b(parcel, a2);
    }
}
