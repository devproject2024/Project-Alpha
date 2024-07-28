package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import java.util.Arrays;

public class StreetViewPanoramaCamera extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaCamera> CREATOR = new r();

    /* renamed from: a  reason: collision with root package name */
    public final float f11632a;

    /* renamed from: b  reason: collision with root package name */
    public final float f11633b;

    /* renamed from: c  reason: collision with root package name */
    public final float f11634c;

    /* renamed from: d  reason: collision with root package name */
    private final StreetViewPanoramaOrientation f11635d;

    public StreetViewPanoramaCamera(float f2, float f3, float f4) {
        boolean z = -90.0f <= f3 && f3 <= 90.0f;
        StringBuilder sb = new StringBuilder(62);
        sb.append("Tilt needs to be between -90 and 90 inclusive: ");
        sb.append(f3);
        s.b(z, sb.toString());
        this.f11632a = ((double) f2) <= 0.0d ? 0.0f : f2;
        this.f11633b = 0.0f + f3;
        this.f11634c = (((double) f4) <= 0.0d ? (f4 % 360.0f) + 360.0f : f4) % 360.0f;
        StreetViewPanoramaOrientation.a aVar = new StreetViewPanoramaOrientation.a();
        aVar.f11644b = f3;
        aVar.f11643a = f4;
        this.f11635d = new StreetViewPanoramaOrientation(aVar.f11644b, aVar.f11643a);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f11632a), Float.valueOf(this.f11633b), Float.valueOf(this.f11634c)});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
        return Float.floatToIntBits(this.f11632a) == Float.floatToIntBits(streetViewPanoramaCamera.f11632a) && Float.floatToIntBits(this.f11633b) == Float.floatToIntBits(streetViewPanoramaCamera.f11633b) && Float.floatToIntBits(this.f11634c) == Float.floatToIntBits(streetViewPanoramaCamera.f11634c);
    }

    public String toString() {
        return q.a((Object) this).a("zoom", Float.valueOf(this.f11632a)).a("tilt", Float.valueOf(this.f11633b)).a("bearing", Float.valueOf(this.f11634c)).toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f11632a);
        b.a(parcel, 3, this.f11633b);
        b.a(parcel, 4, this.f11634c);
        b.b(parcel, a2);
    }
}
