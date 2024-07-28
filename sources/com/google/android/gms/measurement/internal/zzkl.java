package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzkl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzkl> CREATOR = new jp();

    /* renamed from: a  reason: collision with root package name */
    public final String f12372a;

    /* renamed from: b  reason: collision with root package name */
    public final long f12373b;

    /* renamed from: c  reason: collision with root package name */
    public final Long f12374c;

    /* renamed from: d  reason: collision with root package name */
    public final String f12375d;

    /* renamed from: e  reason: collision with root package name */
    public final String f12376e;

    /* renamed from: f  reason: collision with root package name */
    public final Double f12377f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12378g;

    /* renamed from: h  reason: collision with root package name */
    private final Float f12379h;

    zzkl(jr jrVar) {
        this(jrVar.f12291c, jrVar.f12292d, jrVar.f12293e, jrVar.f12290b);
    }

    zzkl(String str, long j, Object obj, String str2) {
        s.a(str);
        this.f12378g = 2;
        this.f12372a = str;
        this.f12373b = j;
        this.f12376e = str2;
        if (obj == null) {
            this.f12374c = null;
            this.f12379h = null;
            this.f12377f = null;
            this.f12375d = null;
        } else if (obj instanceof Long) {
            this.f12374c = (Long) obj;
            this.f12379h = null;
            this.f12377f = null;
            this.f12375d = null;
        } else if (obj instanceof String) {
            this.f12374c = null;
            this.f12379h = null;
            this.f12377f = null;
            this.f12375d = (String) obj;
        } else if (obj instanceof Double) {
            this.f12374c = null;
            this.f12379h = null;
            this.f12377f = (Double) obj;
            this.f12375d = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    zzkl(String str) {
        s.a(str);
        this.f12378g = 2;
        this.f12372a = str;
        this.f12373b = 0;
        this.f12374c = null;
        this.f12379h = null;
        this.f12377f = null;
        this.f12375d = null;
        this.f12376e = null;
    }

    zzkl(int i2, String str, long j, Long l, Float f2, String str2, String str3, Double d2) {
        this.f12378g = i2;
        this.f12372a = str;
        this.f12373b = j;
        this.f12374c = l;
        Double d3 = null;
        this.f12379h = null;
        if (i2 == 1) {
            this.f12377f = f2 != null ? Double.valueOf(f2.doubleValue()) : d3;
        } else {
            this.f12377f = d2;
        }
        this.f12375d = str2;
        this.f12376e = str3;
    }

    public final Object a() {
        Long l = this.f12374c;
        if (l != null) {
            return l;
        }
        Double d2 = this.f12377f;
        if (d2 != null) {
            return d2;
        }
        String str = this.f12375d;
        if (str != null) {
            return str;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f12378g);
        b.a(parcel, 2, this.f12372a, false);
        b.a(parcel, 3, this.f12373b);
        b.a(parcel, 4, this.f12374c);
        b.a(parcel, 5, (Float) null);
        b.a(parcel, 6, this.f12375d, false);
        b.a(parcel, 7, this.f12376e, false);
        Double d2 = this.f12377f;
        if (d2 != null) {
            b.a(parcel, 8, 8);
            parcel.writeDouble(d2.doubleValue());
        }
        b.b(parcel, a2);
    }
}
