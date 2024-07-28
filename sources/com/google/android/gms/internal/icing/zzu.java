package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzu> CREATOR = new fr();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f10324a;

    public zzu(boolean z) {
        this.f10324a = z;
    }

    public final int hashCode() {
        return this.f10324a ? 1 : 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzu) && this.f10324a == ((zzu) obj).f10324a;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f10324a);
        b.b(parcel, a2);
    }
}
