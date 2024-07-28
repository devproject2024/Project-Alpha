package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationResult> CREATOR = new l();

    /* renamed from: a  reason: collision with root package name */
    static final List<Location> f11349a = Collections.emptyList();

    /* renamed from: b  reason: collision with root package name */
    public final List<Location> f11350b;

    LocationResult(List<Location> list) {
        this.f11350b = list;
    }

    public final Location a() {
        int size = this.f11350b.size();
        if (size == 0) {
            return null;
        }
        return this.f11350b.get(size - 1);
    }

    public final List<Location> b() {
        return this.f11350b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.f11350b.size() != this.f11350b.size()) {
            return false;
        }
        Iterator<Location> it2 = this.f11350b.iterator();
        for (Location time : locationResult.f11350b) {
            if (it2.next().getTime() != time.getTime()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 17;
        for (Location time : this.f11350b) {
            long time2 = time.getTime();
            i2 = (i2 * 31) + ((int) (time2 ^ (time2 >>> 32)));
        }
        return i2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f11350b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("LocationResult[locations: ");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11350b, false);
        b.b(parcel, a2);
    }
}
