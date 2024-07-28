package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public final class StreetViewSource extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewSource> CREATOR = new v();

    /* renamed from: a  reason: collision with root package name */
    public static final StreetViewSource f11645a = new StreetViewSource(0);

    /* renamed from: b  reason: collision with root package name */
    public static final StreetViewSource f11646b = new StreetViewSource(1);

    /* renamed from: c  reason: collision with root package name */
    private static final String f11647c = StreetViewSource.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private final int f11648d;

    public StreetViewSource(int i2) {
        this.f11648d = i2;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f11648d)});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StreetViewSource) && this.f11648d == ((StreetViewSource) obj).f11648d;
    }

    public final String toString() {
        String str;
        int i2 = this.f11648d;
        if (i2 == 0) {
            str = "DEFAULT";
        } else if (i2 != 1) {
            str = String.format("UNKNOWN(%s)", new Object[]{Integer.valueOf(i2)});
        } else {
            str = "OUTDOOR";
        }
        return String.format("StreetViewSource:%s", new Object[]{str});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 2, this.f11648d);
        b.b(parcel, a2);
    }
}
