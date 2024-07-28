package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public final class zzak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzak> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final PlaceEntity f11445a;

    /* renamed from: b  reason: collision with root package name */
    private final float f11446b;

    zzak(PlaceEntity placeEntity, float f2) {
        this.f11445a = placeEntity;
        this.f11446b = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzak)) {
            return false;
        }
        zzak zzak = (zzak) obj;
        return this.f11445a.equals(zzak.f11445a) && this.f11446b == zzak.f11446b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11445a, Float.valueOf(this.f11446b)});
    }

    public final String toString() {
        return q.a((Object) this).a("place", this.f11445a).a("likelihood", Float.valueOf(this.f11446b)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11445a, i2, false);
        b.a(parcel, 2, this.f11446b);
        b.b(parcel, a2);
    }
}
