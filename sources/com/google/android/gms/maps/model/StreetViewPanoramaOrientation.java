package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public class StreetViewPanoramaOrientation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOrientation> CREATOR = new u();

    /* renamed from: a  reason: collision with root package name */
    public final float f11641a;

    /* renamed from: b  reason: collision with root package name */
    public final float f11642b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public float f11643a;

        /* renamed from: b  reason: collision with root package name */
        public float f11644b;
    }

    public StreetViewPanoramaOrientation(float f2, float f3) {
        boolean z = -90.0f <= f2 && f2 <= 90.0f;
        StringBuilder sb = new StringBuilder(62);
        sb.append("Tilt needs to be between -90 and 90 inclusive: ");
        sb.append(f2);
        s.b(z, sb.toString());
        this.f11641a = f2 + 0.0f;
        this.f11642b = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f11641a), Float.valueOf(this.f11642b)});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaOrientation)) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) obj;
        return Float.floatToIntBits(this.f11641a) == Float.floatToIntBits(streetViewPanoramaOrientation.f11641a) && Float.floatToIntBits(this.f11642b) == Float.floatToIntBits(streetViewPanoramaOrientation.f11642b);
    }

    public String toString() {
        return q.a((Object) this).a("tilt", Float.valueOf(this.f11641a)).a("bearing", Float.valueOf(this.f11642b)).toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f11641a);
        b.a(parcel, 3, this.f11642b);
        b.b(parcel, a2);
    }
}
