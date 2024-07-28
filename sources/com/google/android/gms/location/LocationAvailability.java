package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new j();
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    private int f11336a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    private int f11337b;

    /* renamed from: c  reason: collision with root package name */
    private long f11338c;

    /* renamed from: d  reason: collision with root package name */
    private int f11339d;

    /* renamed from: e  reason: collision with root package name */
    private zzaj[] f11340e;

    LocationAvailability(int i2, int i3, int i4, long j, zzaj[] zzajArr) {
        this.f11339d = i2;
        this.f11336a = i3;
        this.f11337b = i4;
        this.f11338c = j;
        this.f11340e = zzajArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            return this.f11336a == locationAvailability.f11336a && this.f11337b == locationAvailability.f11337b && this.f11338c == locationAvailability.f11338c && this.f11339d == locationAvailability.f11339d && Arrays.equals(this.f11340e, locationAvailability.f11340e);
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f11336a);
        b.b(parcel, 2, this.f11337b);
        b.a(parcel, 3, this.f11338c);
        b.b(parcel, 4, this.f11339d);
        b.a(parcel, 5, (T[]) this.f11340e, i2);
        b.b(parcel, a2);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f11339d), Integer.valueOf(this.f11336a), Integer.valueOf(this.f11337b), Long.valueOf(this.f11338c), this.f11340e});
    }

    public final String toString() {
        boolean z = this.f11339d < 1000;
        StringBuilder sb = new StringBuilder(48);
        sb.append("LocationAvailability[isLocationAvailable: ");
        sb.append(z);
        sb.append("]");
        return sb.toString();
    }
}
