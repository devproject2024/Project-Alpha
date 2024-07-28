package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public final class CameraPosition extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CameraPosition> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    public final LatLng f11559a;

    /* renamed from: b  reason: collision with root package name */
    public final float f11560b;

    /* renamed from: c  reason: collision with root package name */
    public final float f11561c;

    /* renamed from: d  reason: collision with root package name */
    public final float f11562d;

    public CameraPosition(LatLng latLng, float f2, float f3, float f4) {
        s.a(latLng, (Object) "null camera target");
        s.b(0.0f <= f3 && f3 <= 90.0f, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f3));
        this.f11559a = latLng;
        this.f11560b = f2;
        this.f11561c = f3 + 0.0f;
        this.f11562d = (((double) f4) <= 0.0d ? (f4 % 360.0f) + 360.0f : f4) % 360.0f;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public LatLng f11563a;

        /* renamed from: b  reason: collision with root package name */
        public float f11564b;

        /* renamed from: c  reason: collision with root package name */
        public float f11565c;

        /* renamed from: d  reason: collision with root package name */
        public float f11566d;

        public final a a(LatLng latLng) {
            this.f11563a = latLng;
            return this;
        }

        public final a a() {
            this.f11564b = 17.0f;
            return this;
        }

        public final a b() {
            this.f11565c = 30.0f;
            return this;
        }

        public final a c() {
            this.f11566d = 90.0f;
            return this;
        }

        public final CameraPosition d() {
            return new CameraPosition(this.f11563a, this.f11564b, this.f11565c, this.f11566d);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11559a, Float.valueOf(this.f11560b), Float.valueOf(this.f11561c), Float.valueOf(this.f11562d)});
    }

    public static a a() {
        return new a();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.f11559a.equals(cameraPosition.f11559a) && Float.floatToIntBits(this.f11560b) == Float.floatToIntBits(cameraPosition.f11560b) && Float.floatToIntBits(this.f11561c) == Float.floatToIntBits(cameraPosition.f11561c) && Float.floatToIntBits(this.f11562d) == Float.floatToIntBits(cameraPosition.f11562d);
    }

    public final String toString() {
        return q.a((Object) this).a("target", this.f11559a).a("zoom", Float.valueOf(this.f11560b)).a("tilt", Float.valueOf(this.f11561c)).a("bearing", Float.valueOf(this.f11562d)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f11559a, i2, false);
        b.a(parcel, 3, this.f11560b);
        b.a(parcel, 4, this.f11561c);
        b.a(parcel, 5, this.f11562d);
        b.b(parcel, a2);
    }
}
