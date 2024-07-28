package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    final int f11465a;

    /* renamed from: b  reason: collision with root package name */
    final int f11466b;

    public zzb(int i2, int i3) {
        this.f11465a = i2;
        this.f11466b = i3;
    }

    public final String toString() {
        return q.a((Object) this).a("offset", Integer.valueOf(this.f11465a)).a("length", Integer.valueOf(this.f11466b)).toString();
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f11465a), Integer.valueOf(this.f11466b)});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzb)) {
            return false;
        }
        zzb zzb = (zzb) obj;
        return q.a(Integer.valueOf(this.f11465a), Integer.valueOf(zzb.f11465a)) && q.a(Integer.valueOf(this.f11466b), Integer.valueOf(zzb.f11466b));
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f11465a);
        b.b(parcel, 2, this.f11466b);
        b.b(parcel, a2);
    }
}
