package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new ac();

    /* renamed from: a  reason: collision with root package name */
    private boolean f11492a;

    /* renamed from: b  reason: collision with root package name */
    private long f11493b;

    /* renamed from: c  reason: collision with root package name */
    private float f11494c;

    /* renamed from: d  reason: collision with root package name */
    private long f11495d;

    /* renamed from: e  reason: collision with root package name */
    private int f11496e;

    public zzj() {
        this(true, 50, 0.0f, Long.MAX_VALUE, Integer.MAX_VALUE);
    }

    zzj(boolean z, long j, float f2, long j2, int i2) {
        this.f11492a = z;
        this.f11493b = j;
        this.f11494c = f2;
        this.f11495d = j2;
        this.f11496e = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzj = (zzj) obj;
        return this.f11492a == zzj.f11492a && this.f11493b == zzj.f11493b && Float.compare(this.f11494c, zzj.f11494c) == 0 && this.f11495d == zzj.f11495d && this.f11496e == zzj.f11496e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceOrientationRequest[mShouldUseMag=");
        sb.append(this.f11492a);
        sb.append(" mMinimumSamplingPeriodMs=");
        sb.append(this.f11493b);
        sb.append(" mSmallestAngleChangeRadians=");
        sb.append(this.f11494c);
        long j = this.f11495d;
        if (j != Long.MAX_VALUE) {
            sb.append(" expireIn=");
            sb.append(j - SystemClock.elapsedRealtime());
            sb.append("ms");
        }
        if (this.f11496e != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f11496e);
        }
        sb.append(']');
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11492a);
        b.a(parcel, 2, this.f11493b);
        b.a(parcel, 3, this.f11494c);
        b.a(parcel, 4, this.f11495d);
        b.b(parcel, 5, this.f11496e);
        b.b(parcel, a2);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f11492a), Long.valueOf(this.f11493b), Float.valueOf(this.f11494c), Long.valueOf(this.f11495d), Integer.valueOf(this.f11496e)});
    }
}
