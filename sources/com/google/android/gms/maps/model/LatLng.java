package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public final class LatLng extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLng> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    public final double f11593a;

    /* renamed from: b  reason: collision with root package name */
    public final double f11594b;

    public LatLng(double d2, double d3) {
        if (-180.0d > d3 || d3 >= 180.0d) {
            this.f11594b = ((((d3 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.f11594b = d3;
        }
        this.f11593a = Math.max(-90.0d, Math.min(90.0d, d2));
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f11593a);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f11594b);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.f11593a) == Double.doubleToLongBits(latLng.f11593a) && Double.doubleToLongBits(this.f11594b) == Double.doubleToLongBits(latLng.f11594b);
    }

    public final String toString() {
        double d2 = this.f11593a;
        double d3 = this.f11594b;
        StringBuilder sb = new StringBuilder(60);
        sb.append("lat/lng: (");
        sb.append(d2);
        sb.append(AppConstants.COMMA);
        sb.append(d3);
        sb.append(")");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f11593a);
        b.a(parcel, 3, this.f11594b);
        b.b(parcel, a2);
    }
}
