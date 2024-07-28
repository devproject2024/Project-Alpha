package com.google.android.gms.internal.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

@Deprecated
public final class zzg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzg> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private static final zzg f10968a = new zzg("Home");

    /* renamed from: b  reason: collision with root package name */
    private static final zzg f10969b = new zzg("Work");

    /* renamed from: c  reason: collision with root package name */
    private final String f10970c;

    zzg(String str) {
        this.f10970c = str;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10970c});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzg)) {
            return false;
        }
        return q.a(this.f10970c, ((zzg) obj).f10970c);
    }

    public final String toString() {
        return q.a((Object) this).a("alias", this.f10970c).toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f10970c, false);
        b.b(parcel, a2);
    }
}
