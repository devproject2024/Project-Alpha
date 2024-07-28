package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.Arrays;

public class StreetViewPanoramaLocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaLocation> CREATOR = new t();

    /* renamed from: a  reason: collision with root package name */
    public final StreetViewPanoramaLink[] f11638a;

    /* renamed from: b  reason: collision with root package name */
    public final LatLng f11639b;

    /* renamed from: c  reason: collision with root package name */
    public final String f11640c;

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this.f11638a = streetViewPanoramaLinkArr;
        this.f11639b = latLng;
        this.f11640c = str;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11639b, this.f11640c});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
        return this.f11640c.equals(streetViewPanoramaLocation.f11640c) && this.f11639b.equals(streetViewPanoramaLocation.f11639b);
    }

    public String toString() {
        return q.a((Object) this).a("panoId", this.f11640c).a(CLPConstants.ARGUMENT_KEY_POSITION, this.f11639b.toString()).toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, (T[]) this.f11638a, i2);
        b.a(parcel, 3, this.f11639b, i2, false);
        b.a(parcel, 4, this.f11640c, false);
        b.b(parcel, a2);
    }
}
