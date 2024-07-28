package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public class StreetViewPanoramaLink extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaLink> CREATOR = new s();

    /* renamed from: a  reason: collision with root package name */
    public final String f11636a;

    /* renamed from: b  reason: collision with root package name */
    public final float f11637b;

    public StreetViewPanoramaLink(String str, float f2) {
        this.f11636a = str;
        this.f11637b = (((double) f2) <= 0.0d ? (f2 % 360.0f) + 360.0f : f2) % 360.0f;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11636a, Float.valueOf(this.f11637b)});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) obj;
        return this.f11636a.equals(streetViewPanoramaLink.f11636a) && Float.floatToIntBits(this.f11637b) == Float.floatToIntBits(streetViewPanoramaLink.f11637b);
    }

    public String toString() {
        return q.a((Object) this).a("panoId", this.f11636a).a("bearing", Float.valueOf(this.f11637b)).toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f11636a, false);
        b.a(parcel, 3, this.f11637b);
        b.b(parcel, a2);
    }
}
