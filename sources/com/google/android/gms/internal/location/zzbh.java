package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Locale;

public final class zzbh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbh> CREATOR = new y();

    /* renamed from: a  reason: collision with root package name */
    private final String f10416a;

    /* renamed from: b  reason: collision with root package name */
    private final long f10417b;

    /* renamed from: c  reason: collision with root package name */
    private final short f10418c;

    /* renamed from: d  reason: collision with root package name */
    private final double f10419d;

    /* renamed from: e  reason: collision with root package name */
    private final double f10420e;

    /* renamed from: f  reason: collision with root package name */
    private final float f10421f;

    /* renamed from: g  reason: collision with root package name */
    private final int f10422g;

    /* renamed from: h  reason: collision with root package name */
    private final int f10423h;

    /* renamed from: i  reason: collision with root package name */
    private final int f10424i;

    public zzbh(String str, int i2, short s, double d2, double d3, float f2, long j, int i3, int i4) {
        if (str == null || str.length() > 100) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "requestId is null or too long: ".concat(valueOf) : new String("requestId is null or too long: "));
        } else if (f2 <= 0.0f) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("invalid radius: ");
            sb.append(f2);
            throw new IllegalArgumentException(sb.toString());
        } else if (d2 > 90.0d || d2 < -90.0d) {
            StringBuilder sb2 = new StringBuilder(42);
            sb2.append("invalid latitude: ");
            sb2.append(d2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (d3 > 180.0d || d3 < -180.0d) {
            StringBuilder sb3 = new StringBuilder(43);
            sb3.append("invalid longitude: ");
            sb3.append(d3);
            throw new IllegalArgumentException(sb3.toString());
        } else {
            int i5 = i2 & 7;
            if (i5 != 0) {
                this.f10418c = s;
                this.f10416a = str;
                this.f10419d = d2;
                this.f10420e = d3;
                this.f10421f = f2;
                this.f10417b = j;
                this.f10422g = i5;
                this.f10423h = i3;
                this.f10424i = i4;
                return;
            }
            StringBuilder sb4 = new StringBuilder(46);
            sb4.append("No supported transition specified: ");
            sb4.append(i2);
            throw new IllegalArgumentException(sb4.toString());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzbh)) {
            return false;
        }
        zzbh zzbh = (zzbh) obj;
        return this.f10421f == zzbh.f10421f && this.f10419d == zzbh.f10419d && this.f10420e == zzbh.f10420e && this.f10418c == zzbh.f10418c;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f10419d);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f10420e);
        return ((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.f10421f)) * 31) + this.f10418c) * 31) + this.f10422g;
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[9];
        objArr[0] = this.f10418c != 1 ? null : "CIRCLE";
        objArr[1] = this.f10416a.replaceAll("\\p{C}", "?");
        objArr[2] = Integer.valueOf(this.f10422g);
        objArr[3] = Double.valueOf(this.f10419d);
        objArr[4] = Double.valueOf(this.f10420e);
        objArr[5] = Float.valueOf(this.f10421f);
        objArr[6] = Integer.valueOf(this.f10423h / 1000);
        objArr[7] = Integer.valueOf(this.f10424i);
        objArr[8] = Long.valueOf(this.f10417b);
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f10416a, false);
        b.a(parcel, 2, this.f10417b);
        short s = this.f10418c;
        b.a(parcel, 3, 4);
        parcel.writeInt(s);
        b.a(parcel, 4, this.f10419d);
        b.a(parcel, 5, this.f10420e);
        b.a(parcel, 6, this.f10421f);
        b.b(parcel, 7, this.f10422g);
        b.b(parcel, 8, this.f10423h);
        b.b(parcel, 9, this.f10424i);
        b.b(parcel, a2);
    }
}
