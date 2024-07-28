package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    public int f11341a;

    /* renamed from: b  reason: collision with root package name */
    public float f11342b;

    /* renamed from: c  reason: collision with root package name */
    private int f11343c;

    /* renamed from: d  reason: collision with root package name */
    private long f11344d;

    /* renamed from: e  reason: collision with root package name */
    private long f11345e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11346f;

    /* renamed from: g  reason: collision with root package name */
    private long f11347g;

    /* renamed from: h  reason: collision with root package name */
    private long f11348h;

    public LocationRequest() {
        this.f11343c = 102;
        this.f11344d = 3600000;
        this.f11345e = 600000;
        this.f11346f = false;
        this.f11347g = Long.MAX_VALUE;
        this.f11341a = Integer.MAX_VALUE;
        this.f11342b = 0.0f;
        this.f11348h = 0;
    }

    LocationRequest(int i2, long j, long j2, boolean z, long j3, int i3, float f2, long j4) {
        this.f11343c = i2;
        this.f11344d = j;
        this.f11345e = j2;
        this.f11346f = z;
        this.f11347g = j3;
        this.f11341a = i3;
        this.f11342b = f2;
        this.f11348h = j4;
    }

    public static LocationRequest a() {
        return new LocationRequest();
    }

    private static void c(long j) {
        if (j < 0) {
            StringBuilder sb = new StringBuilder(38);
            sb.append("invalid interval: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private long d() {
        long j = this.f11348h;
        long j2 = this.f11344d;
        return j < j2 ? j2 : j;
    }

    public final LocationRequest a(int i2) {
        if (i2 == 100 || i2 == 102 || i2 == 104 || i2 == 105) {
            this.f11343c = i2;
            return this;
        }
        StringBuilder sb = new StringBuilder(28);
        sb.append("invalid quality: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public final LocationRequest a(long j) {
        c(j);
        this.f11344d = j;
        if (!this.f11346f) {
            this.f11345e = (long) (((double) this.f11344d) / 6.0d);
        }
        return this;
    }

    public final LocationRequest b() {
        this.f11341a = 1;
        return this;
    }

    public final LocationRequest b(long j) {
        c(j);
        this.f11346f = true;
        this.f11345e = j;
        return this;
    }

    public final LocationRequest c() {
        this.f11342b = 0.0f;
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.f11343c == locationRequest.f11343c && this.f11344d == locationRequest.f11344d && this.f11345e == locationRequest.f11345e && this.f11346f == locationRequest.f11346f && this.f11347g == locationRequest.f11347g && this.f11341a == locationRequest.f11341a && this.f11342b == locationRequest.f11342b && d() == locationRequest.d();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        int i2 = this.f11343c;
        sb.append(i2 != 100 ? i2 != 102 ? i2 != 104 ? i2 != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        if (this.f11343c != 105) {
            sb.append(" requested=");
            sb.append(this.f11344d);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.f11345e);
        sb.append("ms");
        if (this.f11348h > this.f11344d) {
            sb.append(" maxWait=");
            sb.append(this.f11348h);
            sb.append("ms");
        }
        if (this.f11342b > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(this.f11342b);
            sb.append("m");
        }
        long j = this.f11347g;
        if (j != Long.MAX_VALUE) {
            sb.append(" expireIn=");
            sb.append(j - SystemClock.elapsedRealtime());
            sb.append("ms");
        }
        if (this.f11341a != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f11341a);
        }
        sb.append(']');
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f11343c);
        b.a(parcel, 2, this.f11344d);
        b.a(parcel, 3, this.f11345e);
        b.a(parcel, 4, this.f11346f);
        b.a(parcel, 5, this.f11347g);
        b.b(parcel, 6, this.f11341a);
        b.a(parcel, 7, this.f11342b);
        b.a(parcel, 8, this.f11348h);
        b.b(parcel, a2);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f11343c), Long.valueOf(this.f11344d), Float.valueOf(this.f11342b), Long.valueOf(this.f11348h)});
    }
}
