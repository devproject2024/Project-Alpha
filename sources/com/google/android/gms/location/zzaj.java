package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new s();

    /* renamed from: a  reason: collision with root package name */
    private final int f11485a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11486b;

    /* renamed from: c  reason: collision with root package name */
    private final long f11487c;

    /* renamed from: d  reason: collision with root package name */
    private final long f11488d;

    zzaj(int i2, int i3, long j, long j2) {
        this.f11485a = i2;
        this.f11486b = i3;
        this.f11487c = j;
        this.f11488d = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaj zzaj = (zzaj) obj;
            return this.f11485a == zzaj.f11485a && this.f11486b == zzaj.f11486b && this.f11487c == zzaj.f11487c && this.f11488d == zzaj.f11488d;
        }
    }

    public final String toString() {
        return "NetworkLocationStatus:" + " Wifi status: " + this.f11485a + " Cell status: " + this.f11486b + " elapsed time NS: " + this.f11488d + " system time ms: " + this.f11487c;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f11485a);
        b.b(parcel, 2, this.f11486b);
        b.a(parcel, 3, this.f11487c);
        b.a(parcel, 4, this.f11488d);
        b.b(parcel, a2);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f11486b), Integer.valueOf(this.f11485a), Long.valueOf(this.f11488d), Long.valueOf(this.f11487c)});
    }
}
