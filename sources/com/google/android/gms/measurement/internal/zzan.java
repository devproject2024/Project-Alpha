package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzan> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    public final String f12368a;

    /* renamed from: b  reason: collision with root package name */
    public final zzam f12369b;

    /* renamed from: c  reason: collision with root package name */
    public final String f12370c;

    /* renamed from: d  reason: collision with root package name */
    public final long f12371d;

    public zzan(String str, zzam zzam, String str2, long j) {
        this.f12368a = str;
        this.f12369b = zzam;
        this.f12370c = str2;
        this.f12371d = j;
    }

    zzan(zzan zzan, long j) {
        s.a(zzan);
        this.f12368a = zzan.f12368a;
        this.f12369b = zzan.f12369b;
        this.f12370c = zzan.f12370c;
        this.f12371d = j;
    }

    public final String toString() {
        String str = this.f12370c;
        String str2 = this.f12368a;
        String valueOf = String.valueOf(this.f12369b);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f12368a, false);
        b.a(parcel, 3, this.f12369b, i2, false);
        b.a(parcel, 4, this.f12370c, false);
        b.a(parcel, 5, this.f12371d);
        b.b(parcel, a2);
    }
}
