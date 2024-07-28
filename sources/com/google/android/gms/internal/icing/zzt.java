package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzt> CREATOR = new fq();

    /* renamed from: a  reason: collision with root package name */
    private final String f10315a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10316b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f10317c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10318d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f10319e;

    /* renamed from: f  reason: collision with root package name */
    private final String f10320f;

    /* renamed from: g  reason: collision with root package name */
    private final zzm[] f10321g;

    /* renamed from: h  reason: collision with root package name */
    private final String f10322h;

    /* renamed from: i  reason: collision with root package name */
    private final zzu f10323i;

    zzt(String str, String str2, boolean z, int i2, boolean z2, String str3, zzm[] zzmArr, String str4, zzu zzu) {
        this.f10315a = str;
        this.f10316b = str2;
        this.f10317c = z;
        this.f10318d = i2;
        this.f10319e = z2;
        this.f10320f = str3;
        this.f10321g = zzmArr;
        this.f10322h = str4;
        this.f10323i = zzu;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10315a, this.f10316b, Boolean.valueOf(this.f10317c), Integer.valueOf(this.f10318d), Boolean.valueOf(this.f10319e), this.f10320f, Integer.valueOf(Arrays.hashCode(this.f10321g)), this.f10322h, this.f10323i});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzt)) {
            return false;
        }
        zzt zzt = (zzt) obj;
        return this.f10317c == zzt.f10317c && this.f10318d == zzt.f10318d && this.f10319e == zzt.f10319e && q.a(this.f10315a, zzt.f10315a) && q.a(this.f10316b, zzt.f10316b) && q.a(this.f10320f, zzt.f10320f) && q.a(this.f10322h, zzt.f10322h) && q.a(this.f10323i, zzt.f10323i) && Arrays.equals(this.f10321g, zzt.f10321g);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f10315a, false);
        b.a(parcel, 2, this.f10316b, false);
        b.a(parcel, 3, this.f10317c);
        b.b(parcel, 4, this.f10318d);
        b.a(parcel, 5, this.f10319e);
        b.a(parcel, 6, this.f10320f, false);
        b.a(parcel, 7, (T[]) this.f10321g, i2);
        b.a(parcel, 11, this.f10322h, false);
        b.a(parcel, 12, this.f10323i, i2, false);
        b.b(parcel, a2);
    }
}
