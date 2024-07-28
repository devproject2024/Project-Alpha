package com.google.android.gms.internal.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;
import java.util.List;

@Deprecated
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final String f10971a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10972b;

    /* renamed from: c  reason: collision with root package name */
    private final List<zzg> f10973c;

    zzi(String str, String str2, List<zzg> list) {
        this.f10971a = str;
        this.f10972b = str2;
        this.f10973c = list;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10971a, this.f10972b, this.f10973c});
    }

    public final String toString() {
        return q.a((Object) this).a("accountName", this.f10971a).a("placeId", this.f10972b).a("placeAliases", this.f10973c).toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzi)) {
            return false;
        }
        zzi zzi = (zzi) obj;
        return this.f10971a.equals(zzi.f10971a) && this.f10972b.equals(zzi.f10972b) && this.f10973c.equals(zzi.f10973c);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f10971a, false);
        b.a(parcel, 2, this.f10972b, false);
        b.a(parcel, 6, this.f10973c, false);
        b.b(parcel, a2);
    }
}
